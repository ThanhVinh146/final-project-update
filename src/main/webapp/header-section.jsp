<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="header_section">
			<nav class="navbar navbar-expand-lg custom_nav-container ">
				<a class="navbar-brand" href="index.html"> <span> Giftos
				</span>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class=""></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav  ">
						<li class="nav-item active"><a class="nav-link" href="Home">Home
								<span class="sr-only">(current)</span>
						</a></li>
						<c:forEach items="${categories}" var="category">
							<li class="nav-item"><a class="nav-link"
								href="Home?categoryId=${category.id}">${category.name}</a></li>
						</c:forEach>

						<li class="nav-item"><a class="nav-link" href="contact.html">Contact
								Us</a></li>
					</ul>
					<div class="user_option">
						<c:if test="${empty sessionScope.user}">
							<a href="login.jsp"> <i class="fa fa-user" aria-hidden="true"></i>
								<span> Login </span>
								</a>
								<a href="register.jsp"> <span>Register</span>
							</a>
						</c:if>
						<c:if test="${not empty sessionScope.user}">
							<a href="LoginController?action=LOG_OUT"> Hello ${sessionScope.user.username} <span>
									Logout </span>
							</a>
						</c:if>
						<a href="CartController?ACTION=VIEW_CART"> <i class="fa fa-shopping-bag" aria-hidden="true"></i> ${sessionScope.cart.items.size()}
						</a>
						<form class="form-inline ">
							<button class="btn nav_search-btn" type="submit">
								<i class="fa fa-search" aria-hidden="true"></i>
							</button>
						</form>
					</div>
				</div>
			</nav>
		</header>