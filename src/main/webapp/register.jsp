<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<!-- Basic -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<!-- Site Metas -->
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">

<title>Giftos</title>

<!-- slider stylesheet -->
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

<!-- bootstrap core css -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet" />
<!-- responsive style -->
<link href="css/responsive.css" rel="stylesheet" />
</head>

<body>
	<div class="hero_area">
		<!-- header section starts -->
		<header class="header_section">
			<nav class="navbar navbar-expand-lg custom_nav-container ">
				<a class="navbar-brand" href="index.html"> <span> Giftos
				</span>
				</a>
			</nav>
		</header>
	</div>


	<!-- login session -->
	<div class="container">
		<div class="heading_container heading_center">
			<h3>Create a new account</h3>
			<c:if test="${not empty errorMessage}">
				<p style="color: red;">${errorMessage}</p>
			</c:if>
		</div>
		<br>
	</div>
	<div class="container container-bg">
		<div class="heading_container heading_center">
			<div class="row">
				<div class="col-md-5 col-lg-2 px-0">

					<!-- Form -->
					<form action="Register" method="post">
						<br> <label for="uname">Username:</label><br> <input
							type="text" id="uname" name="username"
							placeholder="Enter your username"><br>
						<br> <label for="pwd">Password:</label><br> <input
							type="password" id="pwd" name="password"
							placeholder="Enter your password"><br> <br> 	
					Gender:<input type="radio" name="gender" value="Male" id="Male"> <label for="Male">Male</label> <br>
							<input type="radio" name="gender" value="Female" id="Female"> <label for="Female">Female</label> <br>
							<input type="radio" name="gender" value="Other" id="Other"> <label for="Other">Other</label> <br><br>
					Hobbies:<input type="checkbox" name="hobby" value="Eat" id="Eat"> <label for="Eat">Eat</label> <br>
							<input type="checkbox" name="hobby" value="Sleep" id="Sleep"> <label for="Sleep">Female</label> <br>
							<input type="checkbox" name="hobby" value="PooPoo" id="PooPoo"> <label for="PooPoo">Other</label> <br><br>
							<input
							type="submit" value="Register"/>
							
					</form>
					<!-- Form -->

				</div>
			</div>
		</div>
	</div>
	<br>

	<!-- end login session -->


	<!-- info section -->

	

	<!-- end info section -->


	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
		
	</script>
	<script src="js/custom.js"></script>

</body>

</html>