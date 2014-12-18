<%@ page language = "java" contentType = "text/html; charset = EUC-KR" pageEncoding = "EUC-KR"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset = "EUC-KR">
<style>
   canvas {border:1px solid #E6E6E6; }
</style>
</head>

<body>
	<canvas id = "capabilityCanvas" height = "500" width = "800"></canvas>
<%
	String allCount = request.getAttribute("allCount").toString();
	String capability;
	int arrLength = (Integer)request.getAttribute("capabilityLength");
	
	int[] capabilityArray = new int[arrLength];
	String[] groupName = new String[arrLength];
		
	for(int i=0; i<arrLength; i++) {
		groupName[i] = request.getAttribute("groupName"+i).toString();
		
		capability = request.getAttribute("capability"+i).toString();
		capabilityArray[i] = (int)Float.valueOf(capability).floatValue();
	}
%>

	<script>	 
 		var canvas = document.getElementById("capabilityCanvas");
		var context = canvas.getContext("2d");

		context.beginPath();
		context.moveTo(50,50);
		context.lineTo(50,450);
		context.lineTo(750,450);
		context.lineWidth = 1;
		context.strokeStyle = "#000";
		context.stroke();
		context.closePath();
		
		//100´«±Ý
		context.beginPath();
		context.moveTo(45, 50);
		context.lineTo(750, 50);
		context.lineWidth = 1;
		context.strokeStyle = "#D6D6D6";
		context.stroke();
	    context.closePath();

	    //yÃâ
		context.fillStyle = "#000";
		context.font = "10px µ¸¿ò";
	    context.fillText("Á÷¹«´É·Â(%)",32,23);
	    //100
		context.fillStyle = "#000";
		context.font = "12px µ¸¿ò";
	    context.fillText("100",22,55);
		//90
		context.beginPath();
		context.moveTo(45, 90);
		context.lineTo(750, 90);
		context.lineWidth = 1;
		context.strokeStyle = "#D6D6D6";
		context.stroke();
	    context.closePath();
		context.fillStyle = "#000";
		context.font = "12px µ¸¿ò";
	    context.fillText("90",27,95);
	    //80
		context.beginPath();
		context.moveTo(45, 130);
		context.lineTo(750, 130);
		context.lineWidth = 1;
		context.strokeStyle = "#D6D6D6";
		context.stroke();
	    context.closePath();
		context.fillStyle = "#000";
		context.font = "12px µ¸¿ò";
	    context.fillText("80",27,135);
		//70
		context.beginPath();
		context.moveTo(45, 170);
		context.lineTo(750, 170);
		context.lineWidth = 1;
		context.strokeStyle = "#D6D6D6";
		context.stroke();
	    context.closePath();
		context.fillStyle = "#000";
		context.font = "12px µ¸¿ò";
	    context.fillText("70",27,175);
		//60
		context.beginPath();
		context.moveTo(45, 210);
		context.lineTo(750, 210);
		context.lineWidth = 1;
		context.strokeStyle = "#D6D6D6";
		context.stroke();
	    context.closePath();
		context.fillStyle = "#000";
		context.font = "12px µ¸¿ò";
	    context.fillText("60",27,215);
	    //50
		context.beginPath();
		context.moveTo(45, 250);
		context.lineTo(750, 250);
		context.lineWidth = 1;
		context.strokeStyle = "#D6D6D6";
		context.stroke();
	    context.closePath();
		context.fillStyle = "#000";
		context.font = "12px µ¸¿ò";
	    context.fillText("50",27,255);
		//40
		context.beginPath();
		context.moveTo(45, 290);
		context.lineTo(750, 290);
		context.lineWidth = 1;
		context.strokeStyle = "#D6D6D6";
		context.stroke();
	    context.closePath();
		context.fillStyle = "#000";
		context.font = "12px µ¸¿ò";
	    context.fillText("40",27,295);
		//30
		context.beginPath();
		context.moveTo(45, 330);
		context.lineTo(750, 330);
		context.lineWidth = 1;
		context.strokeStyle = "#D6D6D6";
		context.stroke();
	    context.closePath();
		context.fillStyle = "#000";
		context.font = "12px µ¸¿ò";
	    context.fillText("30",27,335);
	    //20
		context.beginPath();
		context.moveTo(45, 370);
		context.lineTo(750, 370);
		context.lineWidth = 1;
		context.strokeStyle = "#D6D6D6";
		context.stroke();
	    context.closePath();
		context.fillStyle = "#000";
		context.font = "12px µ¸¿ò";
	    context.fillText("20",27,375);
		//10
		context.beginPath();
		context.moveTo(45, 410);
		context.lineTo(750, 410);
		context.lineWidth = 1;
		context.strokeStyle = "#D6D6D6";
		context.stroke();
	    context.closePath();
	    context.fillStyle = "#000";
		context.font = "12px µ¸¿ò";
	    context.fillText("10",27,415);
	    //0
	    context.fillStyle = "#000";
	  	context.font = "12px µ¸¿ò";
      	context.fillText("0",33,455);
      	
<%
	for(int x=0; x<arrLength; x++) {
%>
		//xÃà
		context.beginPath();
		context.moveTo(<%=x%>*40+50, 50);
		context.lineTo(<%=x%>*40+50, 450);
		context.lineWidth = 1;
		context.strokeStyle = "#D6D6D6";
		context.stroke();
		context.closePath();
		context.fillStyle = "#000";
		context.font = "12px µ¸¿ò";
		context.fillText("<%=groupName[x]%>", <%=x%>*40+48, 470);
<%
	}
 %>
 		context.fillStyle = "#000";
		context.font = "10px µ¸¿ò";
		context.fillText("±×·ì",770,455);
		
		//xÃà
		context.beginPath();
		
		
<%
	for(int g=0; g<arrLength; g++) {
		
		if(g==0) {
%>
		context.moveTo(<%=g%>*40+50, 450-<%=capabilityArray[g]%>*4);
<%
		}
		else {
%>
		context.lineTo(<%=g%>*40+50, 450-<%=capabilityArray[g]%>*4);
<%
		}
	}
%>
		context.lineWidth = 3;
		context.strokeStyle = "#F361A6";
		context.stroke();
		context.closePath();
 
	</script>

</body>
</html>