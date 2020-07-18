package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void userInstantiatesCorrectly() {
        User user = new User ("Gideon",1, "Maintains System");
        assertEquals(true, user instanceof User);
    }

    @Test
    public void getUsernameCorrectly() {
        User user = new User ("Gideon",1, "Maintains System");
        assertEquals("Gideon", user.getUsername());
    }

}