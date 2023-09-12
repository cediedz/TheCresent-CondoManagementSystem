package com.announcement.management;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-announcement")
public class AddAnnouncementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the title and content from the request
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // Create a new Announcement object
        Announcement announcement = new Announcement();
        announcement.setTitle(title);
        announcement.setContent(content);

        // Initialize your AnnouncementDao with the database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3307/condo?useSSL=false";
        String jdbcUsername = "root";
        String jdbcPassword = "";

        AnnouncementDao announcementDao = new AnnouncementDao(jdbcUrl, jdbcUsername, jdbcPassword);

        try {
            // Add the announcement to your AnnouncementDao
            announcementDao.addAnnouncement(announcement);

            // Redirect to the list of announcements
            response.sendRedirect(request.getContextPath() + "/AnnouncementServlet?action=list");
        } catch (SQLException e) {
            // Handle any exceptions that occur during the database operation
            e.printStackTrace(); // You can log the error or display an error message to the user
            response.sendRedirect(request.getContextPath() + "/AnnouncementServlet?action=list");
        }
    }
}
