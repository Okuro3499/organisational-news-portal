package dao;

import models.Department;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;
    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Department department) {
        String sql = "INSERT INTO department (name,description,totalemployees) VALUES (:name,:description,:totalemployees)";
        try(Connection con =sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .addParameter("name",department.getDepartmentName())
                    .addParameter("description",department.getDepartmentDescription())
                    .addParameter("totalemployees",department.getTotalEmployees())
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Department> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM department")
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public Department findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM department WHERE id=:id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Department.class);
        }
    }

    @Override
    public List<User> getAllUsers(int departmentid) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users WHERE departmentid = :departmentId")
                    .addParameter("departmentId", departmentid)
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public List<News> getAllNewsForDepartments(int departmentId) {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news WHERE departmentid = :departmentId")
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from department WHERE id=:id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from department";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
