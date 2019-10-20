<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="org.developer.model.Developer" %>

<html>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Update</title>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	    <link rel="stylesheet" href="/resources/demos/style.css">
	    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	    <script>
		  $( function() {
		  	$( "#datepicker" ).datepicker();
		  });
		</script>
	
	</head>
	
	<body>
		<center>
			<%
				Developer developer = (Developer)request.getAttribute("developer");
				String dobString = (String)request.getAttribute("dobString");
			%>
			<h1>Update</h1>
			
			<form action = "update" method = "post">
				<table>
					<tr>
						<td>id</td>
						<td><input type="text" name="id" value="<%= developer.getId() %>" readonly="true" /></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name" value="<%= developer.getName() %>"></td>
					</tr>	
					<tr>
						<td>Position</td>
						<td><input type="text" name=position value="<%= developer.getPosition() %>"></td>
					</tr>
					<tr>
						<td>Task</td>
						<td><input type="text" name="task" value="<%= developer.getTask() %>"></td>
					</tr>
					<tr>
						<td>DOB</td>
						<td><input type="text" name="dob" value="<%= dobString %>" id="datepicker"></td>
					</tr>
					<tr>
						<td>Father Name</td>
						<td><input type="text" name="fatherName" value="<%= developer.getFatherName() %>"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email" value="<%= developer.getEmail() %>"></td>
					</tr>
				</table>
				<input type="submit" value="Update Details" />
			</form>
			
			<button onclick="redirectHome();">Home</button>
			<button onclick="redirectList();">Developer List</button>
		
			<script>
				function redirectHome(){
					console.log("URL:  "+window.location.host+"/developers");
					window.location.replace("http://"+window.location.host+"/developers");
				}
				
				function redirectList(){
					console.log("URL:  "+window.location.host+"/kasnet-webapp");
					window.location.replace("http://"+window.location.host+"/developers/find");
				}
				
			</script>
			
		</center>
		
	</body>
	
</html>