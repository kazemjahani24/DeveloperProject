<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Create</title>
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
		
			<h1> Add developer info</h1>
			<form action = "home" method = "post">
			
			
				Name: <input type = "text" name  = "name" /><br />
				Position: <input type="text" name="position" /><br />
				Task: <input type="text" name="task" /><br />
				DOB: <input type="text" name="dob" id="datepicker" /><br />
				Father Name: <input type="text" name="fatherName" /><br />
				Email: <input type="text" name="email" /><br />
				
				<input type="submit" value="Submit Details" />
				
			</form>
		</center>
	</body>
</html>