package com.cedrickjames.registration;

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

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("name");
        String uemail = request.getParameter("email");
        String upwd = request.getParameter("pass");
        String umobile = request.getParameter("contact");
        String position = request.getParameter("combo");
        String unitNumber = request.getParameter("unitNumber");
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/condo", "root", "");
            PreparedStatement checkStmt = con.prepareStatement("SELECT COUNT(*) as count FROM users WHERE uemail = ?");
            checkStmt.setString(1, uemail);
            int emailCount = 0;

            try {
                ResultSet checkResult = checkStmt.executeQuery();
                if (checkResult.next()) {
                    emailCount = checkResult.getInt("count");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (emailCount > 0) {
                request.setAttribute("status", "fail");
                request.setAttribute("message", "The email address is already registered. Please use a different email.");
            } else {
                boolean isValidPassword = validatePassword(upwd);
                if (!isValidPassword) {
                    request.setAttribute("status", "fail");
                    request.setAttribute("message", "Minimum of 8 characters and includes the following:\r\n"
                    		+ "Include at least one uppercase character (A-Z)\r\n"
                    		+ "Inlclude at least one lowercase character (a-z)\r\n"
                    		+ "include at least one number (0-9)\r\n"
                    		+ "include at least one special character (examples: !,@,#,$)\r\n"
                    		+ "");
                } else {       
                    try (PreparedStatement pst = con.prepareStatement("INSERT INTO users (uname, upwd, uemail, umobile, position, unit_number) VALUES (?, ?, ?, ?, ?, ?)")) {
                        pst.setString(1, uname);
                        pst.setString(2, upwd);
                        pst.setString(3, uemail);
                        pst.setString(4, umobile);
                        pst.setString(5, position);
                        pst.setString(6, unitNumber);

                        int rowCount = pst.executeUpdate();

                        if (rowCount > 0) {
                            request.setAttribute("status", "success");
                        } else {
                            request.setAttribute("status", "fail");
                            request.setAttribute("message", "Registration failed. Please try again later.");
                        }
                    }
                }
            }

            request.getRequestDispatcher("registration.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean validatePassword(String password) {
        boolean hasNumber = false;
        boolean hasSpecialSymbol = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialSymbol = true;
            }

            if (hasNumber && hasSpecialSymbol) {
                return true;
            }
        }

        return false;
    }
}
