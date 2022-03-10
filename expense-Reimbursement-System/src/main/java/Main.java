import io.javalin.Javalin;
import models.ReimbursementsModel;
import models.UsersModel;
import service.FinanceManagerServiceslmpl;
import service.EmployeeServiceslmpl;

import java.util.List;

public class Main {
    public static void main (String[] args) {
        Javalin app = Javalin.create((config)->config.enableCorsForAllOrigins()).start(6060);
        EmployeeServiceslmpl usersServices = new EmployeeServiceslmpl();
        FinanceManagerServiceslmpl financeManagerServices = new FinanceManagerServiceslmpl();

        System.out.println("Server listening at part 5050.........");

        /*
        GET - fetch data - SELECT(DAO)
        DELETE - delete data - DELETE(DAO)
        POST - add data - INSERT(DAO)
        PUT - update data - update(DAO)
         */

        //check , check the user
        app.get("/api/checkusers/{users_name}/{password}" , (ctx) -> {
            String userName = ctx.pathParam("users_name");
            String password = ctx.pathParam("password");
            UsersModel checkLogin = usersServices.userLogin(userName, password);
            ctx.json(checkLogin);
        });

        /*
        //check username
        app.get("api/username/{users_name}" , (ctx) -> {
            String userName = ctx.pathParam("users_name");
            String checkName = usersServices.userNameLogin(userName);
            ctx.json(checkName);
        });

        //check password
        app.get("api/password/{password}" , (ctx) -> {
            String userPassword = ctx.pathParam("password");
            UsersModel checkPassword = usersServices.passwrodLogin(userPassword);
            ctx.json(checkPassword);
        });
         */
        //check password

        //check, for employee Submit a reimbursement request

        app.post("/api/submit/" , (ctx) -> {
            ReimbursementsModel newcase = ctx.bodyAsClass(ReimbursementsModel.class);
            ReimbursementsModel returnCase = financeManagerServices.addCaseSuccess(newcase);
            ctx.json(returnCase);
        });


        // check , for Employee Search Their Case Base On Status
        app.get("/api/esbos/{uid}/{statusid}" , (ctx) -> {
            String uid = ctx.pathParam("uid");
            String statusid = ctx.pathParam("statusid");
            List<ReimbursementsModel> returnCase = financeManagerServices.employeegetList(Integer.parseInt(uid) , Integer.parseInt(statusid));
            ctx.json(returnCase);
        });

        //check ,for Manager Search Specific Employee
        app.get("/api/msse/{uid}/{statusid}" , (ctx) -> {
            String uid = ctx.pathParam("uid");
            String statusid = ctx.pathParam("statusid");
            List<ReimbursementsModel> returnCase = financeManagerServices.getAllReimbursement(Integer.parseInt(uid) , Integer.parseInt(statusid));
            ctx.json(returnCase);
        });

        //check , for Manager Search Base On Status
        app.get("/api/msbons/{statusid}" , (ctx) -> {
            String statusid = ctx.pathParam("statusid");
            List<ReimbursementsModel> returnCase = financeManagerServices.getStatusList(Integer.parseInt(statusid));
            ctx.json(returnCase);
        });

        //check , for Manager Search All Employee
        app.get("/api/msae/" , (ctx) -> {
            List<ReimbursementsModel> returnCase = financeManagerServices.allEmployeeList();
            ctx.json(returnCase);
        });

        // update employee status by manager
        //need to work of it
        app.put("api/update", (ctx) -> {
            ReimbursementsModel updatecase = ctx.bodyAsClass(ReimbursementsModel.class);
            ReimbursementsModel returnUpdate = financeManagerServices.updateReimbursement(updatecase);
            ctx.json(returnUpdate);
        });

        // update user info by employee
        app.put("api/employeeupdate" , (ctx) -> {
            UsersModel updateemployee = ctx.bodyAsClass(UsersModel.class);
            UsersModel returnUpdate = usersServices.updateInfo(updateemployee);
            ctx.json(returnUpdate);
        });

    }
}

