package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void userIntantiatesCorrectly() {
        User user = new User ("Gideon",1, "Maintains System");
        assertEquals(true, user instanceof User);
    }

}