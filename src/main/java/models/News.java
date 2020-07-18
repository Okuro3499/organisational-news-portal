package models;

public class News {
    private String topic;
    private final String description;
    private final int departmentid;

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
        { this.topic = topic;}
    }
}
