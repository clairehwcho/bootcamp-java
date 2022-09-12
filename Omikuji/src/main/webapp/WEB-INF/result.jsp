<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Omikuji</title>
</head>
<body>
<h3>Here's Your Omikuji!</h3>
<span class="resultbox">In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${name}"/> as your rommate, <c:out value="${hobby}"/> for a living.
The next time you see a <c:out value="${livingname}"/>, you will have good luck. Also, <c:out value="${message}"/>
</span>

<p><a href="/omikuji">Go Back</a></p>

</body>
</html>