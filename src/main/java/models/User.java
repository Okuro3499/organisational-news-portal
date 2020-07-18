package models;

public class User {
    private String username;

    public User(String username, int departmentid, String role) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
