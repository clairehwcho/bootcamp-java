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
<title>Edit My Task</title>
</head>

<body>
	<div class="wrapper">
		<div class="main_row1">
			<h1>Edit Project</h1>
		</div>
		<div class="main_row3">
			<form:form action="/${project.id}/update/" method="put"
				modelAttribute="project" id="addForm">
				<p>
					<form:input type="hidden" path="user" value="${currentUser.id}" />
				</p>
				<p>
					<form:label path="title" class="form-label">Project Title:</form:label>
					<form:errors path="title" class="errormessage" />
					<form:input path="title" class="form-control" />
				</p>
				<p>
					<form:label path="description" class="form-label">Project Description:</form:label>
					<form:errors path="description" class="errormessage" />
					<form:textarea path="description" class="form-control" />
				</p>
				<p>
					<form:label path="due" class="form-label">Due Date:</form:label>
					<form:errors path="due" class="errormessage" />
					<form:input type="date" path="due" class="form-control" />
				</p>
				<div
					style="width: 150px; display: flex; justify-content: space-between;">
					<a href="/dashboard"> <input type="button" value="Cancel"
						class="btn btn-primary" /></a> <input type="submit" value="Submit"
						class="btn btn-primary" />
				</div>

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