package com.announcement.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementDao {
    private Connection connection;

    public AnnouncementDao(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
        try {
            // Establish the database connection
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.");
        }
    }

    // Add a new announcement to the database
    public void addAnnouncement(Announcement announcement) throws SQLException {
        String sql = "INSERT INTO announcements (title, content, timestamp) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, announcement.getTitle());
            preparedStatement.setString(2, announcement.getContent());
            preparedStatement.setTimestamp(3, announcement.getTimestamp()); // Set the timestamp
            preparedStatement.executeUpdate();
        }
    }

    // Retrieve all announcements from the database
    public List<Announcement> getAllAnnouncements() throws SQLException {
        List<Announcement> announcements = new ArrayList<>();
        String sql = "SELECT * FROM announcements";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Timestamp timestamp = resultSet.getTimestamp("timestamp"); // Get the timestamp
                Announcement announcement = new Announcement(id, title, content, timestamp);
                announcements.add(announcement);
            }
        }
        return announcements;
    }

    // Implement other methods as needed, e.g., updateAnnouncement, deleteAnnouncement, etc.
}
