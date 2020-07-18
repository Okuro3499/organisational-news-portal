package models;

public class Department {
    private String name;
    private String description;
    private int totalemployees;


    public Department(String name, String description, int totalemployees) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
