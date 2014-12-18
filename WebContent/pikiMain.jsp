<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"
import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="EUC-KR">
<title>Piki Test Main</title>
<style>

</style>
</head>
<body>
<!--  http://www.coderanch.com/t/290885/JSP/java/text-box
http://stackoverflow.com/questions/5512442/input-type-text-value-from-jsp-form-enctype-multipart-form-data-returns-null
http://kaizar.tistory.com/196
http://xnom.tistory.com/45
-->
<form name="makeGroupForm" method=post action="/pikiTest1/pikiServlet" target="resultFrame">
	<input type="submit" value="make Group">
</form>

<!--  1218-->
<form name="inqurieForm" method=post action="/pikiTest1/dbServlet" target="resultFrame">
	<input type="submit" value="inqurie Group">
</form>
<form action="<%= request.getContextPath() %>/teamView.jsp" target="resultFrame">
하고 싶은 일:
	<select name= "code">
		
		<option value="insertTeam">insert</option>
		<option value="deleteTeam">delete</option>
	</select>
	<input type="submit" value="이동">
</form>



<!-- 1217추가 
<form name="inqurieTeam" method=post action="/pikiTest1/dbServlet" target="resultFrame">
	<input type="submit" value="inqurie Team">
</form>

<form name="insertTeam" method=post action="insertTeam.jsp" target="resultFrame">
	<input type="submit" value="insert Team">
</form>

<form name="deleteTeam" method=post action="deleteTeam.jsp" target="resultFrame">
	<input type="submit" value="delete Team">
</form>
-->
<iframe name="resultFrame" width="1200" height="1200"></iframe>




</body>
</html>