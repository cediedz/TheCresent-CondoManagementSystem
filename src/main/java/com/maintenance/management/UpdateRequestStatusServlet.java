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

@WebServlet("/update-request-status")
public class UpdateRequestStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String jdbcUrl = "jdbc:mysql://localhost:3307/condo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String requestStatus = request.getParameter("requestStatus");

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            updateRequestStatus(connection, id, requestStatus);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/maintenance-list.jsp");
    }

    private void updateRequestStatus(Connection connection, String id, String requestStatus) throws SQLException {
        String sql = "UPDATE maintenance SET request_status = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, requestStatus);
            preparedStatement.setInt(2, Integer.parseInt(id));
            preparedStatement.executeUpdate();
        }
    }
}
