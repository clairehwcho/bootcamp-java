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
				<h1>
					Welcome,
					<c:out value="${user.name}" />
				</h1>
			</div>
			<div class="row_right">
				<a href="/logout">logout</a>
			</div>
		</div>
		<div class="main_row2">
			<div class="row_left">
				<p>Books from everyone's shelves:</p>
			</div>
			<div class="row_right">
				<p>
					<a href="/books/new">+Add a book to my shelf</a>
			</div>
		</div>
		<div class="main_row3">
			<table class="table table-striped table-hover" id="bookList">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Author Name</th>
						<th>Posted By</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${books}">
						<tr>
							<td><c:out value="${book.id}" /></td>
							<td><a href="/books/${book.id}"><c:out
										value="${book.title}" /></a></td>
							<td><c:out value="${book.author}" /></td>
							<td><c:out value="${book.user.name}" /></td>
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