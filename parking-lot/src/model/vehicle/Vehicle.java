package model.vehicle;

import enums.VehicleType;

public abstract class Vehicle {

    private String licenseNumber;
    private VehicleType vehicleType;

    public Vehicle(final String licenseNumber, final VehicleType vehicleType) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }

    //Getter
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
    
}
