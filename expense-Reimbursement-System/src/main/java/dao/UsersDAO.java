package dao;

import models.UsersModel;

import java.sql.SQLException;
import java.util.List;

public interface UsersDAO {

    UsersModel checkLogin(String uname, String upass) throws SQLException;

    String getUserName(String uname) throws SQLException;

    UsersModel getPassword(String password) throws SQLException;

    UsersModel getUser(String uname, String upass) throws SQLException;

    UsersModel addUser(UsersModel user) throws SQLException;

    List<UsersModel> viewInfo (UsersModel user);

    UsersModel updateUser(UsersModel user);
}
