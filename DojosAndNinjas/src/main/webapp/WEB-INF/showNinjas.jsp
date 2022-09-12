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
<title>Dojo Page</title>
</head>

<body>
	<div class="row">
		<div class="title">
			<h1>
				<c:out value="${dojo.name}" />
				Ninjas
			</h1>
		</div>
		<table class="table table-striped table-hover" id="ninjaList">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ninja" items="${ninjas}">
					<tr>
						<td><c:out value="${ninja.firstName}" /></td>
						<td><c:out value="${ninja.lastName}" /></td>
						<td><c:out value="${ninja.age}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- for bootstrap js & jquery -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

	<!-- my own js -->
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>