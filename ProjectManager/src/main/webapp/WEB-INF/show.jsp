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
<title>Project Details</title>
</head>

<body>
	<div class="wrapper">
		<div class="main_row1">
			<div class="row_left">
				<h1>Project Details</h1>
			</div>
			<div class="row_right">
				<a href="/dashboard">Back to Dashboard</a>
			</div>
		</div>
		<div class="main_row3">
			<div>
				<p>Project: ${project.title}</p>
				<p>Description: ${project.description}</p>
				<p>Due Date: <fmt:formatDate value="${project.due}" pattern="M/d/yyyy"/></p>
				<a href="/${project.id}/tasks">See tasks!</a>
			</div>
		</div>
		<div>
			<form action="/${project.id}/delete" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					type="submit" value="Delete Project" class="btn btn-danger" />
			</form>
		</div>
	</div>


	<!-- for bootstrap js & jquery -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

	<!-- for your own local js -->
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>