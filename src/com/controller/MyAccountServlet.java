package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class MyAccountServlet
 */
@WebServlet("/MyAccountServlet")
public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MyAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Hello");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession s=request.getSession();
		//int id=(int) request.getAttribute("ID");
		
		//Database d=new Database();
		//d.getProfile(id);
		try
		{
			long no=7385624397L;
			ResultSet rs = null;
			Class.forName("oracle.jdbc.OracleDriver");
			//step2 connection to DB
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Pratiksha:1521:XE","SYSTEM","Pr@tiksha");
			PreparedStatement ps=con.prepareStatement("select * from Register where contact=?");
			ps.setLong(1, no);
			 rs = ps.executeQuery();
			PrintWriter pw = response.getWriter();
			pw.println(
					"<html><body><table border align='center' id='A'>");
			
			if(rs.next())
			{
				pw.println("<tr><td>First Name:" + rs.getString(1) + "</td></tr><tr><td>Middle Name :" + rs.getString(2) + "</td></tr><tr><td>Last Name" + rs.getString(3)
				+ "</td></tr><tr><td>Address :"+rs.getString(4)+"</td></tr><tr><td>Postal Code:"+rs.getInt(5)+"</td></tr>");
	
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
