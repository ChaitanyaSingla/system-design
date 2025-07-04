package dao.impl;

import dao.interfaces.IUserDao;
import enums.UserRole;

import java.util.HashMap;
import java.util.Map;

public class UserDao implements IUserDao {

    private static final UserDao userDao = new UserDao();

    public static UserDao getInstance() {
        return userDao;
    }

    private static final Map<String, UserRole> userNameAndRoleMap = new HashMap<>();

    public void insertUser(final String userName, final UserRole userRole) {
        userNameAndRoleMap.put(userName, userRole);
    }

    public UserRole getUserRole(final String userName) throws Exception {
        if (!userNameAndRoleMap.containsKey(userName)) {
            throw new Exception("User not found");
        }
        return userNameAndRoleMap.get(userName);
    }

}
