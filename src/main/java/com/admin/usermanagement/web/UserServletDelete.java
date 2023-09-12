package com.admin.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.usermanagement.dao.UserDao;

@WebServlet("/delete")
public class UserServletDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDao userDAO;

    public UserServletDelete() {
        super();
        userDAO = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            boolean rowDeleted = userDAO.deleteUser(id);
            if (rowDeleted) {
                response.sendRedirect("list");
            } else {
                // User deletion failed
                // You can forward to an error page or show an error message to the user
                // For example:
                request.setAttribute("errorMessage", "An error occurred while deleting the user.");
                request.getRequestDispatcher("error-page.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            // Handle the SQLException here
            e.printStackTrace(); // Print the error details for debugging
            // You can also forward to an error page or show an error message to the user
            // For example:
            request.setAttribute("errorMessage", "An error occurred while deleting the user.");
            request.getRequestDispatcher("error-page.jsp").forward(request, response);
        }
    }
}
