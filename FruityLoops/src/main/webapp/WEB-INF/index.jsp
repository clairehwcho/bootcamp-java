<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Fruit Store</title>
</head>
<body>
    <h1>Fruit Store</h1>
    <table>
    	<thead>
    		<tr>
    			<th> Name </th>
    			<th> Price </th>
    		</tr>
    	</thead>
    	<tbody>
    	    <c:forEach var="oneFruit" items="${fruitsFromController}">
    		<tr>
        		<td><c:out value="${oneFruit.name}"></c:out></td>
        		<td><c:out value="${oneFruit.price}"></c:out></td>        		
    		</c:forEach>
    </tbody>
    </table>
</body>
</html>