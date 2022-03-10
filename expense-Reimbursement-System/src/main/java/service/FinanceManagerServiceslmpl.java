package service;

import dao.ReimbursementDAOlmpl;
import dao.UsersDAOImpl;
import models.ReimbursementsModel;

import java.util.ArrayList;
import java.util.List;

    public class FinanceManagerServiceslmpl implements FinanceManagerServices{

        private ReimbursementDAOlmpl reimbursementDAOlmpl = new ReimbursementDAOlmpl();
        private UsersDAOImpl usersDAO = new UsersDAOImpl();


        public ReimbursementsModel addCaseSuccess(ReimbursementsModel reimbursements) {
        return reimbursementDAOlmpl.addReimbursementsCase(reimbursements);
        }

        /*
        updateReimbursement() method will update the status of the reimbursement
        by calling the Reimbursement DAO.
        If update successfully , return true
        else , return false
         */
        public ReimbursementsModel updateReimbursement(ReimbursementsModel reimbursement) {
            return reimbursementDAOlmpl.updateReimbursementsCase(reimbursement);
        }

        /*
        getAllReimbursement() method takes the user id and return the list of Reimbursement for the user
         */
        public List<ReimbursementsModel> getAllReimbursement(int userid, int statusid) {
            List<ReimbursementsModel> reimbursementsList = new ArrayList<ReimbursementsModel>();

            reimbursementsList = reimbursementDAOlmpl.getReimbursementList(userid, statusid);

            return reimbursementsList;
        }

        public List<ReimbursementsModel> employeegetList(int userid, int statusid) {
            List<ReimbursementsModel> employeeList = new ArrayList<ReimbursementsModel>();

            employeeList = reimbursementDAOlmpl.employeeCheckReimList(userid, statusid);

            return employeeList;

        }

        public List<ReimbursementsModel> getStatusList(int statusid) {
            List<ReimbursementsModel> reimbursementsList = new ArrayList<ReimbursementsModel>();

            reimbursementsList = reimbursementDAOlmpl.viewReimbursement(statusid);

            return reimbursementsList;
        }

        @Override
        public List<ReimbursementsModel> allEmployeeList() {
            List<ReimbursementsModel> reimbursementsList = new ArrayList<ReimbursementsModel>();

            reimbursementsList = reimbursementDAOlmpl.viewAllReimbursement();

            return reimbursementsList;
        }


//------------------------------------------------------------------------------------------------------
          /*
        checks if user is unique
        return true if is unique
        return false if isn't unique

        public boolean addUniqueUser(UsersModel user) {
            boolean flag = false;

            if (usersDAO.checkUniqueUser(user)) {
                if (usersDA.addUser(user)) {
                    flag = true;
                }
            }
            //System.out.println("(T/F) Is user unique? " + flag);
            return flag;
           */
    }




