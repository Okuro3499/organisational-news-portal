package dao;

import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;

import org.sql2o.Connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oNewsDaoTest {
    private Sql2oNewsDao newsDao;
    private Sql2oDepartmentDao departmentDao;
    private  Sql2oUserDao userDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingNewsSetsId() throws Exception {
        News testNews = setupNews();
        assertEquals(1, testNews.getId());
    }

    @Test
    public void addedNewsAreReturnedFromGetAll() throws Exception {
        News testNews = setupNews();
        assertEquals(1, newsDao.getAll().size());
    }


    //helpers
    public News setupNews() {
        News news= new News("Sushi", "New recipe Unveiled", 5);
        newsDao.add(news);
        return news;
    }
}