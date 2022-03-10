package service;

import models.ReimbursementsModel;
import models.UsersModel;

import java.sql.SQLException;
import java.util.List;

public interface FinanceManagerServices {

    ReimbursementsModel addCaseSuccess(ReimbursementsModel reimbursements);

    ReimbursementsModel updateReimbursement(ReimbursementsModel reimbursement);

    List<ReimbursementsModel> getAllReimbursement(int userid, int statusid);

    List<ReimbursementsModel> employeegetList(int userid, int statusid);

    List<ReimbursementsModel> getStatusList(int statusid);

    List<ReimbursementsModel> allEmployeeList();
}
