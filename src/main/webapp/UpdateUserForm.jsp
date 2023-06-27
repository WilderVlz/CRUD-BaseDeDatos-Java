<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Form</title>
<link rel="stylesheet" type="text/css" href="./Styles/stylesUpdate.css">
</head>
<body>
	<h1 class="form-heading">Update Client</h1>

	<form method="get" action="MainController">

		<input type="hidden" name="instruction" value="updateDB"> <input
			type="hidden" name="CTID" value="${userToUpdate.ctid}">

		<div class="form-group">
			<label for="name">NAME:</label> <input type="text" id="name"
				name="name" value="${userToUpdate.name}">
		</div>

		<div class="form-group">
			<label for="company">COMPANY:</label> <input type="text" id="company"
				name="company" value="${userToUpdate.company}">
		</div>

		<div class="form-group">
			<label for="address">ADDRESS:</label> <input type="text" id="address"
				name="address" value="${userToUpdate.address}">
		</div>

		<div class="form-group">
			<label for="country">COUNTRY:</label> <input type="text" id="country"
				name="country" value="${userToUpdate.country}">
		</div>

		<div class="form-group">
			<label for="salary">SALARY:</label> <input type="text" id="salary"
				name="salary" value="${userToUpdate.salary}">
		</div>

		<div class="button-group">
			<input type="submit" value="Update" class="btn-update"> <input
				type="reset" value="Reset" class="btn-reset">
		</div>

	</form>
</body>
</html>
