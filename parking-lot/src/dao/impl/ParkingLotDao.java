package dao.impl;

import dao.interfaces.IParkingLotDao;
import enums.ParkingSpotType;
import enums.VehicleType;

public class ParkingLotDao implements IParkingLotDao {

    private static final ParkingLotDao parkingLotDao = new ParkingLotDao();

    public static ParkingLotDao getInstance() {
        return parkingLotDao;
    }

    private static int compactSpotCount;
    private static int maxCompactCount;
    private static int largeSpotCount;
    private static int maxLargeCount;

    public boolean isFull(final VehicleType vehicleType) {
        boolean isFull = false;
        if (vehicleType.equals(VehicleType.CAR)) {
            isFull = compactSpotCount >= maxCompactCount;
        } else if (vehicleType.equals(VehicleType.TRUCK)) {
            isFull = largeSpotCount >= maxLargeCount;
        }
        return isFull;
    }

    public void incrementSpotCount(final VehicleType vehicleType) {
        if (vehicleType.equals(VehicleType.CAR)) {
            compactSpotCount++;
        } else if (vehicleType.equals(VehicleType.TRUCK)) {
            largeSpotCount++;
        }
    }

    public void addMaxSpotCount(final ParkingSpotType parkingSpotType, final int addSpots) {
        if (parkingSpotType.equals(ParkingSpotType.COMPACT)) {
            maxCompactCount = maxCompactCount + addSpots;
        } else if (parkingSpotType.equals(parkingSpotType.LARGE)) {
            maxLargeCount = maxLargeCount + addSpots;
        }
    }

    public void removeMaxSpotCount(final ParkingSpotType parkingSpotType, final int removeSpots) {
        if (parkingSpotType.equals(ParkingSpotType.COMPACT)) {
            maxCompactCount = maxCompactCount - removeSpots;
        } else if (parkingSpotType.equals(parkingSpotType.LARGE)) {
            maxLargeCount = maxLargeCount - removeSpots;
        }
    }

}
