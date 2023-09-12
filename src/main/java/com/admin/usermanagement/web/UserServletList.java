package com.admin.usermanagement.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.usermanagement.bean.User;
import com.admin.usermanagement.dao.UserDao;

@WebServlet("/list")
public class UserServletList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDAO;

    public UserServletList() {
        super();
        userDAO = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> userList = userDAO.selectAllUsers();
        request.setAttribute("listUser", userList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
