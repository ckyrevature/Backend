package service;

import dao.ReimbursementDAOlmpl;
import dao.UsersDAOImpl;
import models.ReimbursementsModel;
import models.UsersModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceslmpl implements EmployeeServices{

        private UsersModel user = new UsersModel();
        private UsersDAOImpl usersDAO = new UsersDAOImpl();
        private ReimbursementDAOlmpl reimbursementDAOlmpl = new ReimbursementDAOlmpl();
        private ReimbursementsModel reimbursements = new ReimbursementsModel();

        //userLogin() check is user info valid or not by using UsersDAO getUser() method
        //else ,
        public UsersModel userLogin(String userName , String password) throws SQLException {
                return user = usersDAO.getUser(userName , password);
        }


        /*
        reimbursementsClaim() method take reimbursement class as the argument by using reimbursementDAO addReimbursementsCase() method
        if reimbursement claim is adding successfully , return true
        else , return false
         */


        public ReimbursementsModel reimbursementsClaim(ReimbursementsModel reimbursement) {
            return (reimbursementDAOlmpl.addReimbursementsCase(reimbursement));
        }

        /*
        addUserSuccess() method will add the new user,
        return true if adding successfully
        return false if adding unsuccessfully
        */
        public UsersModel addUserSuccess(UsersModel user) throws SQLException {
            return (usersDAO.addUser(user));
        }

        @Override
        public UsersModel updateInfo(UsersModel user) {
            return usersDAO.updateUser(user);
        }

    public List<ReimbursementsModel> allEmployeeList() {
        List<ReimbursementsModel> reimbursementsList = new ArrayList<ReimbursementsModel>();

        reimbursementsList = reimbursementDAOlmpl.viewAllReimbursement();

        return reimbursementsList;
    }



//------------------------------------------------------------------------------------------------------------------------------
        /*
        deleteReimbursements() method will check:
        if reimbursement claim is delete successfully , return true
        else , return false

        public boolean deleteReimbursements(ReimbursementsModel reimbursement) {
            boolean flag = false;
            if (reimbursementDAOlmpl.deleteReimbursementsCase(reimbursement)) {
                flag = true;
            }
            return flag;
        }

        //public boolean
         */

         /*
        public String userNameLogin(String userName) throws SQLException {
            String name = "";
            if (usersDAO.checkUserName(userName)) {
                name  = usersDAO.getUserName(userName);
            }else {
                name  = String.valueOf(new UsersModel());
            }
            return name;
        }

        public UsersModel passwrodLogin(String passwrod) throws SQLException {
            if (usersDAO.checkPassword(passwrod)) {
                user = usersDAO.getPassword(passwrod);
            }else {
                user = new UsersModel();
            }
            return user;
        }
        */
    }

