<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<link rel="stylesheet" type="text/css" href="./Styles/stylesHome.css">

</head>
<body>

	<table>

		<tr>

			<th class="header">CTID</th>
			<th class="header">NAME</th>
			<th class="header">COMPANY</th>
			<th class="header">ADDRESS</th>
			<th class="header">COUNTRY</th>
			<th class="header">SALARY</th>
			<th class="header">Method</th>

		</tr>

		<c:forEach var="w" items="${Users}">
			
			<!--Link to update clients -->
			
			<c:url var="updateUser" value="MainController">
			
			<c:param name="instruction" value="update"></c:param>
			<c:param name="CTID" value="${w.ctid}"></c:param>
			
			</c:url>
		
			<tr>

				<td class="rows">${w.ctid}</td>
				<td class="rows">${w.name}</td>
				<td class="rows">${w.company}</td>
				<td class="rows">${w.address}</td>
				<td class="rows">${w.country}</td>
				<td class="rows">${w.salary}</td>
				<td id="rows"><a href="${updateUser}">Update </a>

			</tr>

		</c:forEach>
	</table>

	<input type="button" value="Insert new user"
		onclick="window.location.href='InsertUserForm.jsp'">

</body>
</html>
