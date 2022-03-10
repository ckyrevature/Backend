package dao;

import models.ReimbursementsModel;

import java.util.List;

public interface ReimbursementDao {

  ReimbursementsModel addReimbursementsCase(ReimbursementsModel reimbursement);

  List<ReimbursementsModel> employeeCheckReimList(int userid , int statusid);

  List<ReimbursementsModel> getReimbursementList(int userid , int statusid);

  List<ReimbursementsModel> viewReimbursement(int statusid);

  List<ReimbursementsModel> viewAllReimbursement();

  ReimbursementsModel updateReimbursementsCase(ReimbursementsModel reimbursement);

}
