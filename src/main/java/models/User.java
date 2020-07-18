package models;

public class User {
    private String username;
    private int departmentid;
    private String role;

    public User(String username, int departmentid, String role) {
        this.username = username;
        this.departmentid = departmentid;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public int getDepartmentId() {
        return departmentid;
    }

    public String getRole() {
        return role;
    }
}