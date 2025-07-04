package dao.impl;

import dao.interfaces.IParkingRateDao;
import model.ParkingRate;

public class ParkingRateDao implements IParkingRateDao {

    private static final ParkingRateDao parkingTicketDao = new ParkingRateDao();

    public static ParkingRateDao getInstance() {
        return parkingTicketDao;
    }

    private static final ParkingRate parkingRate = new ParkingRate(20);

    public int getParkingRate() {
        return parkingRate.getRate();
    }

}
