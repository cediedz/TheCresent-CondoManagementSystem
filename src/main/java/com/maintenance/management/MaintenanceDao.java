package com.maintenance.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceDao {
    private Connection connection;

    public MaintenanceDao(Connection connection) {
        this.connection = connection;
    }

    public void addMaintenanceRequest(MaintenanceRequest request) throws SQLException {
        String sql = "INSERT INTO maintenance (unit_number, status, description, request_status) VALUES (?, ?, ?, 'pending')";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, request.getUnitNumber());
            preparedStatement.setString(2, request.getStatus());
            preparedStatement.setString(3, request.getDescription());
            preparedStatement.executeUpdate();
        }
    }

    public List<MaintenanceRequest> getAllMaintenanceRequests() throws SQLException {
        List<MaintenanceRequest> maintenanceRequests = new ArrayList<>();
        String sql = "SELECT * FROM maintenance";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String unitNumber = resultSet.getString("unit_number");
                String status = resultSet.getString("status");
                String description = resultSet.getString("description");
                String requestStatus = resultSet.getString("request_status");
                maintenanceRequests.add(new MaintenanceRequest(id, unitNumber, status, description, requestStatus));
            }
        }
        return maintenanceRequests;
    }
}
