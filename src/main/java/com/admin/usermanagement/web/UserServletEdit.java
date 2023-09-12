package com.admin.usermanagement.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.usermanagement.bean.User;
import com.admin.usermanagement.dao.UserDao;

@WebServlet("/edit")
public class UserServletEdit extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDAO;

    public UserServletEdit() {
        super();
        userDAO = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            User user = userDAO.selectUser(id);
            if (user != null) {
                request.setAttribute("user", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
                dispatcher.forward(request, response);
            } else {
                // Handle case where user with given ID is not found
                // You might want to redirect to an error page or display a message
            }
        } catch (Exception e) {
            // Handle any exceptions that may occur during the process
            // You might want to redirect to an error page or display a message
        }
    }
}
