package dao.impl;

import dao.interfaces.IAdminDao;
import model.actors.Admin;

import java.util.HashMap;
import java.util.Map;

public class AdminDao implements IAdminDao {

    private static final AdminDao adminDao = new AdminDao();
    private static final Map<String, Admin> usernameAdminMap = new HashMap<>();

    public static AdminDao getInstance() {
        return adminDao;
    }

    public void insertAdmin(final Admin admin) {
        usernameAdminMap.put(admin.getUserName(), admin);
    }

    public Admin getAdminByUsername(final String username) throws Exception {
        if (!usernameAdminMap.containsKey(username)) {
            throw new Exception("Admin Not Found");
        }
        return usernameAdminMap.get(username);
    }

}
