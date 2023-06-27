<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users form</title>
</head>
<body>

	<h1 style="text-align: center">Complete this form:</h1>

	<form method="get" action="MainController">

		<input type="hidden" name="instruction" value="add"> <label
			for="ctid">CTID:</label> <input type="text" id="ctid" name="ctid"><br>
		<br> <label for="name">NAME:</label> <input type="text" id="name"
			name="name"><br> <br> <label for="company">COMPANY:</label>
		<input type="text" id="company" name="company"><br> <br>
		<label for="address">ADDRESS:</label> <input type="text" id="address"
			name="address"><br> <br> <label for="country">COUNTRY:</label>
		<input type="text" id="country" name="country"><br> <br>
		<label for="salary">SALARY:</label> <input type="text" id="salary"
			name="salary"><br> <br> <input type="submit"
			value="Send"> <input type="reset" value="Reset">

	</form>

</body>
</html>