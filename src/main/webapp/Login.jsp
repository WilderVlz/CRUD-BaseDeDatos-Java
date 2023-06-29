<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<h1 style="text-align: center">Login</h1>

	<form action="MainController" method="get">

<!-- <input type="hidden" name="instruction" value="showUsers"> -->
		
		<input type=hidden name="instruction" value="verifyLogin"> 

		<table width="35%" border="0">

			<tr>
				<td width="13%"><label for="user">User:</label></td>
				<td widht="87%"><input type="text" name="user" id=""></td>

			</tr>
			<tr>
				<td><label for="password">Company:</label></td>
				<td><input type="text" name="password" id="password"></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="button" id="button" value="Login"></td>
			</tr>

		</table>

		<p>
			<br>
		</p>

	</form>

</body>
</html>