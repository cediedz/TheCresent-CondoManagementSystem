package com.admin.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.usermanagement.bean.User;
import com.admin.usermanagement.dao.UserDao;

@WebServlet("/insert")
public class UserServletInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDao userDAO;

    public UserServletInsert() {
        super();
        userDAO = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String unitNumber = request.getParameter("unitNumber"); // Changed field name

        User newUser = new User(name, email, unitNumber); // Changed field name
        try {
            userDAO.insertUser(newUser);
            response.sendRedirect("list");
        } catch (SQLException e) {
            // Handle the SQLException here
            e.printStackTrace(); // Print the error details for debugging
            // You can also forward to an error page or show an error message to the user
            // For example:
            request.setAttribute("errorMessage", "An error occurred while adding the user.");
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }
}
