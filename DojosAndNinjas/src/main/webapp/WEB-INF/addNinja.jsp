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
<title>New Ninja</title>
</head>

<body>
	<div class="row">
		<div class="title">
			<h1>New Ninja</h1>
		</div>
		<form:form action="/addNinja" method="post" modelAttribute="ninja"
			id="addForm">
			<p>
				<!-- the value of path must match the member variable of the model -->
				<form:label path="dojo" class="form-label">Dojo:</form:label>
				<form:errors path="dojo" class="errormessage" />
				<form:select path="dojo" class="form-select">
					<form:option value="none">--- Select ---</form:option>
					<c:forEach var="dojo" items="${dojos}">
						<form:option value="${dojo.id}">
							<c:out value="${dojo.name}" />
						</form:option>
					</c:forEach>
				</form:select>
			</p>
			<p>
				<form:label path="firstName" class="form-label">First Name:</form:label>
				<form:errors path="firstName" class="errormessage" />
				<form:input path="firstName" class="form-control" />
			</p>
			<p>
				<form:label path="lastName" class="form-label">Last Name:</form:label>
				<form:errors path="lastName" class="errormessage" />
				<form:input path="lastName" class="form-control" />
			</p>
			<p>
				<form:label path="age" class="form-label">Age:</form:label>
				<form:errors path="age" class="errormessage" />
				<form:input path="age" class="form-control" />
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