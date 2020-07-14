package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AccountDetailsDao;
import com.dao.AddressDetailsDao;
import com.dao.DocumentDetailsDao;
import com.dao.PersonalDetailsDao;
import com.dao.RegisterDao;

/**
 * Servlet implementation class AdminRejectServlet
 */
@WebServlet("/AdminRejectServlet")
public class AdminRejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRejectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw=response.getWriter();
		//get Data from jsp page
		String accNo=request.getParameter("accNo");
		long accNum=Long.parseLong(accNo);
		
		//get email id based on account number
		AccountDetailsDao add=new AccountDetailsDao();
		String ID=add.searchEmail(accNum);
		//System.out.println("From details Mail\t"+ID);
		
		//delete data from all tables because request is rejected
		int i=0;
		RegisterDao rd=new RegisterDao();
		PersonalDetailsDao pd=new PersonalDetailsDao();
		AddressDetailsDao ad=new AddressDetailsDao();
		AccountDetailsDao acc=new AccountDetailsDao();
		DocumentDetailsDao dd=new DocumentDetailsDao();
		try
		{
			//rd.searchRegister(accNum);
			i=pd.deletePersonal(accNum);
			if(i>0)
			{
				System.out.println("Personal Details deleted");
				//response.sendRedirect("Home.jsp");
			}
			else
			{
				System.out.println("Personal details failed");
			}
			
			i=ad.deleteAddress(accNum);
			if(i>0)
			{
				System.out.println("Address Details deleted");
				//response.sendRedirect("Home.jsp");
			}
			else
			{
				System.out.println("Address details failed");
			}
			
			i=acc.deleteAccount(accNum);
			if(i>0)
			{
				System.out.println("Account Details deleted");
				//response.sendRedirect("Home.jsp");
			}
			else
			{
				System.out.println("Account details failed");
			}
			
			i=dd.deleteDocument(accNum);
			if(i>0)
			{
				System.out.println("Document Details deleted");
				//response.sendRedirect("Home.jsp");
			}
			else
			{
				System.out.println("Document details failed");
			}
			i=rd.deleteRegister(accNum);
			if(i>0)
			{
				System.out.println("Register Details deleted");
				//response.sendRedirect("Home.jsp");
			}
			else
			{
				System.out.println("Register details failed");
			}
			
			request.setAttribute("emailID", ID);
			RequestDispatcher rs=request.getRequestDispatcher("EmailApproveServlet");
			rs.forward(request, response);
			
		}
		catch(Exception e)
		{
			System.out.println("In admin Servelt\t"+e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
