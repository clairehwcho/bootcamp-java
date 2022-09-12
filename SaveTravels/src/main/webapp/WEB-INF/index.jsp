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
<title>Read Share</title>
</head>

<body>
	<div class="row">
		<div class="title">
			<h1>Save Travels</h1>
		</div>
		<table class="table table-striped table-hover" id="expenseList">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
					<tr>
						<td><a href="/expenses/${expense.id}"> <c:out
									value="${expense.name}" /></a></td>
						<td><c:out value="${expense.vendor}" /></td>
						<td><fmt:setLocale value="en_US" /> <fmt:formatNumber
								value="${expense.amount}" type="currency" /></td>
						<td><a href="/expenses/edit/${expense.id}">edit</a> <a
							href="/delete/${expense.id}" onclick="return confirm_delete()">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="row">
		<div class="title">
			<h3>Add an expense:</h3>
		</div>
		<form:form action="/addExpenses" method="post"
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

	<!-- for bootstrap js & jquery -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

	<!-- my own js -->
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>