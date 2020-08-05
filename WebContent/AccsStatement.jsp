<%@page import="com.dao.AccountHistoryDao"%>
<%@page import="com.dao.AccountDetailsDao"%>
<%@page import="com.model.AccountHistory"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.PrintWriter"%>
<%@ page import="java.io.*"%>  
<%@ page import="javax.servlet.*" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.io.*,java.util.*,java.sql.Timestamp,java.sql.*"%>  
  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Statement</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css">
<link rel="stylesheet" href="CSS/AccsStatement.css">
</head>
<body>
<%
String s=(String)session.getAttribute("accNo");
//System.out.println(s);
long accNo=Long.parseLong(s);
//System.out.println("Account number\t"+ID);

%>

	<!--header-area-start---->

	<header>
		<label for=""> </label>
		<div class="left_area">

			<h2>Account Statement</h2>
		</div>

		<div class="right_area">

			<a href="Home.jsp" class="logout_btn">Logout</a>
		</div>
	</header>

	<div class="sidebar">

		<center>

			<img
				src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAA2FBMVEUilNIdd6v///8beakXdazz+/Q6iacjk9P8//////whlc8ljMQZeqj///glktQmk80qksj//P/2//wagLT///MAbqIAcp/t8/LS5OzB4euiyd1jnLsngKMknNJfqtSWyOHg8fALksEshbGz0twckt7//uzs9fpos9cAbae12ut4t9OLssK/1d3X8vbM6Ono7viGrMUEdbYAitBFl8dXkrqGw+q51Ok4ptek0d/C5fefxuNup8UoosO03+fa4O54o8V1rbwnmcCFwtVhudNJi7whfpexx+SDtd2+rkZiAAAK+ElEQVR4nO2dC3ObuBaAAUEkgSUQBj/jdxLnnTRJm/Td7u69+///0Uo4bvOwHSTAkjt8Mzuznek4/nKOdI4kRC2rpqampqampqampqampqampqampqampqampqampqampqampqampuYFEFoWpeL/fN+3rDC0oPgj1f29SiMKfa50Ewzu74fD4SCkB9Dyo/DPEYQURsNRd4zJYeI4DnGOOg/zAT2gA93frASgFULqn371CCeOY4QF4g9eZ3QPqRVmGbzD8Hy877WdVWAcfx0GIlN3OVspHZx4JF5pyHCCycchtSK6w1EMRh7CSbLS0HEQQofkJKK+7q+pSGQFwwvCsIPwaj+HEYwQOToVQzHS/XUViOh7L0Zrwvd0PCYng0l0oPvrqnBCWA5BxKfXTkR3L4bw4DJJcgg6mCCHXNzuWgz9cDDOYbeEJe176u9UHKHfWT29rCbxkvbtwU4JTj4cyhgy5nkXkbUrZRH6VvhJVIn8xIww8pEX/p3pbuZ5ppjnYOKM6K5EkU6O1nUxmwxJPNyZut87lBbkdREnF7q/eB54H30wxLHMIPxN8h7uwECElH4kazrRt8Bt3d8+DyEPIcbyM42AJZ/MH4hwQs+JQxQN43agW+Bt6L2nZCcgiHwOTK8Y1PpElA0dlHTSwA91S2yETq4KGBLsADcw3PBebRpdwGeoa2DzsWjwvgYdEVZA0XHOWzYwerqhXcVKsaTNDY1WDMZo9d5hXsjUto2O4gAXzFLyGQChaOzu25CQIlMNNzxLbZOjCOfEK2jYa2WGIoomAk9JUswQn2QxtLOiYSBwRNacUuSFdY6BvSD0DSyLtLAh/mUIgIlzTXFD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"
				class="prof_img" alt="">

			<h4>User</h4>
		</center>
		<a href="Dashboard.jsp"><i class="fa fa-home"></i><span>Home</span></a>
		<a href="MyAccount.jsp"><i class="fa fa-id-card"></i><span>My
				Account</span></a> <a href="FAQ.jsp"><i class="fa fa-info-circle"></i><span>FAQs</span></a>
		<a href="Settings"><i class="fa fa-cog"></i><span>Account
				Settings</span></a> <a href="AccsStatement.jsp"><i class="fa fa-history"></i><span>Account
				Statement</span></a><a href="FundTransfer.jsp"><i class="fa fa-history"></i><span>Fund
				Transfer</span></a>
	</div>
<jsp:useBean id="dlist" class="java.util.ArrayList"/>

	<sql:setDataSource var="db" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:XE" user="system"
		password="neha123" />
		
		<sql:query dataSource="${db}" var="rs">  
SELECT to_char(trDateTime,'mm-dd-yyyy hh24:mi:ss') as newDate from Account_Statements where accno=<%=accNo %>
</sql:query>  
 <c:forEach var="table" items="${rs.rows}">
 <c:set var="d" value="${dlist.add(table.newDate)}"/>
</c:forEach>  
<c:out value="${dlist[1]}"/>

	<sql:query dataSource="${db}" var="rs">  
SELECT * from Account_Statements where accno=<%=accNo %>
</sql:query>

	<table border="2" width="100%" id='profile'>
		<tr>
			<th>Account Number</th>
			<th>Recipient Account Number</th>
			<th>Recipient Name</th>
			<th>Bank Name</th>
			<th>IFSC Code</th>
			<th>Transaction Type</th>
			<th>Transaction Date</th>
			<th>Transaction Amount</th>
			<th>Balance Before</th>
			<th>Balance After</th>
			<th>Transaction Status</th>
		</tr>
		<c:set var="i" value="0"/>
		<c:forEach var="table" items="${rs.rows}">
			<tr>
				<td><c:out value="${table.accno }" /></td>
				<td><c:out value="${table.recipientAccNo }" /></td>
				<td><c:out value="${table.recipientAccNo }" /></td>
				<td><c:out value="${table.bankName }" /></td>
				<td><c:out value="${table.ifscCode  }" /></td>
				<td><c:out value="${table.trType  }" /></td>
				<td><c:out value="${dlist[i]}"/></td>
				<td><c:out value="${table.trAmount  }" /></td>
				<td><c:out value="${table.accBalBefore  }" /></td>
				<td><c:out value="${table.accBalAfter  }" /></td>
				<td><c:out value="${table.trStatus  }" /></td>
				<c:set var="i" value="${i+1}"/>
			</tr>
		</c:forEach>
	</table>

</body>
</html>