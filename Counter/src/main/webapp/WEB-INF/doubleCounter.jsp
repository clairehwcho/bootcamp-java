<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Current visit count</title>
</head>
<body>
<p>Two visits added!</p>
<p>You have visited <c:out value="${page}"></c:out> <c:out value="${count}"></c:out> times.</p>
<p><a href="/"> Back to the counter </a></p>
</body>
</html>