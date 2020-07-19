<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script>
			$(function() {
		        	$( "#datepicker" ).datepicker({
		        		dateFormat: "dd-mm-yyyy",
		        		changeYear: true
		        	});
			});
		</script>
	
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
	
	function checkBalance()
	{
		var a=document.getElementById("balance").value;
		var b=parseInt(a);
		if(b<500)
			{
			alert("Minimum balance should be between 500-10,000")
			}
		
	}

</script>
<title>Registration</title>

<link rel="stylesheet" href="CSS/Registration.css">
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
        <a class="nav-link" href="AdminLogin.jsp">Admin Login</a>
      </li> <li class="nav-item">
        <a class="nav-link" href="UserLogin.jsp">User Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Registration.jsp">Create Account</a>
      </li>
     
    </ul>
  </div>
</nav>

</section>
<div class="wrapper">
    <div class="title">
     Account Form
    </div>
    <form action="RegisterServlet" method="post">
    <div class="form">
       <div class="inputfield">
          <label for="fname">First Name</label>
          <input required autocomplete="off" onkeydown="return nospace(event)" pattern="^[A-Za-z]*$" title="please enter alphabets only. e.g. John " type="text" placeholder="First Name" name="firstName" id="fname" class="input">
          <script type="text/javascript"></script>
       </div> 
       <div class="inputfield">
          <label for="mname">Middle Name</label>
          <input required autocomplete="off" onkeydown="return nospace(event)" pattern="^[A-Za-z]*$" title="please enter alphabets only. e.g. John " type="text" placeholder="Middle Name" name="middleName" id="mname" class="input">
       </div>   
        <div class="inputfield">
          <label for="lname">Last Name</label>
          <input required autocomplete="off" onkeydown="return nospace(event)" pattern="^[A-Za-z]*$" title="please enter alphabets only. e.g. John " type="text" placeholder="Last Name" name="lastName" id="lname" class="input">
       </div>  
       <div class="inputfield">
          <label for="email">Email Address</label>
          <input class="input" autocomplete="off" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="please enter valid Email" type="email" placeholder="Email ID" name="email"  id="email" onkeydown="return nospace(event)" >
          
          
       </div> 
       <div class="inputfield">
          <label>Gender</label>
          <div class="custom_select">
            <select required="required"name="gender" id="gender">
              <option value="">Select</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
              <option values="others">Others</option>
            </select>
          </div>
       </div> 
       <div class="inputfield">
          <label for="datepicker">Date of Birth</label>
          <input autocomplete="off" onkeydown="return nospace(event)" required type="date" placeholder="dd/mm/yyyy" name="datepicker"  id="datepicker" onkeydown="return nospace(event)" min="1930-01-01" max="2020-01-01" class="input">
         
       </div> 
        <div class="inputfield">
          <label for="contact">Contact</label>
          <input autocomplete="off" onkeydown="return nospace(event)" required pattern="^[7-9]{1}[0-9]{9}$" title="please enter 10 digits only" type="text" placeholder="+91" name="contact" id="contact" class="input">
       </div> 
       <div class="inputfield">
          <label for="address">Address</label>
          <textarea required autocomplete="off" pattern="^[A-Za-z0-9'\.\-\s\,]$" title="please enter valid address" type="text" placeholder="Enter Residential Address" name="address" id="address"class="textarea"></textarea>
       </div> 
       
       
        <div class="inputfield">
          <label for="locality">Locality</label>
          <textarea required autocomplete="off" pattern="^[A-Za-z,]*$" title="please use alphabets only" type="text" placeholder="Area" name="locality" id="locality" class="textarea"></textarea>
       </div> 
       <div class="inputfield">
          <label for="landmark">Landmark</label>
          <input required autocomplete="off" pattern="^[A-Za-z,\s]*$" title="please use alphabets only" type="text" placeholder="Landmark" name="landmark" id="landmark" class="input">
       </div> 
       <div class="inputfield">
          <label for="pin">Postal Code</label>
          <input  required autocomplete="off" onkeydown="return nospace(event)" pattern="^[0-9]{6}$" title="please enter 6 digits only" type="number" placeholder="Pin Code" name="pin" id="pin"  class="input">
       </div> 
       <div class="inputfield">
          <label for="city">City</label>
          <input required type="text" placeholder="Pune" title="please enter alphabets only. e.g. Pune "  autocomplete="off" onkeydown="return nospace(event)" name="city" id="city" pattern="^[A-Za-z]*$" class="input">
       </div> 
       <div class="inputfield">
          <label for="state">State</label>
          <input required type="text" placeholder="Maharashtra" title="please enter alphabets only. e.g. Maharashtra "  autocomplete="off" onkeydown="return nospace(event)" name="state" id="state" pattern="^[A-Za-z]*$" class="input">
       </div> 
       <div class="inputfield">
          <label>Account type</label>
          <div class="custom_select">
            <select required="required"name="accType" id="accType">
              <option value="">Select</option>
              <option value="Savings">Savings</option>
              <option value="Current">Current</option>
              <option values="Fixeddeposit">Fixed Deposit</option>
              <option values="Recurringdeposit">Recurring Deposit</option>
              
            </select>
          </div>
        </div>
       <div class="inputfield">
       <label for="balance">Enter Account Balance(in Rs)</label>
       <input class="input" required autocomplete="off" pattern="^[1-9]{1}[0-9]$" min="500" max="10000" onkeydown="return nospace(event)" title="please enter amount between 500-10000" type="number" placeholder="500" name="balance" id="balance"><br>       
       
       </div>
       <div class="inputfield">
          <label for="aadharNo">Aadhar number</label>
          <input required autocomplete="off" pattern="^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$" title="please enter 12 digits only" type="number" placeholder="123412341234" name="aadharNo" id="aadharNo"class="input">
       </div> 
       <div class="inputfield">
          <label for="panNo">PAN number</label>
          <input required autocomplete="off" pattern="^[A-Z]{5}[0-9]{4}[A-Z]{1}$" title="only uppercase letters and digits are allowed" type="text" placeholder="ABCDE1234F" name="panNo" id="panNo" class="input">
       </div> 
      
      <div class="inputfield terms">
          <label class="check">
            <input type="checkbox">
            <span class="checkmark"></span>
          </label>
          <p>Agreed to terms and conditions</p>
       </div> 
      <div class="inputfield">
        <input type="submit" value="Create Account" id="submit1" class="btn">
      </div>
      <div class="inputfield">
        <input type="submit" value="Cancel" id="submit2" onclick="location.href='Home.jsp'" class="btn">
      </div>
      </form>
      <div class="panel-footer text-right">
				<small>&copy; ABC Bank</small>
				</div>
      
    </div>
</div>	
</body>
</html>