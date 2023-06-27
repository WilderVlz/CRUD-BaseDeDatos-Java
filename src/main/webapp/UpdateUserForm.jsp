<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
</head>
<body>

<h1 style="text-align: center"> Update Client:</h1>

<form method="get" action="MainController">

<input type="hidden" name="instruction" value="updateDB">

<input type="hidden" name="CTID" value="${userToUpdate.ctid}">
  
  <label for="name">NAME:</label>
  <input type="text" id="name" name="name" value="${userToUpdate.name}"><br><br>
  
  <label for="company">COMPANY:</label>
  <input type="text" id="company" name="company" value="${userToUpdate.company}"><br><br>
  
  <label for="address">ADDRESS:</label>
  <input type="text" id="address" name="address" value="${userToUpdate.address}"><br><br>
  
  <label for="country">COUNTRY:</label>
  <input type="text" id="country" name="country" value="${userToUpdate.country}"><br><br>
  
  <label for="salary">SALARY:</label>
  <input type="text" id="salary" name="salary" value="${userToUpdate.salary}"><br><br>
  
  <input type="submit" value="Update">
  <input type="reset" value="Reset">
</form>


</body>
</html>