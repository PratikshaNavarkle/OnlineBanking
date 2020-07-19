<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Forgot Password</title>

<script type="text/javascript">

	function nospace(x)
	{
		if(x.keyCode == 32)
			{
			alert("No Space Allowed");
			return false;
			}
		return true;
	}
</script>

</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="CSS/ForgotPassword.css">
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
        <a class="nav-link" href="Home.jsp" align="center">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="UserLogin.jsp" align="center">User Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminLogin.jsp" align="center">Admin Login</a>
      </li>
    </ul>
  </div>
</nav>
</section>
<h2 align="center" id="forget">Forgot Password:</h2>
<section class="row justify-content-center">
	
	<form action="forgetPasswordServlet" method="post">
	
	<label for="accno"> Enter User Id : </label>
		<input required title="please enter valid User Id" pattern="^[0-9]{12}$"  type="number" placeholder="User Id" name="accno" class="form-control"  id="accno" onkeydown="return nospace(event)" align="middle" min="100000000000"><br>
	<label for="email"> Enter Email : </label>
		<input required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="please enter valid Email" type="email" placeholder="Email ID" name="email" class="form-control"  id="email" onkeydown="return nospace(event)" align="middle"><br>
	
	
	<input type="submit" class="btn btn-success" value="Submit" id="submit1"  align="middle">
	</form>
	</section>
</body>
</html>