package service.impl;

import dao.impl.AdminDao;
import dao.impl.ParkingLotDao;
import dao.impl.UserDao;
import dao.interfaces.IAdminDao;
import dao.interfaces.IParkingLotDao;
import dao.interfaces.IUserDao;
import enums.AccountStatus;
import enums.ParkingSpotType;
import enums.UserRole;
import model.actors.Admin;
import service.interfaces.IAdminService;

public class AdminService implements IAdminService {

    private static AdminService adminService = new AdminService();

    public static AdminService getInstance() {
        return adminService;
    }

    //Dao
    private static final IAdminDao adminDao = AdminDao.getInstance();
    private static final IParkingLotDao parkingLotDao = ParkingLotDao.getInstance();
    private static final IUserDao userDao = UserDao.getInstance();

    public void createAdmin(final String username) {
        final Admin admin = new Admin(username, AccountStatus.ACTIVE);
        adminDao.insertAdmin(admin);
        userDao.insertUser(username, UserRole.ADMIN);
    }

    public Admin getAdmin(final String username) throws Exception {
        return adminDao.getAdminByUsername(username);
    }

    public void addSpotCount(final String username, final ParkingSpotType parkingSpotType, final int spotCount) throws Exception {
        if (!userDao.getUserRole(username).equals(UserRole.ADMIN)) {
            throw new Exception("User does not have the permission to add spot count");
        }
        parkingLotDao.addMaxSpotCount(parkingSpotType, spotCount);
    }

    public void removeSpotCount(final String username, final ParkingSpotType parkingSpotType, final int spotCount) throws Exception {
        if (!userDao.getUserRole(username).equals(UserRole.ADMIN)) {
            throw new Exception("User does not have the permission to remove spot count");
        }
        parkingLotDao.removeMaxSpotCount(parkingSpotType, spotCount);
    }
}
