package dao.interfaces;

import enums.UserRole;

public interface IUserDao {

    void insertUser(final String userName, final UserRole userRole);

    UserRole getUserRole(final String userName) throws Exception;

}
