<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Password</title>
</head>
<%
String ano=request.getAttribute("ano").toString();
%>
<body>
NEW Password page
	<form action="changePasswordServlet" method="post">
	<label for="userpass"> enter New Password : </label>
		<input required title="please enter valid password" pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$" type="userpass" placeholder="12@.aK6" name="userpass" class="form-control"  id="otp" ><br>
	<label for="confpass">confirm  Password : </label>
		<input required title="please enter valid password"  type="confpass" placeholder="12@.aK6" pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$" name="confpass" class="form-control"  id="otp" ><br>
	<input type="submit" class="btn btn-primary" value="Change" id="validate" onclick="success()">
	<input type="hidden" name="ano" value=<%=ano%>>
	</form>
</body>
</html>