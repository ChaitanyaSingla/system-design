package dao.impl;

import dao.interfaces.IParkingAttendantDao;
import model.actors.ParkingAttendant;

import java.util.HashMap;
import java.util.Map;

public class ParkingAttendantDao implements IParkingAttendantDao {

    private static final ParkingAttendantDao parkingAttendantDao = new ParkingAttendantDao();

    public static ParkingAttendantDao getInstance() {
        return parkingAttendantDao;
    }
    
    private static final Map<String, ParkingAttendant> usernameParkingAttendantMap = new HashMap<>();

    public void insertParkingAttendant(final ParkingAttendant parkingAttendant) {
        usernameParkingAttendantMap.put(parkingAttendant.getUserName(), parkingAttendant);
    }

    public ParkingAttendant getParkingAttendantByUsername(final String username) throws Exception {
        if (!usernameParkingAttendantMap.containsKey(username)) {
            throw new Exception("Parking Attendant Not Found");
        }
        return usernameParkingAttendantMap.get(username);
    }
}
