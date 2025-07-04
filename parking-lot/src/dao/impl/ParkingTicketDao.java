package dao.impl;

import dao.interfaces.IParkingTicketDao;
import model.ParkingTicket;

import java.util.HashMap;
import java.util.Map;

public class ParkingTicketDao implements IParkingTicketDao {

    private static final ParkingTicketDao parkingTicketDao = new ParkingTicketDao();

    public static ParkingTicketDao getInstance() {
        return parkingTicketDao;
    }

    private static final Map<Integer, ParkingTicket> parkingNumberAndTicketMap = new HashMap<>();
    private static final Map<String, ParkingTicket> licenseNumberAndTicketMap = new HashMap<>();

    private static int ticketCounter = 0;

    public ParkingTicket getParkingTicketByTicketNumber(final int ticketNumber) throws Exception {
        if (!parkingNumberAndTicketMap.containsKey(ticketNumber)) {
            throw new Exception("Parking ticket not found");
        }
        return parkingNumberAndTicketMap.get(ticketNumber);
    }

    public void insertParkingTicket(final ParkingTicket parkingTicket) {
        parkingNumberAndTicketMap.put(parkingTicket.getTicketNumber(), parkingTicket);
        licenseNumberAndTicketMap.put(parkingTicket.getLicenseNumber(), parkingTicket);
    }

    public void updateParkingTicket(final ParkingTicket parkingTicket) {
        parkingNumberAndTicketMap.put(parkingTicket.getTicketNumber(), parkingTicket);
        licenseNumberAndTicketMap.put(parkingTicket.getLicenseNumber(), parkingTicket);
    }

    public int getParkingTicketCounter() {
        return ticketCounter;
    }

    public void incrementParkingTicketCounter() {
        ticketCounter++;
    }

    public ParkingTicket getParkingTicketByLicenseNumber(final String licenseNumber) throws Exception {
        if (!licenseNumberAndTicketMap.containsKey(licenseNumber)) {
            throw new Exception("Parking ticket not found");
        }
        return licenseNumberAndTicketMap.get(licenseNumber);
    }
}
