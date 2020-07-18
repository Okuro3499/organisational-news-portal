package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewsTest {
    @Test
    public void newsInstantiatesCorrectly(){
        News news = new News("Ps5", "Photos of Ps5 leaks ahead of release", 1);
        assertEquals(true, news instanceof News);
    }

    @Test
    public void getsNewsTopic() {
        News news = new News("Ps5", "Photos of Ps5 leaks ahead of release", 1);
        assertEquals("Ps5", news.getNewsTopic());
    }

    @Test
    public void getsNewsDescription() {
        News news = new News("Ps5", "Photos of Ps5 leaks ahead of release", 1);
        assertEquals("Photos of Ps5 leaks ahead of release", news.getNewsDescription());
    }
}