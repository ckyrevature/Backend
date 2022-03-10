package dao;

import models.ReimbursementsModel;
import models.UsersModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAOImpl implements UsersDAO{
        public static final Logger LOG = LogManager.getLogger(UsersDAOImpl.class);
        private PreparedStatement ps;

        private DBUtil dbutil = DBUtil.getConnectionFactory();
        Connection connection = dbutil.getConnection();

        /*
        checkLogin() will check if:
        return true if username and password are valid
        return false if not valid
         */
        public UsersModel checkLogin(String uname, String upass) throws  SQLException{
            UsersModel user = new UsersModel();

                String sql = "SELECT * FROM users WHERE users_name = ? AND password = ?";

                ps = connection.prepareStatement(sql);
                ps.setString(1, uname);
                ps.setString(2, upass);

                ResultSet resultSet = ps.executeQuery();
                    if (resultSet.next()) {
                        user.setUserID(resultSet.getInt(1));
                        user.setUserName(resultSet.getString(2));
                        user.setUserPassword(resultSet.getString(3));
                        user.setFirstName(resultSet.getString(4));
                        user.setLastName(resultSet.getString(5));
                        user.setEmail(resultSet.getString(6));
                        user.setRoleID(resultSet.getInt(7));
                    }

            return user;
        }
/*

        /*
        getUser() method will get all the user details base on the username and password
         */
        public String getUserName(String uname) throws SQLException {
            String username = "";

            String sql = "SELECT * FROM users WHERE users_name = ? ";
            ps = connection.prepareStatement(sql);
            ps.setString(1, uname);

            ResultSet resultSet = ps.executeQuery();
            //adding info from database to Users class
            if (resultSet.next()) {
                username = resultSet.getString(2);
            }

            return username;
        }

    public UsersModel getPassword(String password) throws SQLException {
        UsersModel user = new UsersModel();

        String sql = "SELECT * FROM users WHERE password = ? ";
        ps = connection.prepareStatement(sql);
        ps.setString(1, password);

        ResultSet resultSet = ps.executeQuery();
        //adding info from database to Users class
        if (resultSet.next()) {
            user.setUserID(resultSet.getInt(1));
            user.setUserName(resultSet.getString(2));
            user.setUserPassword(resultSet.getString(3));
            user.setFirstName(resultSet.getString(4));
            user.setLastName(resultSet.getString(5));
            user.setEmail(resultSet.getString(6));
            user.setRoleID(resultSet.getInt(7));
        }

        return user;
    }


    public UsersModel getUser(String uname, String upass) throws SQLException {
        UsersModel user = new UsersModel();

        String sql = "SELECT * FROM users WHERE users_name = ? AND password = ?";
        ps = connection.prepareStatement(sql);
        ps.setString(1, uname);
        ps.setString(2, upass);


        ResultSet resultSet = ps.executeQuery();
        //adding info from database to Users class
        if (resultSet.next()) {
            user.setUserID(resultSet.getInt(1));
            user.setUserName(resultSet.getString(2));
            user.setUserPassword(resultSet.getString(3));
            user.setFirstName(resultSet.getString(4));
            user.setLastName(resultSet.getString(5));
            user.setEmail(resultSet.getString(6));
            user.setRoleID(resultSet.getInt(7));
        }

        return user;
    }


    @Override
    public UsersModel addUser(UsersModel user) throws SQLException {

        String sql = "INSERT INTO users (first_name , last_name , email , users_name , password , users_role_id) " +
                "values(? , ? , ? , ? , ? ,?)";

            ps = connection.prepareStatement(sql);

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getUserName());
            ps.setString(5, user.getUserPassword());
            ps.setInt(6, 1);

        return user;
    }


    public List<UsersModel> viewInfo (UsersModel user) {
        List<UsersModel> usersList = new ArrayList<UsersModel>();
        try {
            String sql =  "SELECT users_id , users_name , first_name, last_name , email FROM users";
            ps = connection.prepareStatement(sql);

            //adding info from database to user class
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                UsersModel users = new UsersModel();
                users.setUserID(resultSet.getInt(1));
                users.setUserName(resultSet.getString(2));
                users.setFirstName(resultSet.getString(3));
                users.setLastName(resultSet.getString(4));
                users.setEmail(resultSet.getString(5));
                usersList.add(users);
            }

            //sql = SELECT * FROM reimbursement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }


    @Override
    public UsersModel updateUser(UsersModel user) {
        try {
            String sql = "UPDATE users SET email = ? WHERE users_id = ?";

            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setInt(2 , user.getUserID());

            int resultSet = ps.executeUpdate();

        } catch (SQLException e) {
                e.printStackTrace();
            }
        return user;
    }

}

    //-----------------------------------------------------------------------------------------------------------------------------------------------
        /*
        /*
        checkUniqueUser() will check if:
        return true if it is new user
        return false if user already in the database
         */
    /*
        public Boolean checkUniqueUser(UsersModel user) {
            boolean flag = true;

            //We are checking username and user email. Are they already in the db?
            String sql = "SELECT * FROM users WHERE users_name = ? OR email = ?";

            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getEmail());

                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    flag = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
            return flag;
        }

        /*
        addUser() will add if:
        return true if user adding is successful
        return false if adding unsuccessful



    public UsersModel checkUserName (String uname) {
        UsersModel user = null;
        try {
            String sql = "SELECT * FROM users WHERE users_name = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, uname);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                user.setUserID(resultSet.getInt(1));
                user.setUserName(resultSet.getString(2));
                user.setUserPassword(resultSet.getString(3));
                user.setFirstName(resultSet.getString(4));
                user.setLastName(resultSet.getString(5));
                user.setEmail(resultSet.getString(6));
                user.setRoleID(resultSet.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public Boolean checkPassword (String password) {
        Boolean flag = false;

        try {
            String sql = "SELECT * FROM users WHERE password = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, password);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;}

     */

