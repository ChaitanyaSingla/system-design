package dao.interfaces;

import model.ParkingTicket;

public interface IParkingTicketDao {

    ParkingTicket getParkingTicketByTicketNumber(int ticketNumber) throws Exception;

    void insertParkingTicket(ParkingTicket parkingTicket);

    void updateParkingTicket(ParkingTicket parkingTicket);

    int getParkingTicketCounter();

    void incrementParkingTicketCounter();

    ParkingTicket getParkingTicketByLicenseNumber(String licenseNumber) throws Exception;

}
