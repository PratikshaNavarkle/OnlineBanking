package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession s=request.getSession();
		String accno=request.getParameter("uname");
		String password=request.getParameter("pass");
		
		s.setAttribute("username", accno);
		s.setAttribute("pass", password);
		
	//	System.out.println(accno);
		//System.out.println(password);
		
		try
		{
			if(accno.equals("12345") && password.equals("abc"))
			{
				s.setAttribute("ID", accno);
				response.sendRedirect("Dashboard.jsp");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
