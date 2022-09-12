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
<title>New Dojo</title>
</head>

<body>
	<div class="row">
		<div class="title">
			<h1>New Dojo</h1>
		</div>
		<form:form action="/addDojo" method="post"
			modelAttribute="dojo" id="addForm">
			<p>
				<!-- the value of path must match the member variable of the model -->
				<form:label path="name" class="form-label">Name:</form:label>
				<form:errors path="name" class="errormessage" />
				<form:input path="name" class="form-control" />
			</p>
			<input type="submit" value="Create" class="btn btn-primary" />
		</form:form>
	</div>

	<!-- for bootstrap js & jquery -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

	<!-- my own js -->
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>