<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"
import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="EUC-KR">
<title>Piki Test Main</title>
<style>
iframe {border-style:none; width:100%; }
	aside, section {display:block; }
	aside {width:10%; float:left; }
	section {margin-bottom:10px; width:85%; height:2000px; float:right; }
</style>
</head>
<body>

	<script>
		var graphDisabled = false;
		
		function autoResize() {
			var iframeHeight = document.getElementById("groupFrame").contentWindow.document.body.scrollHeight;
    		document.getElementById("groupFrame").height = iframeHeight;
			document.getElementById("graphFrame").style.top = iframeHeight;
		}
		
		window.onload = function() {
			var iframeElement = document.getElementById("groupFrame");
			iframeElement.onload = autoResize;
		}
	</script>

<aside>
	<form name="makeGroupForm" method=post action="/pikiTest1/pikiServlet" target="groupFrame">
		<input type="submit" value="make Group" onClick="buttonEnabled()">
		
		<script>
		function buttonEnabled() {
    		graphDisabled = true;
    		
    		var iframeElement = document.getElementById("groupFrame");
    		iframeElement.onload = autoResize;
    		
    		var graphIFrame = document.getElementById("graphFrame").contentWindow.document;
    		graphIFrame.open();
    		graphIFrame.close();
    		
    		var iframeHeight = document.getElementById("groupFrame").contentWindow.document.body.scrollHeight;
    		document.getElementById("groupFrame").height = iframeHeight;
    		document.getElementById("graphFrame").style.top = iframeHeight;
		}
		</script>
	
	</form>
	<form name="drawGraphForm" method=get action="/pikiTest1/pikiServlet" target="graphFrame">
		<input type="submit" value="draw Graph" id="drawGraph" onClick="return buttonDisabled();">
		
		<script>
		function buttonDisabled() {
			if(graphDisabled==false) {
				alert("그룹을 먼저 클릭하세요.");
				return false;
			}
			else {
				graphDisabled = false;
				return true;
			}
		}
		</script>
		
	</form>
	<form name="inqurieForm" method=post action="/pikiTest1/dbServlet" target="groupFrame">
		<input type="submit" value="inqurie Group" onClick="buttonEnabled()">
	</form>
	<form action="<%= request.getContextPath() %>/teamView.jsp" target="groupFrame">
		하고 싶은 일:
		<select name= "code">
		
			<option value="insertTeam">insert</option>
			<option value="deleteTeam">delete</option>
		</select>
		<input type="submit" value="이동">
	</form>
</aside>

<section>
	<iframe name="groupFrame" id="groupFrame"></iframe>
	<iframe name="graphFrame" id="graphFrame" height="1000"></iframe>
	
</section>

</body>
</html>