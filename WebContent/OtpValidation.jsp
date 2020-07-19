<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="CSS/OtpValidation.css">
<%
String ano=request.getAttribute("ano").toString();
String otp=request.getAttribute("otp").toString();
%>
<body>
<section id="nav-bar">

<nav class="navbar navbar-expand-lg navbar-light">
  <a class="navbar-brand" href="#"><img src="https://www.freepnglogos.com/uploads/abc-png-logo/play-abc-logo-png-22.png"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <i class="fa fa-bars" aria-hidden="true"></i>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="Home.jsp">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminLogin">Admin Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Registration.jsp">Create Account</a>
      </li>
     
    </ul>
  </div>
</nav>
</section>

<h2 align="center">OTP Validation</h2>
	<form action="validateOtpServlet" method="post">
	<label for="otp"> Enter OTP : </label>
		<input required title="please enter valid OTP"  type="number" placeholder="123456" name="userotp" class="form-control"  id="otp" ><br>
	<input type="submit" class="btn btn-primary" value="Validate" id="validate" onclick="success()">
	<input type="hidden" name="ano" value=<%=ano%>>
	<input type="hidden" name="otp" value=<%=otp%>>
	</form>
</body>
</html>