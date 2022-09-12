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
<title>Project Manager Dashboard</title>
</head>

<body>
	<div class="wrapper">
		<div class="main_row1">
			<div class="row_left">
				<h1>
					Welcome,
					<c:out value="${user.firstName}" />
				</h1>
			</div>
			<div class="row_right">
				<a href="/logout">logout</a>
			</div>
		</div>

		<div class="main_row2">
			<div class="row_left">
				<h4>All Projects</h4>
			</div>
			<div class="row_right">
				<a href="/projects/new"> <input type="button"
					value="+new project" class="btn btn-primary btn-sm">
				</a>
			</div>
		</div>

		<div class="main_row3">
			<table class="table table-striped table-hover" id="projectList">
				<thead>
					<tr>
						<th>Project</th>
						<th>Team Lead</th>
						<th>Due Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="project" items="${projects}">
						<tr>
							<td><a href="/projects/${project.id}"><c:out
										value="${project.title}" /></a></td>
							<td><c:out value="${project.user.firstName}" /></td>
							<td><fmt:formatDate value="${project.due}" pattern="MMM d"/></td>
							<td><a href="">Join team</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="main_row2">
			<h4>Your Projects</h4>
		</div>

		<div class="main_row3">
			<table class="table table-striped table-hover" id="projectList">
				<thead>
					<tr>
						<th>Project</th>
						<th>Lead</th>
						<th>Due Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="project" items="${projects}">
						<tr>
							<td><a href="/projects/${project.title}"><c:out
										value="${project.title}" /></a></td>
							<td><c:out value="${project.user.firstName}" /></td>
							<td><fmt:formatDate value="${project.due}" pattern="MMM d"/></td>
							<td><a href="">Join team</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


	</div>

	<!-- for bootstrap js & jquery -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

	<!-- for your own local js -->
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>