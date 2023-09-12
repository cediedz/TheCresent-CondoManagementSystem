<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
        	background: url("images/backgroundd.jpg") center/cover no-repeat fixed;
            background-color: black;
            font-family: Arial, sans-serif;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .card {
            width: 400px;
            border: none;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .card-body {
            padding: 40px;
        }

        .card-title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
            color: #333;
        }

        .card-text {
            font-size: 16px;
            margin-bottom: 30px;
            color: #777;
        }

        .form-group {
            margin-bottom: 30px;
        }

        label {
            font-size: 14px;
            font-weight: bold;
            color: #333;
        }

        .form-control {
            border-radius: 8px;
            border: 1px solid #ccc;
            padding: 12px;
        }

        .form-text {
            font-size: 12px;
            color: #777;
        }

        .btn-success {
            background-color: #28a745;
            border: none;
            padding: 12px 20px;
            font-size: 14px;
            font-weight: bold;
            letter-spacing: 1px;
        }

        .btn-danger {
            background-color: #dc3545;
            border: none;
            padding: 12px 20px;
            font-size: 14px;
            font-weight: bold;
            letter-spacing: 1px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h2 class="card-title">Forgot Your Password?</h2>
                <p class="card-text">Recover your account by following these steps:</p>
                <ol class="list-unstyled">
                    <li><span class="text-success">1. </span>Enter your email address below.</li>
                    <li><span class="text-success">2. </span>We'll send an OTP to your email.</li>
                    <li><span class="text-success">3. </span>Enter the OTP on the next page.</li>
                </ol>
                <form action="forgotPassword" method="POST">
                    <div class="form-group">
                        <label for="email-for-pass">Enter your email address</label>
                        <input class="form-control" type="email" name="email" id="email-for-pass" required>
                        <small class="form-text">We'll email an OTP to this address.</small>
                    </div>
                    <button class="btn btn-success" type="submit">Get OTP</button>
                    <a class="btn btn-danger" href="login.jsp">Back to Login</a>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
