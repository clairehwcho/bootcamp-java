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
<title>Props Page</title>
</head>

<body>
	<div class="wrapper">
		<div class="main_row1">
			<div class="row_left">
				<h1 style="font-style: italic;">
					<c:out value="${book.title}" />
				</h1>
			</div>
			<div class="row_right">
				<a href="/books">back to the shelves</a>
			</div>
		</div>
		<div class="main_row3">
			<c:set var="currentUserId" value="${currentUser.id}" />
			<c:set var="bookUserId" value="${book.user.id}" />
			<c:if test="${currentUserId == bookUserId }">
				<div>
					<h3>
						You read <span style="color: purple"><c:out
								value="${book.title}" /></span> by <span style="color: green"><c:out
								value="${book.author}" /></span>.
					</h3>
					<h3>Here are your thoughts:</h3>
				</div>
				<div style="width: 500px; padding: 0px, 20px; text-align: center;">
					<hr>
					<c:out value="${book.thought}" />
					<hr>
				</div>
				<div
					style="width: 150px; display: flex; justify-content: space-between;">
					<a href="/books/${book.id}/edit">
					<input type="button" value="Edit" class="btn btn-primary" />
					</a>
					<form action="/${book.id}/delete" method="post">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" value="Delete" class="btn btn-primary"/>
					</form>
				</div>
			</c:if>

			<c:if test="${currentUserId != bookUserId }">
				<div>
					<h3>
						<span style="color: red"><c:out value="${book.user.name}" /></span>
						read <span style="color: purple"><c:out
								value="${book.title}" /></span> by <span style="color: green"><c:out
								value="${book.author}" /></span> .
					</h3>
					<h3>
						Here are
						<c:out value="${book.user.name}" />
						's thoughts:
					</h3>
				</div>
				<div style="width: 500px; padding: 0px, 20px; text-align: center;">
					<hr>
					<c:out value="${book.thought}" />
					<hr>
				</div>
			</c:if>
		</div>
	</div>

	<!-- for bootstrap js & jquery -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

	<!-- for your own local js -->
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>