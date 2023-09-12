<%@ page import="com.cedrickjames.registration.Finance" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Finance Receipt</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            max-width: 400px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        h1 {
            text-align: center;
            color: #007BFF;
            margin-bottom: 20px;
        }

        p {
            margin: 5px 0;
        }

        .receipt-info {
            margin-bottom: 30px;
            padding: 20px;
            background-color: #f5f5f5;
            border-radius: 8px;
        }

        .receipt-info h3 {
            color: #007BFF;
            margin-top: 0;
        }

        .receipt-info p {
            margin: 5px 0;
        }

        .receipt-info p.label {
            font-weight: bold;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Finance Receipt</h1>
        <div class="receipt-info">
            <h3>Receipt generated on:</h3>
            <p><%= getCurrentDate() %></p>
        </div>
        <div class="receipt-info">
            <p class="label">Customer Name:</p>
            <p>${finance.customerName}</p>
            <p class="label">Description:</p>
            <p>${finance.description}</p>
            <p class="label">Amount:</p>
            <p>${finance.amount}</p>
        </div>
    </div>
</body>
</html>

<%!
    private String getCurrentDate() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(currentDate);
    }
%>
