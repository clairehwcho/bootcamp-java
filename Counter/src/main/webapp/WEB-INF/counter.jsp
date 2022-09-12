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
<p>You have visited <c:out value="${page}"></c:out> <c:out value="${count}"></c:out> times.</p>
<p><a href="/"> Test another visit? </a></p>
<p><a href="/double-counter"> Add 2 visits </a></p>
<p><a href="/reset-counter"> Reset </a></p>
</body>
</html>