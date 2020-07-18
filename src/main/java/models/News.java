package models;

public class News {
    private String topic;
    private String description;
    private int departmentid;
    private int id;

    public News(String topic, String description, int departmentid) {
        this.topic = topic;
        this.description = description;
        this.departmentid = departmentid;
    }

    public String getNewsTopic() {
        return topic;
    }

    public String getNewsDescription() {
        return description;
    }

    public int getDepartmentId() {
        return departmentid;
    }

    public void setNewsTopic(String topic) {
         this.topic = topic;
    }

    public void setNewsDescription(String description) {
        this.description = description;
    }

    public void setDepartmentId(int departmentid) {
        this.departmentid = departmentid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
