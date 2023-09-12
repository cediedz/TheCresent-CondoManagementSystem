<%
    if(session.getAttribute("name")==null){
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Settings</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("images/backgroundd.jpg");
            background-size: cover;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 80%;
            max-width: 600px;
            padding: 30px;
            opacity: 0; /* Start with opacity set to 0 for fade-in animation */
            animation: fadeIn 0.5s ease-in-out forwards; /* Fade-in animation */
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        h1 {
            font-size: 28px;
            color: #333;
            margin-bottom: 20px;
        }

        h2 {
            font-size: 20px;
            color: #555;
            margin-bottom: 10px;
        }

        form {
            margin-top: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            color: #333;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            transition: border-color 0.3s ease-in-out; /* Add a transition effect for input fields */
        }

        input[type="text"]:focus,
        input[type="password"]:focus,
        input[type="email"]:focus {
            border-color: #007BFF; /* Change border color on focus */
        }

        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 12px 20px;
            cursor: pointer;
            font-size: 16px;
            border-radius: 4px;
            transition: background-color 0.3s ease-in-out; /* Add a transition effect for button background */
        }

        input[type="submit"]:hover {
            background-color: #0056b3; /* Change button background color on hover */
        }

        .status {
            margin-top: 20px;
            text-align: center;
            color: #333;
        }

        .status p {
            font-size: 18px;
        }

        hr {
            margin: 20px 0;
            border: none;
            border-top: 1px solid #ccc;
        }

        a {
            display: block;
            text-align: center;
            text-decoration: none;
            color: #007BFF;
            font-weight: bold;
            margin-top: 20px;
            font-size: 18px;
            transition: color 0.3s ease-in-out; /* Add a transition effect for link color */
        }

        a:hover {
            color: #0056b3; /* Change link color on hover */
        }

        .user-info {
            text-align: right;
            margin-bottom: 20px;
        }

        .user-info p {
            font-size: 18px;
            color: #007BFF;
            margin: 0;
        }

        .logout-link {
            text-decoration: none;
            font-weight: bold;
            color: #ff3333;
            margin-left: 10px;
            transition: color 0.3s ease-in-out; /* Add a transition effect for link color */
        }

        .logout-link:hover {
            color: #cc0000; /* Change link color on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="user-info">
            <p>Welcome, <%= session.getAttribute("name") %>!</p>
            <a href="logout" class="logout-link">Logout</a>
        </div>

        <h1>User Settings</h1>
        
        <!-- Change Password Form -->
        <h2>Change Password</h2>
        <form action="ChangePasswordServlet" method="post">
            <label for="currentPassword">Current Password:</label>
            <input type="password" id="currentPassword" name="currentPassword" required>
            
            <label for="newPassword">New Password:</label>
            <input type="password" id="newPassword" name="newPassword" required>
            
            <label for="confirmNewPassword">Confirm New Password:</label>
            <input type="password" id="confirmNewPassword" name="confirmNewPassword" required>
            
            <input type="submit" value="Change Password">
        </form>

        <!-- Change Email Form -->
        <h2>Change Email</h2>
        <form action="ChangeEmailServlet" method="post">
            <label for="newEmail">New Email:</label>
            <input type="email" id="newEmail" name="newEmail" required>
            
            <input type="submit" value="Change Email">
        </form>

        <hr>

        <!-- Display status messages here -->
        <div class="status">
            <p>Status: ${status}</p>
            <p>${message}</p>
        </div>

        <!-- Add links or buttons to navigate back to other pages if needed -->
        <a href="user_dashboard.jsp">Back to Dashboard</a>
        
    </div>
</body>
</html>
