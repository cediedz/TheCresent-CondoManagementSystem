package com.announcement.management;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AnnouncementServlet")
public class AnnouncementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AnnouncementDao announcementDao;

    public AnnouncementServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();

        // Initialize your AnnouncementDao with the database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3307/condo?useSSL=false";
        String jdbcUsername = "root";
        String jdbcPassword = "";

        announcementDao = new AnnouncementDao(jdbcUrl, jdbcUsername, jdbcPassword);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list"; // Default action to list announcements
        }

        switch (action) {
            case "list":
                listAnnouncements(request, response);
                break;
            case "create":
                showCreateForm(request, response);
                break;
            case "add":
                createAnnouncement(request, response);
                break;
            default:
                listAnnouncements(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void listAnnouncements(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve the list of announcements from your AnnouncementDao
            List<Announcement> announcements = announcementDao.getAllAnnouncements();

            // Set the list of announcements as an attribute in the request
            request.setAttribute("announcements", announcements);

            // Forward the request to your JSP for displaying the announcements
            request.getRequestDispatcher("/announcements.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the SQLException here, you can redirect to an error page or display an error message.
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving announcements.");
        }
    }
    
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to your JSP for creating an announcement
        request.getRequestDispatcher("/create-announcement.jsp").forward(request, response);
    }

    private void createAnnouncement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the title and content from the request
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // Create a new Announcement object
        Announcement announcement = new Announcement();
        announcement.setTitle(title);
        announcement.setContent(content);

        try {
            // Add the announcement to your AnnouncementDao
            announcementDao.addAnnouncement(announcement);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the SQLException here, you can redirect to an error page or display an error message.
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding announcement.");
            return;
        }

        // Redirect to the list of announcements
        response.sendRedirect(request.getContextPath() + "/AnnouncementServlet?action=list");
    }
}
