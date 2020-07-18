package models;

public class News {
    private final String topic;
    private final String description;

    public News(String topic, String description, int departmentid) {
        this.topic = topic;
        this.description = description;
    }

    public String getNewsTopic() {
        return topic;
    }

    public String getNewsDescription() {
        return description;
    }
}
