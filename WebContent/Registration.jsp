<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registration</title>
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
				<form action="#">
				
				<div class="form-group">
				
				<label for="name">Full Name</label>
					<input pattern="^[A-Za-z]{1,50}" title="please enter alphabets only. e.g. John " type="text" placeholder="Enter Full Name" name="fullName" class="form-control"  id="name"><br>
				</div>
			
				<div class="form-group">
				<label for="address">Enter Your Address</label>
					<input pattern="^[#.@0-9a-zA-Z\s,-]+$" title="please use #,.,@,- symbols only" type="text" placeholder="Enter Residential Address" name="address" class="form-control" id="address"><br>
				</div>
				
				<div class="form-group">
				<label for="pin">Enter Pin Code</label>
					<input pattern="^[0-9]{6}" title="please enter 6 digits only" type="text" placeholder="Pin Code" name="pin" class="form-control" id="pin"><br>
				</div>
			
				<div class="form-group">
				<label for="city">City </label> <select name="city" id="city" style="width: 400px">
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
				<label for="state">State </label><select name="state" id="state" style="width: 400px">
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
					<input pattern="[a-z0-9._%+_]+@[a-z0-9.-]+\.[a-z]{2,}$" title="please enter valid Email" type="email" placeholder="Email ID" name="email" class="form-control"  id="email"><br>
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
				<input type="submit" class="btn btn-primary" value="Create Account" id="submit1">
				<input type="button" class="btn btn-primary" value="Cancel" id="submit2">
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