package dao;

import models.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertNotEquals;

public class Sql2oDepartmentDaoTest {
    private Connection conn;
    private Sql2oDepartmentDao DepartmentDao;
    private Sql2oNewsDao NewsDao;
    private Sql2oUserDao UserDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        DepartmentDao = new Sql2oDepartmentDao(sql2o);
        NewsDao= new Sql2oNewsDao(sql2o);
        UserDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        DepartmentDao.clearAll();
        UserDao.clearAll();
        NewsDao.clearAll();
    }

    @Test
    public void addingDepartmentSetsId() throws Exception {
        Department newdepartment = new Department("Finance","Maintain Financial Records",13);
        int originalDepartmentid = newdepartment.getId();
        DepartmentDao.add(newdepartment);
        assertNotEquals(originalDepartmentid, newdepartment.getId());
    }
}