<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css" />
<title>Show Expense</title>
</head>

<body>
	<div class="row">
		<div class="title">
			<h1>Expense Details</h1>
			<a href="/expenses">Go back</a>
		</div>
		<div class="row2">
			<p>Expense Name: ${expense.name}</p>
			<p>Expense Description: ${expense.description}</p>
			<p>Vendor: ${expense.vendor}</p>
			<p>Amount Spent: $ ${expense.amount}</p>
		</div>
	</div>
</body>
</html>