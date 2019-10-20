<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="org.developer.model.Developer"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Details</title>
	</head>
	<body>
		<%
			Developer developer = (Developer)request.getAttribute("developer");
		
		%>
		<h1>Developer Details</h1>
		
		<table>
			<tr>
				<td>Id</td>
				<td><%= developer.getId() %></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><%= developer.getName() %></td>
			</tr>
			<tr>
				<td>Position</td>
				<td><%= developer.getPosition() %></td>
			</tr>
			<tr>
				<td>Task</td>
				<td><%= developer.getTask() %></td>
			</tr>
			<tr>
				<td>DOB</td>
				<td><%= developer.getDob() %></td>
			</tr>
			<tr>
				<td>Father Name</td>
				<td><%= developer.getFatherName() %></td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td><%= developer.getEmail() %></td>
			</tr>
		</table>
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
	</body>
</html>