<%@ page import="com.cedrickjames.registration.Appointment" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Appointment Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-color: #f7f7f7;
        }

        .content {
            width: 80%;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        /* AddAppointment form styling */
        form {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
        }

        label {
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="date"],
        input[type="time"],
        input[type="submit"] {
            padding: 8px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        /* Message styling */
        p {
            text-align: center;
            color: #777;
        }

        /* Center the h1 element */
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="content">
            <h1>Appointment Management</h1>

            <!-- Add Appointment Form -->
            <h2>Add a New Appointment</h2>
            <form action="AddAppointmentServlet" method="post">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>

                <label for="date">Date:</label>
                <input type="date" id="date" name="date" required>

                <label for="time">Time:</label>
                <input type="time" id="time" name="time" required>

                <input type="submit" value="Add Appointment">
            </form>

            <!-- Show a message if no appointments are available -->
            <c:if test="${empty appointmentsList}">
                <p></p>
            </c:if>
        </div>
    </div>
</body>
</html>
