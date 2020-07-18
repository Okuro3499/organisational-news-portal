package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewsTest {
    @Test
    public void newsInstantiatesCorrectly(){
        News news = new News("Ps5", "Photos of Ps5 leaks ahead of release", 1);
        assertEquals(true, news instanceof News);
    }

}