package dao;

import models.Department;
import java.util.List;

public interface DepartmentDao {

    //create
    void add(Department department);
    //void addDepartmentToNews(Department department, News news);

    //read
    List<Department> getAll();
    //List<News> getAllNewsForDepartments(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
