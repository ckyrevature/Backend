package service;

import models.ReimbursementsModel;
import models.UsersModel;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeServices {

    UsersModel userLogin(String userName , String password) throws SQLException;

    ReimbursementsModel reimbursementsClaim(ReimbursementsModel reimbursement);

    UsersModel addUserSuccess(UsersModel user) throws SQLException;

    UsersModel updateInfo(UsersModel user);

    List<ReimbursementsModel> allEmployeeList();
}
