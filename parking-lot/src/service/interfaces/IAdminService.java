package service.interfaces;

import enums.ParkingSpotType;
import model.actors.Admin;

public interface IAdminService {

    void createAdmin(String username);

    Admin getAdmin(String username) throws Exception;

    void addSpotCount(final String username, ParkingSpotType parkingSpotType, int spotCount) throws Exception;

    void removeSpotCount(final String username, ParkingSpotType parkingSpotType, int spotCount) throws Exception;

}
