package com.settings.management;

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
import javax.servlet.http.HttpSession;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public ChangePasswordServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("name");
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");
        
        if (!newPassword.equals(confirmNewPassword)) {
            request.setAttribute("status", "error");
            request.setAttribute("message", "New password and confirm password do not match.");
            request.getRequestDispatcher("settings.jsp").forward(request, response);
            return;
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/condo", "root", "")) {
                String updateQuery = "UPDATE users SET upwd = ? WHERE uname = ? AND upwd = ?";
                try (PreparedStatement pst = con.prepareStatement(updateQuery)) {
                    pst.setString(1, newPassword);
                    pst.setString(2, username);
                    pst.setString(3, currentPassword);
                    
                    int rowsAffected = pst.executeUpdate();
                    if (rowsAffected > 0) {
                        request.setAttribute("status", "success");
                        request.setAttribute("message", "Password changed successfully.");
                    } else {
                        request.setAttribute("status", "error");
                        request.setAttribute("message", "Invalid current password.");
                    }
                    request.getRequestDispatcher("settings.jsp").forward(request, response);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("status", "error");
            request.setAttribute("message", "An error occurred. Please try again later.");
            request.getRequestDispatcher("settings.jsp").forward(request, response);
        }
    }
}
