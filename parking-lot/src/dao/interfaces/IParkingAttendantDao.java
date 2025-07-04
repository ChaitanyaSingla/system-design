package dao.interfaces;

import model.actors.ParkingAttendant;

public interface IParkingAttendantDao {

    void insertParkingAttendant(ParkingAttendant parkingAttendant);

    ParkingAttendant getParkingAttendantByUsername(String username) throws Exception;

}
