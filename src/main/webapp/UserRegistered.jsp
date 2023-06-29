<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HolaWill</title>
</head>
<body>


	<table>

		<tr>


			<th>Id</th>
			<th>Name</th>
			<th>Company</th>
			<th>Address</th>
			<th>Country</th>
			<th>Salary</th>

		</tr>

		<tr>



			<td>${userR.ctid}</td>
			<td>${userR.name}</td>
			<td>${userR.company}</td>
			<td>${userR.address}</td>
			<td>${userR.country}</td>
			<td>${userR.salary}</td>


		</tr>


	</table>











</body>
</html>