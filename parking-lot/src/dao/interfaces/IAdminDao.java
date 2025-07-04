package dao.interfaces;

import model.actors.Admin;

public interface IAdminDao {

    void insertAdmin(Admin admin);

    Admin getAdminByUsername(String username) throws Exception;

}
