<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Delete Team JSP</title>
<style>
iframe {border-style:none; }
</style>
</head>
<body>
<% String[] team = {"Develop","Design","Plan", "Server", "Contents", "CN", "ST"};%>
<form name="deleteTeam" method=post action="/pikiTest1/deleteServlet">
	delete Team & Name<br>
	Team : <select name ="Team">
	<% for(int i=0; i<team.length ;i++){%>
		<option> <%= team[i] %></option>
	<% }%>
	</select><br>
	
	Name : <input type="text" name ="Name"><br>
	<input type="submit" value="delete Team">
</form>
</body>
</html>