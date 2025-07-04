package service.interfaces;

import model.ParkingTicket;
import model.vehicle.Vehicle;

public interface IParkingTicketService {

    ParkingTicket assignTicket(final Vehicle vehicle) throws Exception;

    ParkingTicket getParkingTicketByLicenseNumber(final String licenseNumber) throws Exception;

}
