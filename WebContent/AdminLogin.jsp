<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>



<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="AdminLogin.css">
<link rel="stylesheet" href="Style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" ></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
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
        <a class="nav-link" href="UserLogin.jsp">User Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Registration.jsp">Create Account</a>
      </li>
     
    </ul>
  </div>
</nav>

</section>


<section id="banner">

<div class="container">

<div class="row">

<div class="col-md-6">

<p class="promo-title">ABC BANK-THE CUSTOMER'S CHOICE</p>

<p>ABC Bank has been voted as the best bank across INDIA in the financial year of 2019-2020 through public opinion </p>
</div>

<div class="col-md-6 text-center">
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQSRCcJQx1rshFDPgXHXTCv9iLQOx_DEmXv3g&usqp=CAU" class="img-fluid">

</div>
</div>

</div>
</section>
<!-- --------services -->

<h1 align="center">ADMIN LOGIN</h1>
<section class="container-fluid">
<section class="row justify-content-center">

<section=class="col-12 col-sm-6 col-md-3">

<form class="form-container" action="AdminValidation" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">ADMIN ID</label>
    <input type="text" class="form-control" id="exampleInputAccno1" aria-describedby="AccHelp" name="id">
    <small id="AccHelp" class="form-text text-muted">Admin id sharing  is prohibited by the bank by all means.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">ADMIN PASSWORD</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
  </div>
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Keep me logged in</label>
  </div>
  <button type="submit" class="btn btn-success btn-block">Submit</button>
</form>

</section>

</section>
</section>


</body>
</html>