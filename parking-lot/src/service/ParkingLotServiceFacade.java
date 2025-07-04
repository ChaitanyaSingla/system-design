package service;

import enums.ParkingSpotType;
import enums.PaymentMode;
import model.ParkingTicket;
import model.actors.Admin;
import model.actors.ParkingAttendant;
import model.vehicle.Vehicle;
import service.impl.AdminService;
import service.impl.ParkingAttendantService;
import service.impl.ParkingTicketService;
import service.interfaces.IAdminService;
import service.interfaces.IParkingAttendantService;
import service.interfaces.IParkingTicketService;

public class ParkingLotServiceFacade {

    private static final IParkingTicketService parkingTicketService = ParkingTicketService.getInstance();
    private static final IParkingAttendantService parkingAttendantService = ParkingAttendantService.getInstance();
    private static final IAdminService adminService = AdminService.getInstance();

    public ParkingTicket getNewParkingTicket(final Vehicle vehicle) throws Exception {
        return parkingTicketService.assignTicket(vehicle);
    }

    public ParkingTicket processParkingTicket(final String userName, final int ticketNumber, final PaymentMode paymentMode) throws Exception {
        return parkingAttendantService.payParkingTicket(userName, ticketNumber, paymentMode);
    }

    public void createParkingAttendant(final String username) {
        parkingAttendantService.createParkingAttendant(username);
    }

    public ParkingAttendant getParkingAttendant(final String username) throws Exception {
        return parkingAttendantService.getParkingAttendant(username);
    }

    public void createAdmin(final String username) {
        adminService.createAdmin(username);
    }

    public Admin getAdmin(final String username) throws Exception {
        return adminService.getAdmin(username);
    }

    public void addSpotCount(final String username, final ParkingSpotType parkingSpotType, final int spotCount) throws Exception {
        adminService.addSpotCount(username, parkingSpotType, spotCount);
    }

    public void removeSpotCount(final String username, final ParkingSpotType parkingSpotType, final int spotCount) throws Exception {
        adminService.removeSpotCount(username, parkingSpotType, spotCount);
    }
}
