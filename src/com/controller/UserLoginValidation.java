package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.*;
import com.model.DummyDetails;
import com.security.EncryptionDecryption;

/**
 * Servlet implementation class UserLoginValidation
 */
@WebServlet("/UserLoginValidation")
public class UserLoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginValidation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		String userId=request.getParameter("id");
		String password=request.getParameter("password");

		//convert account number into long
		long ID=Long.parseLong(userId);

		AccountDetailsDao ad=new AccountDetailsDao();
		String passwordA=ad.searchPassword(ID);

		//decrypt password
		EncryptionDecryption ed=new EncryptionDecryption();
		String decryptedPassword=ed.decrypt(passwordA);

		
		//validate password
		if(decryptedPassword.equals(password))
		{

			//check if user uses system generated password again
			UserLoginDao ud=new UserLoginDao();
			String dummyPassword=ud.searchPassword(ID);
			if(password.equals(dummyPassword))
			{
				System.out.println("User cannot use system generated password more than once");
				System.out.println("Please reset your password");
				response.sendRedirect("UserLogin.jsp");
			}
			else if(dummyPassword==null)
			{
				System.out.println("Valid User");
				DummyDetails d=new DummyDetails(ID, password);
				int i=ud.addDummy(d);
				if(i>0)
				{
					System.out.println("Details added in dummy table");
				}
				else
				{
					System.out.println("Insertion in dummy table failed");
				}
				response.sendRedirect("Dashboard.jsp");
			}
			else
			{
				System.out.println("User has already changed password");
				System.out.println("Ready to login");
				response.sendRedirect("Dashboard.jsp");
			}

		session.setAttribute("accNo", userId);
		//session.setAttribute(userId, "accNo");
		System.out.println(userId);
		//getServletConfig().getServletContext().getRequestDispatcher("/Dashboard.jsp").forward(request, response);

	}
		else{
			System.out.println("Wrong Password");
			response.sendRedirect("UserLogin.jsp");
		}
	}
	}


