package models;

public class Department {
    private String name;
    private String description;
    private int totalemployees;


    public Department(String name, String description, int totalemployees) {
        this.name = name;
        this.description = description;
        this.totalemployees= totalemployees;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getTotalEmployees() {
        return totalemployees;
    }

    public void setName(String name) {
        { this.name = name; }
    }

    public void setDescription(String description) {
        { this.description = description; }
    }

    public void setTotalEmployees(int totalemployees) {
        {this.totalemployees = totalemployees;}
    }
}
