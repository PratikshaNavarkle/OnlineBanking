package com.controller;

import java.io.IOException;
import java.lang.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AccountDetailsDao;
import com.dao.AccountHistoryDao;
import com.dao.BeneficiaryDao;
import com.dao.PersonalDetailsDao;
import com.model.AccountHistory;
import com.model.MyBank;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
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
		String ano=request.getParameter("ano");
		String type=request.getParameter("type");
		String payee=request.getParameter("payee");
		String amount=request.getParameter("amount");
		
		System.out.println(ano+type+payee+amount);
		if(type.equals("neft"))
		{
			System.out.println("NEFT TRANSFER Delay Using Thread : ");
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long accNo=Long.parseLong(ano);
		long benfAccNo=Long.parseLong(payee);
		double amt=Double.parseDouble(amount);
		int i=0;
		double newAccBal,newBenfAccBal;
		try
		{
			AccountDetailsDao add=new AccountDetailsDao();
			double accBal=add.getAccountBalance(accNo);
			double benfAccBal=add.getAccountBalance(benfAccNo);
			
			if(amt<0)
				try{
				throw new NegativeAmountException();
				}
			catch (NegativeAmountException e) {
				System.out.println(e);
			}
			
			else
			{
				newAccBal=accBal-amt;
				newBenfAccBal=benfAccBal+amt;
				System.out.println("Remaining Account balance is\t"+newAccBal);
				i=add.updateAccountBalance(accNo, newAccBal);
				if(i>0)
				{
					System.out.println("User Account Details Updated");
					//insert into Transaction table
					PersonalDetailsDao p=new PersonalDetailsDao();
					BeneficiaryDao bd=new BeneficiaryDao();
					String fName=p.searchPersonal(benfAccNo);
					String lName=p.searchName(benfAccNo);
					MyBank m=bd.getBenfBank(benfAccNo);
					AccountHistory ah=new AccountHistory(accNo,benfAccNo,fName+lName,m,"Credited",amt,accBal,newAccBal,"Successful");
					AccountHistoryDao ahd=new AccountHistoryDao();
					i=ahd.addHistory(ah);
					if(i>0)
					{
						System.out.println("History inserted in user transfer");
					}
					else
					{
						System.out.println("History insertion failed from user transfer");
					}
					
				}
				else
				{
					System.out.println("Account Details Failed");
				}
				i=add.updateAccountBalance(benfAccNo, newBenfAccBal);
				if(i>0)
				{
					System.out.println("recipient Account Details Updated");
					//insert into Transaction table
					PersonalDetailsDao p=new PersonalDetailsDao();
					String fName=p.searchPersonal(accNo);
					String lName=p.searchName(accNo);
					MyBank m=new MyBank();
					AccountHistory ah=new AccountHistory(benfAccNo,accNo,fName+lName,m,"Debited",amt,benfAccBal,newBenfAccBal,"Successful");
					AccountHistoryDao ahd=new AccountHistoryDao();
					i=ahd.addHistory(ah);
					if(i>0)
					{
						System.out.println("History inserted in recipient transfer");
					}
					else
					{
						System.out.println("History insertion failed from recipient transfer");
					}
					
				}
				else
				{
					System.out.println("Account Details Failed");
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println("In transfer servlet");
		}
		session.setAttribute("accNo", ano);
		response.sendRedirect("MyAccount.jsp");
	}

}
