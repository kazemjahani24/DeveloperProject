<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Success Page</title>
	</head>
	
	<body>
		<h1>Developer info successfully added</h1>
		<button onclick="redirectHome();">Home</button>
	
	</body>
	
	<script>
		function redirectHome(){
			console.log("URL:  "+window.location.host+"/developers");
			window.location.replace("http://"+window.location.host+"/developers");
		}
	</script>
</html>