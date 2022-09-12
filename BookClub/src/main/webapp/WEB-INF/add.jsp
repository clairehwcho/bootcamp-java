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
		<div class="main_row1">
			<div class="row_left">
				<h1>Add a Book to Your Shelf!</h1>
			</div>
			<div class="row_right">
				<a href="/books">back to the shelves</a>
			</div>
		</div>
		<div class="main_row3">
			<form:form action="/saveBook" method="post" modelAttribute="book"
				id="addForm">
				<p>
					<form:input type="hidden" path="user" value="${user.id}" />
				</p>
				<p>
					<form:label path="title" class="form-label">Title:</form:label>
					<form:errors path="title" class="errormessage" />
					<form:input path="title" class="form-control" />
				</p>
				<p>
					<form:label path="author" class="form-label">Author:</form:label>
					<form:errors path="author" class="errormessage" />
					<form:input path="author" class="form-control" />
				</p>
				<p>
					<form:label path="thought" class="form-label">My thoughts</form:label>
					<form:errors path="thought" class="errormessage" />
					<form:textarea path="thought" class="form-control" />
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