package com.maintenance.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/maintenance-list")
public class MaintenanceListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String jdbcUrl = "jdbc:mysql://localhost:3307/condo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            MaintenanceDao maintenanceDAO = new MaintenanceDao(connection);

            List<MaintenanceRequest> maintenanceRequests = maintenanceDAO.getAllMaintenanceRequests();

            request.setAttribute("maintenanceRequests", maintenanceRequests);
            request.getRequestDispatcher("/maintenance-list.jsp").forward(request, response);
        } catch (SQLException e) {
            // Handle database-related exceptions
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/maintenance-list");
        }
    }
}
