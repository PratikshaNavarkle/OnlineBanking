<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Payee</title>
</head>
<%
String ano=session.getAttribute("accNo").toString();
System.out.println("In Register Payee Account number\t"+ano);
%>
<body>
<center>
<H2><U>....Enter Beneficiary Details....</U></H2>
<FORM ACTION="BeneficiaryServlet"  NAME="info" method="post"><H3>
<table cellspacing="20" cellpadding="10" border="0">
<input type="hidden" name="ano" value=<%=ano%>>
<tr><td align="right">Account No(12 digit): </td><td ><INPUT required pattern="[0-9]{12}" class=input min="100000000000" title="This account number does not exist" TYPE="text" NAME="bano"></td></tr>
<tr><td align="right">Beneficiary Name:</td><td >  <INPUT required pattern="^[A-Za-z\s]*$" class=input TYPE="text" NAME="bname"></td></tr>
<tr><td align="right">Bank Name:</td><td >  <INPUT required class=input pattern="^[A-Za-z\s]*$" TYPE="text" NAME="bankname"></td></tr>
<tr><td align="right">IFSC Code:</td><td >  <INPUT required class=input TYPE="text" pattern="^[A-Z]{4}[0-9]{7}$" NAME="ifsc"></td></tr>
<tr><td align="right">Account Type:</td><td> 
<div>
		<label for="saving" class="radio-inline"><input required type="radio" name="acctype" value="Saving" id="saving">Saving</label><br>
		<label for="current" class="radio-inline"><input required type="radio" name="acctype" value="Current" id="current">  Current</label><br>
</div></td></tr>
 
<tr><td align="right">EMAIL: </td><td ><INPUT required TYPE="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" NAME="bemail"></td></tr>

</table><INPUT TYPE="SUBMIT" NAME="SUBMIT" class="button">
<INPUT TYPE="RESET" NAME="reset" class="button"></H3></FORM>
</body>
</html>