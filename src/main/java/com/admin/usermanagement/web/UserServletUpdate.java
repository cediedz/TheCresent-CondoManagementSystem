package com.admin.usermanagement.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.usermanagement.bean.User;
import com.admin.usermanagement.dao.UserDao;

@WebServlet("/update")
public class UserServletUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDAO;

    public UserServletUpdate() {
        super();
        userDAO = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String unitNumber = request.getParameter("unitNumber"); // Changed field name

        try {
            User user = new User(id, name, email, unitNumber); // Changed field name
            userDAO.updateUser(user);
            response.sendRedirect("list"); // Redirect to the user list page
        } catch (Exception e) {
            // Handle any exceptions that may occur during the update process
            // You might want to redirect to an error page or display a message
        }
    }
}
