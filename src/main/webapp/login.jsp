<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Cresent Condominium</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
	 <style>
        body {
            background-image: url("images/backgroundd.jpg");
            background-size: cover;
        }
        
		.error-message {
		    color: red;
		    font-weight: bold;
		}
		
		/* Modern text field styles with black background and white font */
    .signin-form input[type="text"],
    .signin-form input[type="password"] {
        width: 100%;
        padding: 15px;
        font-size: 16px;
        color: #ffffff;
        border: none;
        border-radius: 8px; /* Add border radius to soften the edges */
        background-color: #000000;
        transition: background-color 0.3s;
    }

    /* Add focus styles */
    .signin-form input[type="text"]:focus,
    .signin-form input[type="password"]:focus {
        background-color: #111111;
        outline: none; /* Remove default focus outline */
    }

    </style>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
	<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container" style="background-color: transparent;"> 
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/sign-in.png" alt="sing up image">
						</figure>
						<a href="registration.jsp" class="signup-image-link">Create an
							account</a>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Sign in</h2>
								<% 
	                            String status = (String) request.getAttribute("status");
	                            String message = (String) request.getAttribute("message");
	                            if (status != null && status.equals("failed")) {
	                        %>
	                            <div class="error-message">
	                                Invalid username or password. Please try again.
	                            </div>
	                        <% } %>
						<form method="post" action="login" class="register-form"
							id="login-form">
							<div class="form-group">
								<label for="username"><i
									class=""></i></label> <input
									type="text" name="username" id="username"
									placeholder="Your Name" required="required"/>
							</div>
							<div class="form-group">
								<label for="password"><i class=""></i></label> <input
									type="password" name="password" id="password"
									placeholder="Password" required="required"/>
							</div>
							<div class="form-group">
								<a href="forgotPassword.jsp" >Forgot Password?</a>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" />
							</div>
						</form>
						<div class="social-login">
							<span class="social-label">Or login with</span>
							<ul class="socials">
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-facebook"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-twitter"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-google"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</section>

	</div>

	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>