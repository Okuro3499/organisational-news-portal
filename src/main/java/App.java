import com.google.gson.Gson;
import dao.Sql2oUserDao;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oNewsDao newsDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oUserDao userDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/Organisational-News-Portal.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        departmentDao= new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();

        post("/department/new", "application/json", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            departmentDao.add(department);
            response.status(201);
            response.type("application/json");
            return gson.toJson(department);
        });

        get("/department", "application/json", (request, response) -> {
            response.type("application/json");
            return gson.toJson(departmentDao.getAll());
        });

        get("/department/:id", "application/json",(request, response) -> {
            response.type("application/json");
            int departmentId = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(departmentDao.findById(departmentId));
        });
    }
}
