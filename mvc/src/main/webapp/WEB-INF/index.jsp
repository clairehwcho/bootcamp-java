<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Reading Books</title>
</head>

<body>
<h1>All Books</h1>
<table class="allBooksList">
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach var="book" items="${books}">
    		<tr>
        		<td><c:out value="${book.id}"/></td>
        		<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
				<td><c:out value="${book.language}"/></td>
				<td><c:out value="${book.numberOfPages}"/></td>
    		</c:forEach>
    </tbody>
</table>

</body>
</html>