<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Maintenance Request</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        /* Reset default margins and paddings */
        body, h1, form {
            margin: 0;
            padding: 0;
        }

        /* Background and font styles */
        body {
            font-family: Arial, sans-serif;
            color: #333;
            background-image: url('images/backgroundd.jpg');
            background-size: cover;
        }

        /* Header styling */
        header {
            background-color: #0437C8;
            color: white;
            text-align: center;
            padding: 20px;
        }

        /* Form container */
        .form-container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.2);
        }

        /* Form styling */
        label {
            display: block;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .input-container {
            position: relative;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 5px;
            resize: none;
            font-family: Arial, sans-serif;
            transition: border-color 0.3s ease-in-out;
            box-sizing: border-box; /* Ensure padding is included in width */
        }

        input[type="text"]:focus,
        textarea:focus {
            outline: none;
            border-color: #007bff;
        }

        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-family: Arial, sans-serif;
            transition: border-color 0.3s ease-in-out;
            box-sizing: border-box;
        }

        select:focus {
            outline: none;
            border-color: #007bff;
        }

        button[type="submit"] {
            background-color: #0437C8;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* Button to see maintenance list */
        .view-list-button {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
            margin-top: 10px;
        }

        .view-list-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <header>
        <h1>Maintenance Request</h1>
    </header>
    
    <div class="form-container">
        <form action="${pageContext.request.contextPath}/submit-maintenance" method="post">
            <label for="unitNumber">Unit Number:</label>
            <div class="input-container">
                <input type="text" id="unitNumber" name="unitNumber" placeholder="Enter your unit number" required>
            </div>
            <br>
            <label for="status">Status:</label>
            <div class="input-container">
                <select id="status" name="status" required>
                    <option value="critical">Critical</option>
                    <option value="moderate">Moderate</option>
                    <!-- Add more options as needed -->
                </select>
            </div>
            <br>
            <label for="description">Describe the Issue:</label>
            <div class="input-container">
                <textarea id="description" name="description" rows="6" placeholder="Briefly describe the issue..." required></textarea>
            </div>
            <br>
            <button type="submit">Submit Maintenance Request</button>
            
            <!-- Button to view maintenance list -->
            <a href="${pageContext.request.contextPath}/user-maintenance-list" class="view-list-button">View Maintenance List</a>
        </form>
    </div>
</body>
</html>
