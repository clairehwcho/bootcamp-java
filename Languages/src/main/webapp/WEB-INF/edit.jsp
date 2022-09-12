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
<title><c:out value="${language.name}" /></title>
</head>

<body>
	<div class="row" id="row2">
		<div class="title">
			<h1>Edit Language</h1>
			<a href="/delete/${language.id}" onclick="return confirm_delete()">Delete</a>
			<a href="/languages">Dashboard</a>
		</div>
		<form:form action="/update/${language.id}" method="put"
			modelAttribute="language" id="addForm">
			<p>
				<!-- the value of path must match the member variable of the model -->
				<form:label path="name" class="form-label">Name:</form:label>
				<form:errors path="name" class="errormessage" />
				<form:input path="name" class="form-control" />
			</p>
			<p>
				<form:label path="creator" class="form-label">Creator:</form:label>
				<form:errors path="creator" class="errormessage" />
				<form:input path="creator" class="form-control" />
			</p>
			<p>
				<form:label path="version" class="form-label">Version:</form:label>
				<form:errors path="version" class="errormessage" />
				<form:input path="version" class="form-control" />
			</p>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>


	<!-- for bootstrap js & jquery -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

	<!-- my own js -->
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>