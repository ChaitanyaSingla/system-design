package dao.interfaces;

import enums.ParkingSpotType;
import enums.VehicleType;

public interface IParkingLotDao {

    boolean isFull(VehicleType vehicleType);

    void incrementSpotCount(VehicleType vehicleType);

    void addMaxSpotCount(ParkingSpotType parkingSpotType, int addSpots);

    void removeMaxSpotCount(ParkingSpotType parkingSpotType, int removeSpots);

}
