package com.cedrickjames.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FinanceDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3307/condo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String SELECT_ALL_FINANCES = "SELECT * FROM finances";
    private static final String INSERT_FINANCE = "INSERT INTO finances (customer_name, description, amount) VALUES (?, ?, ?)";
    private static final String SELECT_FINANCE_BY_ID = "SELECT * FROM finances WHERE id = ?";

    public FinanceDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Finance> getAllFinances() {
        List<Finance> finances = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FINANCES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String customerName = rs.getString("customer_name");
                String description = rs.getString("description");
                double amount = rs.getDouble("amount");
                finances.add(new Finance(id, customerName, description, amount));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finances;
    }

    public void addFinance(Finance finance) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FINANCE)) {
            preparedStatement.setString(1, finance.getCustomerName());
            preparedStatement.setString(2, finance.getDescription());
            preparedStatement.setDouble(3, finance.getAmount());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Finance getFinanceById(int id) {
        Finance finance = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FINANCE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String customerName = rs.getString("customer_name");
                String description = rs.getString("description");
                double amount = rs.getDouble("amount");
                finance = new Finance(id, customerName, description, amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finance;
    }
}
