<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
    <%@page import="java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body>


<div>

<%
try {
	response.setContentType("text/html");
	Class.forName("oracle.jdbc.OracleDriver");
	//Connection to database
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@Pratiksha:1521:XE", "SYSTEM",
			"Pr@tiksha");//thinn is a driver
	PreparedStatement ps = con.prepareStatement("select * from Register");
	ResultSet rs = ps.executeQuery();
	PrintWriter pw = response.getWriter();
	pw.println(
			"<html><body><table border='3' align='left' id='Tab'> <tr> <td>Account Number</td> <td>First Name</td> <td>Middle Name</td> <td>Last Name</td> <td>Email</td> <td>Gender</td> <td>Date of Birth</td> <td>Contact Number</td> <td>City</td> <td>Account Type</td> <td>Aadhar Number</td> <td>PAN Number</td> </tr> ");
	while (rs.next()) {
		pw.println("<tr><td>" + rs.getLong(1)+ "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4)
				+ "</td><td>" +rs.getString(5)+"</td><td>" +rs.getString(6)+"</td><td>" +rs.getDate(7)+"</td><td>" +rs.getLong(8)+"</td><td>" +rs.getString(12)+"</td><td>"+rs.getString(15)+"</td><td>" +rs.getLong(17)+"</td><td>" +rs.getString(18)+"</td> </tr>");
	}
	pw.println(" </table></body></html>");
} catch (Exception e) {
	e.printStackTrace();
}

%>

</div>
	<form action="AdminServlet" method="post">
	
		<input type="text" placeholder="Account Number" name="accNo"><br>
		<input type="submit" value="Approve">
		<input type="submit" value="Reject" onclick="form.action='AdminRejectServlet;'">
	
	</form>
	
	<input type="button" onclick="location.href='Home.jsp'" value="Logout">
</body>
</html>