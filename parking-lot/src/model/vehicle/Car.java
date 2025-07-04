package model.vehicle;

import enums.VehicleType;

public class Car extends Vehicle {
    public Car(final String licenseNumber) {
        super(licenseNumber, VehicleType.CAR);
    }
}
