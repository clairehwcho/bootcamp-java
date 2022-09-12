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
<title>Home</title>
</head>

<body>
	<div class="wrapper">
		<div class="main_row1">
			<h1>Home Page</h1>
		</div>
		<div class="main_row2">
			<p>
				<a href="/products/new">New Product</a>
			</p>
			<p>
				<a href="/categories/new">New Category</a>
			</p>
		</div>
		<div class="main_row3">
			<table class="table">
				<thead>
					<tr style="text-align: center">
						<th>Products</th>
						<th>Categories</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<ul>
								<c:forEach var="product" items="${products}">
									<li><a href="/products/${product.id}"><c:out
												value="${product.name}" /></a></li>
								</c:forEach>
							</ul>
						</td>

						<td><ul>
								<c:forEach var="category" items="${categories}">
									<li><a href="/categories/${category.id}"><c:out
												value="${category.name}" /></a></li>
								</c:forEach>
							</ul></td>
					</tr>
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