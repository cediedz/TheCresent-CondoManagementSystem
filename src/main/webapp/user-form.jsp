<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Management Application</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-image: url('images/backgroundd.jpg');
            background-size: cover;
        }

        .form-container {
            background-color: rgba(255, 255, 255, 0.8); /* Adding transparency to the background color */
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 400px;
        }

        .form-title {
            font-size: 24px;
            margin-bottom: 20px;
            text-align: center;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .btn {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="form-container">
    <div class="form-title">
        <c:if test="${user != null}">Edit User</c:if>
        <c:if test="${user == null}">Add New Owner</c:if>
    </div>
    <form action="<c:if test='${user != null}'>update</c:if><c:if test='${user == null}'>insert</c:if>" method="post">
        <c:if test="${user != null}">
            <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
        </c:if>
        <div class="form-group">
            <label>Owner Name</label>
            <input type="text" value="<c:out value='${user.name}' />" class="form-control" name="name" required="required">
        </div>
        <div class="form-group">
            <label>Owner Email</label>
            <input type="text" value="<c:out value='${user.email}' />" class="form-control" name="email">
        </div>
        <div class="form-group">
            <label>Owner Unit Number</label>
            <input type="text" value="<c:out value='${user.unitNumber}' />" class="form-control" name="unitNumber">
        </div>
        <button type="submit" class="btn btn-success">Save</button>
    </form>
</div>

</body>
</html>
