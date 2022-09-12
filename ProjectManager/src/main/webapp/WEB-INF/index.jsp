<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css" />
<title>Book Share</title>
</head>

<body>
	<div class="wrapper">
		<div class="index_row1">
			<h1>Project Manager</h1>
			<p>A place for teams to manage projects.</p>
		</div>
		<div class="index_row2">
			<!-- REGISTRATION FORM -->
			<div class="formContainer">
				<form:form action="/register" method="post" modelAttribute="newUser"
					id="addForm">
					<h3>Register</h3>
					<p>
						<!-- the value of path must match the member variable of the model -->
						<form:label path="firstName" class="form-label">First Name:</form:label>
						<form:errors path="firstName" class="errormessage" />
						<form:input path="firstName" class="form-control" />
					</p>
					<p>
						<form:label path="lastName" class="form-label">Last Name:</form:label>
						<form:errors path="lastName" class="errormessage" />
						<form:input path="lastName" class="form-control" />
					</p>
					<p>
						<form:label path="email" class="form-label">Email:</form:label>
						<form:errors path="email" class="errormessage" />
						<form:input path="email" class="form-control" />
					</p>
					<p>
						<form:label path="password" class="form-label">Password:</form:label>
						<form:errors path="password" class="errormessage" />
						<form:input type="password" path="password" class="form-control" />
					</p>
					<p>
						<form:label path="confirmPassword" class="form-label">Confirm Password:</form:label>
						<form:errors path="confirmPassword" class="errormessage" />
						<form:input type="password" path="confirmPassword"
							class="form-control" />
					</p>
					<input type="submit" value="Submit" class="btn btn-primary" />
				</form:form>
			</div>

			<!-- LOGIN FORM -->
			<div class="formContainer">
				<form:form action="/login" method="post" modelAttribute="newLogin"
					id="addForm">
					<h3>Log in</h3>
					<p>
						<!-- the value of path must match the member variable of the model -->
						<form:label path="email" class="form-label">Email:</form:label>
						<form:errors path="email" class="errormessage" />
						<form:input path="email" class="form-control" />
					</p>
					<p>
						<form:label path="password" class="form-label">Password:</form:label>
						<form:errors path="password" class="errormessage" />
						<form:input type="password" path="password" class="form-control" />
					</p>
					<input type="submit" value="Submit" class="btn btn-primary" />
				</form:form>
			</div>
		</div>
	</div>


	<!-- for bootstrap js & jquery -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

	<!-- for your own local js -->
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>