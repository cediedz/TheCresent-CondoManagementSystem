package com.cedrickjames.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddFinanceServlet")
public class AddFinanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String description = request.getParameter("description");
        double amount = Double.parseDouble(request.getParameter("amount"));

        Finance finance = new Finance(0, customerName, description, amount);

        FinanceDAO financeDAO = new FinanceDAO();
        financeDAO.addFinance(finance);

        // Pass the finance object to the receipt.jsp
        request.setAttribute("finance", finance);
        request.getRequestDispatcher("receipt.jsp").forward(request, response);
    }
}

