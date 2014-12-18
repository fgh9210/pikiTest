<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
    String code = request.getParameter("code");
    String ViewPageURl= null;
    
   
   if(code.equals("insertTeam")){
    	ViewPageURl="/insertTeam.jsp";
    }else if(code.equals("deleteTeam")){
    	ViewPageURl="deleteTeam.jsp";
    }
    %>
    <jsp:forward page="<%= ViewPageURl %>"></jsp:forward>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>


   

</body>
</html>