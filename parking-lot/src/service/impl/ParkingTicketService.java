package service.impl;

import dao.impl.ParkingLotDao;
import dao.impl.ParkingTicketDao;
import dao.interfaces.IParkingLotDao;
import dao.interfaces.IParkingTicketDao;
import model.ParkingTicket;
import model.vehicle.Vehicle;
import service.interfaces.IParkingTicketService;

import java.util.Date;

public class ParkingTicketService implements IParkingTicketService {

    private static final ParkingTicketService parkingTicketService = new ParkingTicketService();

    public static ParkingTicketService getInstance() {
        return parkingTicketService;
    }

    //Dao
    private static final IParkingLotDao parkingLotDao = ParkingLotDao.getInstance();
    private static final IParkingTicketDao parkingTicketDao = ParkingTicketDao.getInstance();

    public ParkingTicket assignTicket(final Vehicle vehicle) throws Exception {
        if (parkingLotDao.isFull(vehicle.getVehicleType())) {
            throw new Exception("Parking is full");
        }
        final ParkingTicket parkingTicket = new ParkingTicket(getNewTicketNumber(), new Date(), vehicle.getLicenseNumber());
        parkingTicketDao.insertParkingTicket(parkingTicket);
        parkingLotDao.incrementSpotCount(vehicle.getVehicleType());
        return parkingTicket;
    }

    public ParkingTicket getParkingTicketByLicenseNumber(final String licenseNumber) throws Exception {
        return parkingTicketDao.getParkingTicketByLicenseNumber(licenseNumber);
    }

    private int getNewTicketNumber() {
        final int newTicketNumber = parkingTicketDao.getParkingTicketCounter() + 1;
        parkingTicketDao.incrementParkingTicketCounter();
        return newTicketNumber;
    }

}
