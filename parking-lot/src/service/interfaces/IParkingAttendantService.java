package service.interfaces;

import enums.PaymentMode;
import model.ParkingTicket;
import model.actors.ParkingAttendant;

public interface IParkingAttendantService {

    void createParkingAttendant(String username);

    ParkingAttendant getParkingAttendant(String username) throws Exception;

    ParkingTicket payParkingTicket(final String username, final int ticketNumber, final PaymentMode paymentMode) throws Exception;

}
