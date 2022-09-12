<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Ninja Gold Game</title>
</head>
<body>
<div class="wrapper">

	<div class="row1">
		<div class="row1_left">Your Gold: </div>
		<div class="row1_right"><c:out value="${currentGold}"/></div>
	</div>

	<div class="row2">
		<div class="row2_box">
			<p>Farm</p>
			<p>(earns 10-20 gold)</p>
			<form action='/processGold' method='post'>
			<input type="submit" name="farm" value="Find Gold!">
			</form>
		</div>
		<div class="row2_box">
			<p>Cave</p>
			<p>(earns 5-10 gold)</p>
			<form action='/processGold' method='post'>
			<input type="submit" name="cave" value="Find Gold!"> 
			</form>
		</div>
		<div class="row2_box">
			<p>House</p>
			<p>(earns 2-5 gold)</p>
			<form action='/processGold' method='post'>
			<input type="submit" name="house" value="Find Gold!">
			</form>
		</div>
		<div class="row2_box">
			<p>Quest</p>
			<p>(takes 0-50 gold)</p>
			<form action='/processGold' method='post'>
			<input type="submit" name="quest" value="Find Gold!">
			</form>
		</div>
	</div>

	<div class="row3">
		<label class="form-label">Activities:</label>
		<iframe src="/activities" title="Activities Iframe"></iframe>
	</div>
	<form action="/reset" method="post">
	<input class="button" type="submit" value="Reset"/></form>
</div>
</body>
</html>