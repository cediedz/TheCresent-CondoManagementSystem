package com.announcement.management;

import java.sql.Timestamp;

public class Announcement {
    private int id;
    private String title;
    private String content;
    private Timestamp timestamp; // Add this field for the timestamp

    public Announcement() {
    }

    public Announcement(int id, String title, String content, Timestamp timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp; // Initialize the timestamp field
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
