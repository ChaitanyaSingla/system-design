package service.impl;

import dao.impl.ParkingAttendantDao;
import dao.impl.ParkingRateDao;
import dao.impl.ParkingTicketDao;
import dao.impl.UserDao;
import dao.interfaces.IParkingAttendantDao;
import dao.interfaces.IParkingRateDao;
import dao.interfaces.IParkingTicketDao;
import dao.interfaces.IUserDao;
import enums.AccountStatus;
import enums.ParkingTicketStatus;
import enums.PaymentMode;
import enums.UserRole;
import model.ParkingTicket;
import model.actors.ParkingAttendant;
import service.interfaces.IParkingAttendantService;
import service.interfaces.IPaymentService;

import java.util.Date;

import static enums.ParkingTicketStatus.PAYMENT_IN_PROGRESS;

public class ParkingAttendantService implements IParkingAttendantService {

    private static ParkingAttendantService parkingAttendantService = new ParkingAttendantService();

    public static ParkingAttendantService getInstance() {
        return parkingAttendantService;
    }

    //Dao
    private static final IParkingTicketDao parkingTicketDao = ParkingTicketDao.getInstance();
    private static final IParkingAttendantDao parkingAttendantDao = ParkingAttendantDao.getInstance();
    private static final IParkingRateDao parkingRateDao = ParkingRateDao.getInstance();
    private static final IUserDao userDao = UserDao.getInstance();

    //Service
    private static final IPaymentService paymentService = PaymentService.getInstance();

    public void createParkingAttendant(final String username) {
        final ParkingAttendant parkingAttendant = new ParkingAttendant(username, AccountStatus.ACTIVE);
        parkingAttendantDao.insertParkingAttendant(parkingAttendant);
        userDao.insertUser(username, UserRole.USER);
    }

    public ParkingAttendant getParkingAttendant(final String username) throws Exception {
        return parkingAttendantDao.getParkingAttendantByUsername(username);
    }

    public ParkingTicket payParkingTicket(final String username, final int ticketNumber, final PaymentMode paymentMode) throws Exception {
        if (!userDao.getUserRole(username).equals(UserRole.USER)) {
            throw new Exception("User does not have the permission to pay the parking ticket");
        }
        final ParkingTicket parkingTicket = parkingTicketDao.getParkingTicketByTicketNumber(ticketNumber);
        final Date currentDate = new Date();
        final int parkingRate = parkingRateDao.getParkingRate();
        final int hourlyRate = currentDate.compareTo(parkingTicket.getIssuedAt()) * parkingRate;
        final int amountToBePaid = parkingRate + hourlyRate;

        parkingTicket.setParkingTicketStatus(PAYMENT_IN_PROGRESS);
        parkingTicketDao.updateParkingTicket(parkingTicket);
        
        paymentService.makePayment(paymentMode, amountToBePaid);

        parkingTicket.setPayedAmount(parkingRate + hourlyRate);
        parkingTicket.setPayedAt(currentDate);
        parkingTicket.setParkingTicketStatus(ParkingTicketStatus.PAID);
        parkingTicketDao.updateParkingTicket(parkingTicket);
        return parkingTicket;
    }
}
