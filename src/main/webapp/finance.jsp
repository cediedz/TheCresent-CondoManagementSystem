<%@ page import="com.cedrickjames.registration.Finance" %>
<%@ page import="com.cedrickjames.registration.FinanceDAO" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Finance Management</title>
    <!-- Add your CSS styles here -->
</head>
		<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            color: #333;
            margin: 0;
            padding: 0;
        }

        h1, h2 {
            color: #007BFF;
            text-align: center;
        }

        form {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* Styling for Receipt section */
        .receipt {
            max-width: 500px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ddd;
            background-color: #f5f5f5;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .receipt p {
            margin: 5px 0;
        }
        
        @media screen and (min-width: 600px) {
            /* For larger screens, adjust the width of the input fields */
            input[type="text"] {
                width: calc(100% - 20px);
            }
        }
        
         input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
    </style>
<body>
    <h1>Finance Management</h1>

    <!-- Add Finance Form -->
    <h2>Add a New Finance Entry</h2>
    <form action="AddFinanceServlet" method="post">
        <label for="customerName">Customer Name:</label>
        <input type="text" id="customerName" name="customerName" required>

        <label for="description">Description:</label>
        <input type="text" id="description" name="description" required>

        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" required>

        <input type="submit" value="Add Finance">
    </form>

    <!-- Display Receipt -->
    <c:if test="${not empty receipt}">
        <h2>Receipt</h2>
        <p>Customer Name: ${receipt.customerName}</p>
        <p>Description: ${receipt.description}</p>
        <p>Amount: ${receipt.amount}</p>
    </c:if>
</body>
</html>
