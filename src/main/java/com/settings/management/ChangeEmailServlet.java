package com.settings.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChangeEmailServlet")
public class ChangeEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ChangeEmailServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("name");
        String newEmail = request.getParameter("newEmail");

        // Check if the new email address is the same as the current email address
        String currentEmail = getCurrentEmail(username);
        if (currentEmail != null && currentEmail.equals(newEmail)) {
            // Email address is not changing, so allow the update
            request.setAttribute("status", "success");
            request.setAttribute("message", "Email address remains the same.");
        } else {
            // Check if the new email address already exists in the database
            boolean emailExists = checkIfEmailExists(newEmail);

            if (emailExists) {
                // Display an error message to the user
                request.setAttribute("status", "error");
                request.setAttribute("message", "Email already in use. Please choose a different email.");
            } else {
                // Perform the email update operation
                boolean updateSuccess = updateEmail(username, newEmail);

                if (updateSuccess) {
                    // Email updated successfully
                    request.setAttribute("status", "success");
                    request.setAttribute("message", "Email changed successfully.");
                } else {
                    // Email change failed
                    request.setAttribute("status", "error");
                    request.setAttribute("message", "Failed to change email.");
                }
            }
        }

        // Forward the request to the settings.jsp page
        request.getRequestDispatcher("settings.jsp").forward(request, response);
    }

    // Implement the following methods according to your database access logic

    private String getCurrentEmail(String username) {
        // Retrieve the current email address for the user from the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/condo", "root", "")) {
                String selectQuery = "SELECT uemail FROM users WHERE uname = ?";
                try (PreparedStatement pst = con.prepareStatement(selectQuery)) {
                    pst.setString(1, username);
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            return rs.getString("uemail");
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean checkIfEmailExists(String email) {
        // Check if the provided email address already exists in the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/condo", "root", "")) {
                String selectQuery = "SELECT COUNT(*) FROM users WHERE uemail = ?";
                try (PreparedStatement pst = con.prepareStatement(selectQuery)) {
                    pst.setString(1, email);
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            int count = rs.getInt(1);
                            return count > 0;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean updateEmail(String username, String newEmail) {
        // Update the user's email address in the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/condo", "root", "")) {
                String updateQuery = "UPDATE users SET uemail = ? WHERE uname = ?";
                try (PreparedStatement pst = con.prepareStatement(updateQuery)) {
                    pst.setString(1, newEmail);
                    pst.setString(2, username);
                    int rowsAffected = pst.executeUpdate();
                    return rowsAffected > 0;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
