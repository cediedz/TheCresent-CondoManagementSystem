package com.cedrickjames.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uemail = request.getParameter("username");
        String upwd = request.getParameter("password");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;

        if (uemail.isEmpty() || upwd.isEmpty()) {
            request.setAttribute("status", "error");
            request.setAttribute("message", "Email and password are required.");
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/condo", "root", "")) {
                try (PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE uemail = ? AND upwd = ?");
                     PreparedStatement rolePst = con.prepareStatement("SELECT position FROM users WHERE uemail = ?")) {

                    pst.setString(1, uemail);
                    pst.setString(2, upwd);

                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            // Successfully logged in, retrieve the user's role
                            rolePst.setString(1, uemail);
                            try (ResultSet roleRs = rolePst.executeQuery()) {
                                if (roleRs.next()) {
                                    String userRole = roleRs.getString("position");
                                    session.setAttribute("name", rs.getString("uname"));
                                    session.setAttribute("role", userRole);

                                    if ("admin".equals(userRole)) {
                                        response.sendRedirect("index.jsp"); // Redirect to admin dashboard
                                    } else {
                                        response.sendRedirect("user_dashboard.jsp"); // Redirect to user dashboard
                                    }
                                    return;
                                }
                            }
                        }
                    }

                    // If the login fails
                    request.setAttribute("status", "failed");
                    request.setAttribute("message", "Invalid username or password. Please try again.");
                    dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("status", "error");
            request.setAttribute("message", "An error occurred. Please try again later.");
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}


