package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminValidation
 */
@WebServlet("/AdminValidation")
public class AdminValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminValidation() {
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
		String ID=request.getParameter("id");
		String password=request.getParameter("password");
		
		if(ID.equals("adminABC") && password.equals("admin@123"))
		{
			response.sendRedirect("AdminHome.jsp");
		}
		else if(ID.equals("adminXYZ") && password.equals("admin@789"))
		{
			response.sendRedirect("AdminHome.jsp");
		}
		else
		{
			System.out.println("Invalid login Credentials");
			response.sendRedirect("AdminLogin.jsp");
		}
	}

}
