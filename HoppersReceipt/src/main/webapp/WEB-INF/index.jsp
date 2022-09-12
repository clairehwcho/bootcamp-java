<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="EUC-KR">
<title>Simple Receipt</title>
</head>

<body>
<h3>Customer Name: <c:out value="${name}"/></h3>
<p>Item Name: <c:out value="${itemName}"/></p>
<p>Price: $<c:out value="${price}"/></p>
<p>Description: <c:out value="${description}"/></p>
<p>Vendor: <c:out value="${vendor}"/></p>
</body>

</html>