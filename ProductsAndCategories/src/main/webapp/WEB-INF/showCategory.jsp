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
<title>Category Page</title>
</head>

<body>
	<div class="wrapper">
		<div class="main_row1">
			<h1>${category.name}</h1>
		</div>

		<div class="main_row2">
			<p>
				<a href="/">Home</a>
			</p>
		</div>

		<div class="main_row4">
			<h3>Products:</h3>
			<ul>
				<c:forEach var="product" items="${assignedProducts}">
					<li><c:out value="${product.name}" /></li>

				</c:forEach>
			</ul>

			<hr>

			<h3>Add Product:</h3>
			<form action="/categories/${id}" method="post">
				<select name="productId" id="productId" class="form-select">
					<option value="none">--- Select ---</option>
					<c:forEach var="product" items="${unassignedProducts}">
						<option value="${product.id}">${product.name}</option>
					</c:forEach>
				</select> <input type="submit" value="Submit" class="btn btn-primary" />
			</form>

			<a href="/categories/edit/${id}"><input type="button" value="Edit" class="btn btn-warning" /></a> <br>
			<form action="/categories/${id}/delete" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					type="submit" value="Delete" class="btn btn-danger" />
			</form>

		</div>
	</div>

	<!-- for bootstrap js & jquery -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

	<!-- for your own local js -->
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>