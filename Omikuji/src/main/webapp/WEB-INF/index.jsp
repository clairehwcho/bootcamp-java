<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Omikuji</title>
</head>
<body>
    <h3>Send an Omikuji!</h3>
    <form action='/processOmikuji' method='post'>
    <label class="form-label">Pick any number from 5 to 25</label>
    <input class="form-control" type="number" name='number' min="0" max="25" style="width:300px">
	
	<label class="form-label">Enter the name of any real person</label>
    <input class="form-control" type='text' name='name' style="width:300px">
    
    <label class="form-label">Enter professional endeavor or hobby</label>
    <input class="form-control" type="text" name='hobby' style="width:300px">
    
    <label class="form-label">Enter any type of living thing</label>
    <input class="form-control" type="text" name='livingname' style="width:300px">
    
    <label class="form-label">Say something nice to someone</label>
    <textarea class="form-control" name='message' style="width:300px"></textarea>
    
    <p>Send and show a friend</p>
    
    <input type='submit' value='Send'>
    </form>

</body>
</html>