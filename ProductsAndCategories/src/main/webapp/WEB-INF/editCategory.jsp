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
<title>${category.name}</title>
</head>

<body>
	<div class="wrapper">
		<div class="main_row1">
			<h1>Edit ${category.name}</h1>
		</div>
		<div class="main_row2">
			<p>
				<a href="/">Home</a>
			</p>
		</div>
		<div class="main_row3">
			<form:form action="/categories/${id}/update" method="put" modelAttribute="category">
				<p>
					<form:input type = "hidden" path="" value="${user.id}" />
				</p>
					<form:label path="name" class="form-label">Name:</form:label>
					<form:errors path="name" class="errormessage" />
					<form:input path="name" class="form-control" />
				</p>
				<input type="submit" value="Submit" class="btn btn-primary" />
			</form:form>

		</div>
	</div>

	<!-- for bootstrap js & jquery -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

	<!-- for your own local js -->
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>