<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('images/backgroundd.jpg'); /* Replace with the actual path */
            background-size: cover;
            background-repeat: no-repeat;
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

        nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        nav ul li {
            display: inline-block;
            margin-right: 20px;
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

        .action-icons {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .action-icons a {
            color: #007bff;
            font-size: 18px;
            margin: 0 5px;
            cursor: pointer;
            transition: color 0.3s ease;
        }

        .action-icons a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>

<header>
    <div>
        <a href="">Cresent Owner Management</a>
    </div>

    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/list" class="action-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="container">
    <h3>List of Owners</h3>
    <hr>
    <div>
        <a href="${pageContext.request.contextPath}/new" class="button">Add New User</a>
        <a href="${pageContext.request.contextPath}/other-list" class="button">Next List</a>
    </div>
    <br>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Unit Number</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.unitNumber}" /></td>
                    <td class="action-icons">
                        <a href="${pageContext.request.contextPath}/edit?id=${user.id}"><i class="fas fa-edit"></i></a>
                        <a href="${pageContext.request.contextPath}/delete?id=${user.id}"><i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div style="text-align: center; margin-top: 20px;">
    <a href="${pageContext.request.contextPath}/list" class="button">Refresh List</a>
</div>

</body>
</html>
