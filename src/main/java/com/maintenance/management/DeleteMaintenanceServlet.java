package com.maintenance.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-maintenance")
public class DeleteMaintenanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String jdbcUrl = "jdbc:mysql://localhost:3307/condo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            deleteMaintenanceRequest(connection, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/maintenance-list.jsp");
    }

    private void deleteMaintenanceRequest(Connection connection, String id) throws SQLException {
        String sql = "DELETE FROM maintenance WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.executeUpdate();
        }
    }
}
