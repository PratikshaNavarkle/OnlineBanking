<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src='javaS.js'>
</script>
<meta charset="ISO-8859-1">
<title>Fund Transfer</title>
</head>
<%
String ano=session.getAttribute("accNo").toString();
System.out.println("In Fund Transfer Account number\t"+ano);
%>
<body>

<form name="regis" method="post"> 
<input type="hidden" name="ano" value=<%=ano%>>
<label for="transactionType"> Select Transaction Type : </label>
<select id="type" name="type" required>
<option value="neft" selected>NEFT</option>
<option value="rtgs">RTGS</option>
<option value="imps">IMPS</option>
</select><br><br>
<sql:setDataSource var="db" driver="oracle.jdbc.OracleDriver"  
     url="jdbc:oracle:thin:@localhost:1521:XE"  
     user="system"  password="neha123"/>  
  
<sql:query dataSource="${db}" var="rs">  
SELECT * from Beneficiary_Details where accno=<%=ano%> 
</sql:query> 
<lable>Select Payee : </lable>
<select name="payee" id="payee"  required>
<c:forEach var="table" items="${rs.rows}">    
<option value="${table.benfAccNo}"><c:out value="${table.benfAccNo}-->${table.benfName}"/></option>  
</c:forEach>
</select>
<br><br>
<label>Enter Amount :</label>
<input type="text" name="amount" id="amount" onchange="validate()">
<input type="button" name="Transfer" id="Transfer" value="Transfer" onclick="confirmTransfer()" disabled>
</form>
</body>
</html>