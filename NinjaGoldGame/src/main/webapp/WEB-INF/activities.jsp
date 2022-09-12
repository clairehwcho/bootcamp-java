<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Ninja Gold Game</title>
</head>
<body>
<c:forEach var="activities" items="${activities}">
	<c:if test = "${activities.contains('earned')}">
       <p style="color: green;"><c:out value="${activities}"></c:out></p>
    </c:if>
    <c:if test = "${activities.contains('lost')}">
       <p style="color: red;"><c:out value="${activities}"></c:out></p>
    </c:if>
</c:forEach>

</body>
</html>