package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.Database;
import com.model.Register;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("In Register Servlet");
		HttpSession session= request.getSession();
		PrintWriter pw=response.getWriter();
		
		//read data from user
		String firstName=request.getParameter("firstName");
		String middleName=request.getParameter("middleName");
		String lastName=request.getParameter("lastName");
		String address=request.getParameter("address");
		String pinCode = request.getParameter("pin");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("datepicker");
		String contactNo=request.getParameter("contact");
		String accountType=request.getParameter("accType");
		
		//convert into respective data type
		int postalCode = Integer.parseInt(pinCode);
		long contact= Long.parseLong(contactNo);
		
		java.util.Date da=null;
	    java.text.DateFormat format = new java.text.SimpleDateFormat("dd/MM/yyyy");
	    try {
	        //java.util.Date d = df.parse(Date);
	    	da = format.parse(dob);
	    } 
	    catch (ParseException ex) {
	        //Logger.getLogger(ReserveServlet.class.getName()).log(Level.SEVERE, null, ex);
	        System.out.println(ex);
	    }
		
		int i=0;
		Register r=new Register(firstName, middleName, lastName, address, postalCode, city, state, email, gender, contact, accountType);
			
			try{
				Class.forName("oracle.jdbc.OracleDriver");
				//step2 connection to DB
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Pratiksha:1521:XE","SYSTEM","Pr@tiksha");
			PreparedStatement ps;
			ps=con.prepareStatement("insert into Register values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, r.getFirstName());
			ps.setString(2, r.getMiddleName());
			ps.setString(3, r.getLastName());
			ps.setString(4, r.getAddress());
			ps.setInt(5, r.getPin());
			ps.setString(6, r.getCity());
			ps.setString(7, r.getState());
			ps.setString(8, r.getEmail());
			ps.setString(9, r.getGender());
			da= new java.sql.Date(da.getTime());
	        ps.setDate(10, (java.sql.Date) da);
			ps.setLong(11, r.getContact());
			ps.setString(12, r.getAccType());
			

			i=ps.executeUpdate();
			con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			

			if(i>0)
			{
				System.out.println("Regisration is Successful....!!");
				response.sendRedirect("Home.jsp");
			}
			
		}
	
	}


