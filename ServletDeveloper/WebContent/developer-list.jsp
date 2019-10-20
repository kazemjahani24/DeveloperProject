<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List" %>
<%@ page import="org.developer.model.Developer" %>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Developer List</title>
		<style>
			table {
			  font-family: arial, sans-serif;
			  border-collapse: collapse;
			  width: 80%;
			}
			
			td, th {
			  border: 1px solid #c9ffff;
			  text-align: left;
			  padding: 8px;
			}
			
			tr:nth-child(even) {
			  background-color: #e6ffff;
			}
		</style>
	</head>
	
	<body>
	
		<center>
			<h1>Developer List</h1>
			<div>	
				<a href="create">Add Developer</a>
			</div>
			<table>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Details</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
				<%
					List<Developer> developerList = (List<Developer>) request.getAttribute("developerList");
					for (Developer developer : developerList) {
				%>
		
				<tr>
					<td><%=developer.getId()%></td>
					<td><%=developer.getName()%></td>
					<td><a href="details?id=<%=developer.getId()%>">Details</a></td>
					<td><a href="update?id=<%=developer.getId()%>">Update</a></td>
					<td><a href="delete?id=<%=developer.getId()%>">Delete</a></td>
				</tr>
		
				<%
					}
				%>
			</table>
			<button onclick="redirectHome();">Home</button>
			
		</center>
		
	
		<script>
			function redirectHome() {
				window.location.replace("http://" + window.location.host+ "/developers");
			}
		</script>
	
	</body>
	
</html>