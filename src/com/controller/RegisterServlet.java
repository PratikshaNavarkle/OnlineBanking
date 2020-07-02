package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class RegisterServlet
 */
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
		String dob=request.getParameter("dob");
		String contactNo=request.getParameter("contact");
		String accountType=request.getParameter("accType");
		
		//convert into respective data type
		int postalCode = Integer.parseInt(pinCode);
		long contact= Long.parseLong(contactNo);
		/* 
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = formater.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		pw.println(date);
		
		pw.println("first name\t"+firstName);
		pw.println("middle name\t"+middleName);
		pw.println("last name\t"+lastName);
		pw.println("Address\t"+address);
		pw.println("pinCode\t"+postalCode);
		pw.println("city\t"+city);
		pw.println("state\t"+state);
		pw.println("email\t"+email);
		pw.println("Gender\t"+gender);
		pw.println("Date of birth\t"+date);
		pw.println("Contact no\t"+contact);
		pw.println("Account Type\t"+accountType);
		*/
		
		int i=0;
		Register r=new Register(firstName, middleName, lastName, address, postalCode, city, state, email, gender, contact, accountType);
		Database d=new Database();
		try
		{
			System.out.println("Before insert");
			i=d.insertData(r);
			System.out.println("After insert");
			if(i>0)
			{
				System.out.println("Regisration is Successful....!!");
				response.sendRedirect("Home.jsp");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
