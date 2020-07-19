<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fund Transfer</title>
</head>
<%
String ano=session.getAttribute("accNo").toString();
System.out.println("In Fund Transfer Account number\t"+ano);
%>
<body>
<label for="BeneficiaryDisplay">Account no :<%=ano%><br>Your Existing Beneficiaries Are : </label><br><br>
<sql:setDataSource var="db" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@Pratiksha:1521:XE" user="SYSTEM"
		password="Pr@tiksha"/>  
  
<sql:query dataSource="${db}" var="rs">  
SELECT * from Beneficiary_Details where accno=<%=ano %>
</sql:query>  
   
<table border="2" width="100%">  
<tr>  
<th>Account No</th>  
<th>Name</th>  
<th>Email</th>  
<th>Bank Name</th>  
<th>IFSC</th>  
<th>Account type</th>
</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><c:out value="${table.benfAccNo}"/></td>  
<td><c:out value="${table.benfName}"/></td>  
<td><c:out value="${table.benfMail}"/></td>  
<td><c:out value="${table.bankName}"/></td> 
<td><c:out value="${table.ifscCode}"/></td>  
<td><c:out value="${table.accType}"/></td>  
</tr>  
</c:forEach>  
</table>  
  
<input type="submit" class="btn btn-primary" value="Add New Payee" id="addPayee" onclick="window.location.href='AddPayee.jsp'">
<br><br>
<label for="transactionType"> Select Transaction Type </label><br><br>
<input type="submit" class="btn btn-primary" value="NEFT" id="validate" onclick="window.location.href='#'">
<input type="submit" class="btn btn-primary" value="RTGS" id="validate" onclick="window.location.href='#'">
<input type="submit" class="btn btn-primary" value="IMPS" id="validate" onclick="window.location.href='#'">
 
</body>
</html>