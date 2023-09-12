

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Cresent Condominium Sign Up</title>

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

    /* Style for the combo box container */
    .form-group {
        position: relative;
        margin-bottom: 20px;
    }

    /* Style for the label icon */
    .form-group label {
        position: absolute;
        top: 10px;
        left: 10px;
        font-size: 20px;
        color: #555555;
    }

	.form-group input[type="text"],
    .form-group input[type="email"],
    .form-group input[type="password"],
    .form-group select {
        width: 100%;
        padding: 15px;
        font-size: 16px;
        color: #ffffff;
        border: none;
        border-radius: 8px; /* Add border radius to soften the edges */
        background-color: #000000;
        transition: background-color 0.3s;
        position: relative;
        z-index: 1;
    }

    /* Add background overlay on focus */
    .form-group input[type="text"]:focus::before,
    .form-group input[type="email"]:focus::before,
    .form-group input[type="password"]:focus::before,
    .form-group select:focus::before {
        content: "";
        position: absolute;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.4);
        z-index: -1;
    }

    /* Add focus styles */
    .form-group input[type="text"]:focus,
    .form-group input[type="email"]:focus,
    .form-group input[type="password"]:focus,
    .form-group select:focus {
        background-color: #111111;
    }
	

    /* Style for the combo box select element */
    .form-group select {
        appearance: none; /* Remove default arrow icon */
        -webkit-appearance: none;
        -moz-appearance: none;
        width: 100%;
        padding: 12px 40px 12px 30px;
        font-size: 16px;
        color: #555555;
        border: 1px solid #cccccc;
        border-radius: 5px;
        background-color: #ffffff;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    /* Style for the combo box arrow icon */
    .form-group select::-ms-expand {
        display: none; /* Hide arrow icon in IE */
    }

    .form-group select::after {
        content: "\f107"; /* Unicode for a downward arrow (Font Awesome icon) */
        font-family: "Font Awesome 5 Free";
        position: absolute;
        top: 50%;
        right: 15px;
        transform: translateY(-50%);
        font-size: 18px;
        color: #555555;
    }

    /* Style for the combo box option list */
    .form-group select option {
        font-size: 16px;
        color: #555555;
    }
    
    
    .error-message {
    color: red;
    font-size: 14px;
    margin-top: 5px;
}
    
</style>


			<script>
			document.addEventListener("DOMContentLoaded", function () {
			    const positionSelect = document.getElementById("combo");
			    const unitFields = document.getElementById("unitFields");
			
			    positionSelect.addEventListener("change", function () {
			        if (positionSelect.value === "owner") {
			            unitFields.style.display = "block";
			        } else {
			            unitFields.style.display = "none";
			        }
			    });
			});
			    </script>

<body>

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">

	<div class="main">
	
		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
						<form method="post" action="register" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="Your Name" required = "required"/>
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email" required="required"/>
							</div>
													<!-- Add the JSP code here to display the error message -->
							<%
							    String errorMessage = (String) request.getAttribute("message");
							    if (errorMessage != null) {
							%>
							    <div style="color: red; font-size: 14px; margin-top: 5px;">
							        <%= errorMessage %>
							    </div>
							<%
							    }
							%>
							

							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="pass" id="pass" placeholder="Password" required="required"/>
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="re_pass" id="re_pass"
									placeholder="Repeat your password" required="required"/>
							</div>
							
							
							<div class="form-group">
							    <label for="combo"><i class=""zmdi zmdi-account-box></i></label>
							    <select name="combo" id="combo" required="required">
							        <option value="">Select position</option>
							        <option value="tenant">Tenant or Resident</option>
							        <option value="owner">Unit Owner</option>
							        <option value="admin">Administrator</option>
							        <option value="staff">Condo Staff</option>
							    </select>
							</div>
							
							<div class="form-group" id="unitFields" style="display: none;">
                                <label for="unitNumber"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="text" name="unitNumber" id="unitNumber" placeholder="Unit Number" />
                            </div>
			
							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="contact" id="contact"
									placeholder="Contact no" required="required"/>
							</div>
							
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							
							<%
							    String status = (String) request.getAttribute("status");
							    if (status != null && status.equals("success")) {
							%>
							    <div class="success-message">
							        You have successfully signed up! Welcome to The Cresent Condominium.
							    </div>
							<%
							    }
							%>
							
							
							
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/sign-in.png" alt="sign up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">I am already
							member</a>
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