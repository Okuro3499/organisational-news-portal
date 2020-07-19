package dao;

import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;

public class Sql2oUserDaoTest {
   private Connection conn;
   private Sql2oUserDao userDao;
   private Sql2oDepartmentDao departmentDao;
   private Sql2oNewsDao newsDao;

   @Before
   public void setUp() throws Exception {
      String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
      Sql2o sql2o = new Sql2o(connectionString, "", "");
      userDao = new Sql2oUserDao(sql2o);
      departmentDao = new Sql2oDepartmentDao(sql2o);
      newsDao = new Sql2oNewsDao(sql2o);
      conn = sql2o.open();
   }

   @After
   public void tearDown() throws Exception {
      conn.close();
   }

   @Test
   public void addingUserSetsId() throws Exception {
      User testUser = setupUser();
      assertEquals(1, testUser.getId());
   }

   //helpers
   public User setupUser() {
      User user = new User("Gideon", 1, "Maintains System");
      userDao.add(user);
      return user;
   }
}