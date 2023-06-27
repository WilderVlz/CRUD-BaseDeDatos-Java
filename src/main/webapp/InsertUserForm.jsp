<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="./Styles/stylesInsert.css">
  <meta charset="UTF-8">
  <title>Users Form</title>
</head>
<body>
  <h1 class="form-heading">Complete this form:</h1>

  <form method="get" action="MainController">

    <input type="hidden" name="instruction" value="add">

    <div class="form-group">
      <label for="ctid">CTID:</label>
      <input type="text" id="ctid" name="ctid">
    </div>

    <div class="form-group">
      <label for="name">NAME:</label>
      <input type="text" id="name" name="name">
    </div>

    <div class="form-group">
      <label for="company">COMPANY:</label>
      <input type="text" id="company" name="company">
    </div>

    <div class="form-group">
      <label for="address">ADDRESS:</label>
      <input type="text" id="address" name="address">
    </div>

    <div class="form-group">
      <label for="country">COUNTRY:</label>
      <input type="text" id="country" name="country">
    </div>

    <div class="form-group">
      <label for="salary">SALARY:</label>
      <input type="text" id="salary" name="salary">
    </div>

    <div class="button-group">
      <input type="submit" value="Send" class="btn-send">
      <input type="reset" value="Reset" class="btn-reset">
    </div>

  </form>

</body>
</html>
