<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registration</title>
<link rel="stylesheet" href="jquery-ui.css" />
		<script type="text/javascript" src="foodies.js" />
		<script src="jquery-1.8.2.js"></script>
		<script src="jquery-ui.js"></script>
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

</script>
<link rel="stylesheet" href="Home.css">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row col-md-6  col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading text-center">
				<h1>Registration Form</h1>
				</div>
				<div class="panel-body">
				<form action="RegisterServlet" method="post">
				
				<div class="form-group">
				
				<label for="name">First Name</label>
					<input required autocomplete="off" onkeydown="return nospace(event)" pattern="^[A-Za-z]*$" title="please enter alphabets only. e.g. John " type="text" placeholder="First Name" name="firstName" class="form-control"  id="fname"><br>
				</div>
				
				<div class="form-group">
				
				<label for="name">Middle Name</label>
					<input required autocomplete="off" onkeydown="return nospace(event)" pattern="^[A-Za-z]*$" title="please enter alphabets only. e.g. John " type="text" placeholder="Middle Name" name="middleName" class="form-control"  id="mname"><br>
				</div>
				
				<div class="form-group">
				
				<label for="name">Last Name</label>
					<input required autocomplete="off" onkeydown="return nospace(event)" pattern="^[A-Za-z]*$" title="please enter alphabets only. e.g. John " type="text" placeholder="Last Name" name="lastName" class="form-control"  id="lname"><br>
				</div>
			
				<div class="form-group">
				<label for="address">Enter Your Address</label>
					<input required autocomplete="off" pattern="^[#.@0-9a-zA-Z\s,-]+$" title="please use #,.,@,- symbols only" type="text" placeholder="Enter Residential Address" name="address" class="form-control" id="address"><br>
				</div>
				
				<div class="form-group">
				<label for="pin">Enter Pin Code</label>
					<input required autocomplete="off" pattern="^[0-9]{6}" title="please enter 6 digits only" type="number11" placeholder="Pin Code" name="pin" class="form-control" id="pin"><br>
				</div>
			
				<div class="form-group">
				<label for="city">City </label> <select name="city" id="city" style="width: 400px" required>
			<option value="Ahmadnagar">Ahmadnagar</option>
			<option value="Akola">Akola</option>
			<option value="Amravati">Amravati</option>
			<option value="Aurangabad">Aurangabad</option>
			<option value="Bhandara">Bhandara</option>
			<option value="Bhusawal">Bhusawal</option>
			<option value="Bid">Bid</option>
			<option value="Buldhana">Buldhana</option>
			<option value="Chandrapur">Chandrapur</option>
			<option value="Daulatabad">Daulatabad</option>
			<option value="Dhule">Dhule</option>
			<option value="Jalgaon">Jalgaon</option>
			<option value="Kalyan">Kalyan</option>
			<option value="Karli">Karli</option>
			<option value="Kolhapur">Kolhapur</option>
			<option value="Mahabaleshwar">Mahabaleshwar</option>
			<option value="Malegaon">Malegaon</option>
			<option value="Matheran">Matheran</option>
			<option value="Mumbai">Mumbai</option>
			<option value="Nagpur">Nagpur</option>
			<option value="Nanded">Nanded</option>
			<option value="Nashik">Nashik</option>
			<option value="Osmanabad">Osmanabad</option>
			<option value="Pandharpur">Pandharpur</option>
			<option value="Parbhani">Parbhani</option>
			<option value="Pune">Pune</option>
			<option value="Ratnagiri">Ratnagiri</option>
		</select><br>
				</div>
				
				<div class="form-group">
				<label for="state">State </label><select name="state" id="state" style="width: 400px" required>
			<option value="Andhra Pradesh">Andhra Pradesh</option>
			<option value="Arunachal Pradesh">Arunachal Pradesh</option>
			<option value="Assam">Assam</option>
			<option value="Bihar">Bihar</option>
			<option value="Chhattisgarh">Chhattisgarh</option>
			<option value="Goa">Goa</option>
			<option value="Gujrat">Gujrat</option>
			<option value="Haryana">Haryana</option>
			<option value="Himachal Pradesh">Himachal Pradesh</option>
			<option value="Jharkhand">Jharkhand</option>
			<option value="Karnataka">Karnataka</option>
			<option value="Kerala">Kerala</option>
			<option value="Madhya Pradesh">Madhya Pradesh</option>
			<option value="Maharashtra">Maharashtra</option>
			<option value="Manipur">Manipur</option>
			<option value="Meghalaya">Meghalaya</option>
			<option value="Mizoram">Mizoram</option>
			<option value="Nagaland">Nagaland</option>
		</select><br> 
				</div>
			
				<div class="form-group">
				<label for="email">Email </label>
					<input autocomplete="off" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="please enter valid Email" type="email" placeholder="Email ID" name="email" class="form-control"  id="email" onkeydown="return nospace(event)"><br>
				</div>
				
				<div class="form-group">
				<label >Gender</label>
				
				<div>
				<label for="male" class="radio-inline"><input type="radio" name="gender" value="Male" id="male"> Male</label><br>
				<label for="female" class="radio-inline"><input type="radio" name="gender" value="Female" id="female"> Female</label><br>
				<label for="others" class="radio-inline"><input type="radio" name="gender" value="Others" id="others"> Others</label><br>
				</div>
				</div>
				
				<div class="form-group">
				<label for="dob">Date of Birth(dd/mm/yyyy) </label>
					<input autocomplete="off" required type="text" placeholder="dd/mm/yyyy" name="datepicker" class="form-control"  id="datepicker" onkeydown="return nospace(event)" min="1930-01-01" max="2020-01-01"><br>
				</div>
				
				<div class="form-group">
				<label for="contact">Contact Number</label>
					<input autocomplete="off" required pattern="^[7-9]{1}[0-9]{9}" title="please enter 10 digits only" type="text" placeholder="+91" name="contact" class="form-control" id="contact"><br>
				</div>
				
				<div class="form-group">
				<label >Account Type</label>
				<div>
				<label for="saving" class="radio-inline"><input type="radio" name="accType" value="Saving" id="saving">Saving</label><br>
				<label for="current" class="radio-inline"><input type="radio" name="accType" value="Current" id="current">  Current</label><br>
				<label for="Rdeposit" class="radio-inline"><input type="radio" name="accType" value="Recurring Deposit" id="Rdeposit">  Recurring Deposit</label><br>
				<label for="Fdeposit" class="radio-inline"><input type="radio" name="accType" value="Fix Deposit" id="Fdeposit">  Fix Deposit</label><br>
				</div>
				</div>
				<input type="submit" class="btn btn-primary" value="Create Account" id="submit1" onclick="success()">
				
				
				<input type="submit" class="btn btn-primary" value="Cancel" id="submit2" onclick="location.href='Home.jsp'">
				</form>
				</div>
				<div class="panel-footer text-right">
				<small>&copy; ABC Bank</small>
				</div>
			</div>

		</div>
	</div>
	
</body>
</html>