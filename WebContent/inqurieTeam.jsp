<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
iframe {border-style:none; }
table {border-collapse:collapse; }
table, th, td {border:1px solid black; }
th, td {padding:5px; }
</style>
</head>
<body>


<jsp:useBean id="pikiteam" class="java.util.Vector" scope="request" />
<jsp:useBean id="pikiname" class="java.util.Vector" scope="request" />
 
<%
	Vector m_pikiteam=(Vector)request.getAttribute("pikiteam");
	Vector m_pikiname=(Vector)request.getAttribute("pikiname");%>

<form name="deleteTeam" method=post action="/pikiTest1/deleteServlet">

삭제를 원하면, 체크 후 아래 delete 버튼 사용
<table>
	<tr>
	<th>Team</th>
	<th>Name</th>
	<th>check</th>
	
<%	for(int i=0; i<m_pikiteam.size(); i++){%>
	</tr>
		<td><%=m_pikiteam.get(i) %></td>
		<td><%=m_pikiname.get(i) %></td>
		<td><input type="radio" name="Name" value="<%=m_pikiname.get(i)%>" ></td>
	</tr>
<%
	}
%>
</table>
 <input type="submit" value="delete">
</form>


</body>
</html>