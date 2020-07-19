package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BeneficiaryDao;
import com.model.BeneficiaryDetails;

/**
 * Servlet implementation class BeneficiaryServlet
 */
@WebServlet("/BeneficiaryServlet")
public class BeneficiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeneficiaryServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ano=request.getParameter("ano");
		
		String bano=request.getParameter("bano");
		String bname=request.getParameter("bname");
		String bankname=request.getParameter("bankname");
		String bemail=request.getParameter("bemail");
		String ifsc=request.getParameter("ifsc");
		String acctype=request.getParameter("acctype");
		
		System.out.println("values: "+ano+"\n"+bano+"\n"+bname+"\n"+bankname+"\n"+bemail+"\n"+ifsc+"\n"+acctype);
		
		BeneficiaryDetails bd=new BeneficiaryDetails(Long.parseLong(ano),Long.parseLong(bano),acctype,bemail,bname,ifsc,bankname);
		BeneficiaryDao bdao=new BeneficiaryDao();
		int i=bdao.addBeneficiary(bd);
		if(i>0)
		{
			System.out.println("After Adding ");
			response.sendRedirect("FundTransfer.jsp");
		}
		else
		{
			System.out.println("Not added");
			response.sendRedirect("AddPayee.jsp");
		}
	}

}
