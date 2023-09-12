<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Maintenance List</title>
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
            padding: 10px 0;
            text-align: center;
        }

        header a {
            color: white;
            text-decoration: none;
            font-size: 24px;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #0437C8;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 10px;
            transition: background-color 0.3s ease;
        }

        .button:hover {
            background-color: #0056b3;
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

        .edit-icon, .delete-icon {
            color: #007bff;
            font-size: 18px;
            margin-right: 10px;
            cursor: pointer;
            transition: color 0.3s ease;
        }

        .edit-icon:hover, .delete-icon:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>

<header>
    <div>
        <a href="https://www.xadmin.net">Maintenance List</a>
    </div>
</header>
<br>

<div class="container">
    <h3>List of Maintenance Requests</h3>
    <hr>
    <div>
    </div>
    <br>
    <table>
        <thead>
            <tr>
                <th>Unit Number</th>
                <th>Status</th>
                <th>Description</th>
                <th>Request Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="request" items="${maintenanceRequests}">
                <tr>
                    <td><c:out value="${request.unitNumber}" /></td>
                    <td><c:out value="${request.status}" /></td>
                    <td><c:out value="${request.description}" /></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/update-request-status" method="post">
                            <input type="hidden" name="id" value="${request.id}">
                            <select name="requestStatus">
                                <option value="pending" ${request.requestStatus == 'pending' ? 'selected' : ''}>Pending</option>
                                <option value="ongoing" ${request.requestStatus == 'ongoing' ? 'selected' : ''}>Ongoing</option>
                                <option value="closed" ${request.requestStatus == 'closed' ? 'selected' : ''}>Closed</option>
                            </select>
                            <button type="submit">Update</button>
                        </form>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/delete-maintenance?id=${request.id}" class="delete-icon"><i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div style="text-align: center; margin-top: 20px;">
    <a href="${pageContext.request.contextPath}/maintenance-list" class="button">Refresh List</a>
</div>

</body>
</html>
