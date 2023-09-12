package com.admin.usermanagement.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.usermanagement.bean.User;
import com.admin.usermanagement.dao.UserDao;

@WebServlet("/other-list")
public class OtherListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Perform operations to retrieve "Other List" data from your database or other source
        UserDao userDao = new UserDao();
        List<User> otherListData = userDao.selectOtherList();
        
        // Store the data in a request attribute
        request.setAttribute("otherListData", otherListData);

        // Forward the request to the other-list.jsp page
        request.getRequestDispatcher("other-list.jsp").forward(request, response);
    }
}
