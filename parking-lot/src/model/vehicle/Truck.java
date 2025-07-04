package model.vehicle;

import enums.VehicleType;

public class Truck extends Vehicle {
    public Truck(final String licenseNumber) {
        super(licenseNumber, VehicleType.TRUCK);
    }
}
