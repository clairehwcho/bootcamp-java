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
	<div class="row" id="row2">
		<div class="title">
			<h1>Edit expense</h1>
			<a href="/expenses">Go back</a>
		</div>
		<form:form action="/update/${expense.id}" method="put"
			modelAttribute="expense" id="addForm">
			<p>
				<!-- the value of path must match the member variable of the model -->
				<form:label path="name" class="form-label">Expense Name:</form:label>
				<form:errors path="name" class="errormessage" />
				<form:input path="name" class="form-control" />
			</p>
			<p>
				<form:label path="vendor" class="form-label">Vendor:</form:label>
				<form:errors path="vendor" class="errormessage" />
				<form:input path="vendor" class="form-control" />
			</p>
			<p>
				<form:label path="amount" class="form-label">Amount:</form:label>
				<form:errors path="amount" class="errormessage" />
				<form:input path="amount" class="form-control" />
			</p>
			<p>
				<form:label path="description" class="form-label">Description</form:label>
				<form:errors path="description" class="errormessage" />
				<form:textarea path="description" class="form-control" />
			</p>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>
</body>
</html>