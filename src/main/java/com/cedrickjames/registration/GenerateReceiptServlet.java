package com.cedrickjames.registration;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GenerateReceiptServlet")
public class GenerateReceiptServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the finance ID from the request parameter
        String financeIdStr = request.getParameter("id");
        int financeId = Integer.parseInt(financeIdStr);

        // Fetch the finance entry from the database using FinanceDAO
        FinanceDAO financeDAO = new FinanceDAO();
        Finance finance = financeDAO.getFinanceById(financeId);

        // Set the content type and get the PrintWriter
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate the receipt HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Receipt</title>");
        out.println("<style>");
        // Add your receipt CSS styles here
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Receipt</h1>");
        out.println("<p>Customer Name: " + finance.getCustomerName() + "</p>");
        out.println("<p>Description: " + finance.getDescription() + "</p>");
        out.println("<p>Amount: " + finance.getAmount() + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
