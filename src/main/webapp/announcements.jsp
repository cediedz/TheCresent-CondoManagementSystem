<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Announcements</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('images/backgroundd.jpg');
            background-size: cover;
        }

        header {
            background-color: #0437C8;
            color: white;
            text-align: center;
            padding: 20px;
        }

        header a {
            color: white;
            text-decoration: none;
            font-size: 24px;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.2);
        }

        h2 {
            text-align: center;
        }

        .announcement-form {
            text-align: center;
            margin-top: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 5px;
            resize: none;
            font-family: Arial, sans-serif;
            transition: border-color 0.3s ease-in-out;
            box-sizing: border-box;
        }

        textarea {
            width: 100%;
            height: 100px;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 5px;
            resize: none;
            font-family: Arial, sans-serif;
            transition: border-color 0.3s ease-in-out;
            box-sizing: border-box;
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

        .announcement-list {
            margin-top: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
    <header>
        <div>
            <a href="${pageContext.request.contextPath}/index.jsp">Announcement</a>
        </div>
    </header>
    
    <div class="container">
        <h2>Announcements</h2>
        
        <!-- Announcement Form -->
        <div class="announcement-form">
            <form action="${pageContext.request.contextPath}/add-announcement" method="post">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required>
                <br>
                <label for="content">Content:</label>
                <textarea id="content" name="content" required></textarea>
                <br>
                <button type="submit">Add Announcement</button>
            </form>
        </div>
        
        <!-- List of Announcements -->
        <div class="announcement-list">
            <table>
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Timestamp</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="announcement" items="${announcements}">
                        <tr>
                            <td><c:out value="${announcement.title}" /></td>
                            <td><c:out value="${announcement.content}" /></td>
                            <td><c:out value="${announcement.timestamp}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
