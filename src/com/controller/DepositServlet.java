package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AccountDetailsDao;
import com.dao.AccountHistoryDao;
import com.dao.PersonalDetailsDao;
import com.model.AccountHistory;
import com.model.MyBank;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DepositServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		//get data from jsp page
		String accNum=request.getParameter("accNo");
		String amt=request.getParameter("amount");
		
		//conver into number
		long accNo=Long.parseLong(accNum);
		double amount=Double.parseDouble(amt);
		int i=0;
		double newAccBal;
		try
		{
			AccountDetailsDao add=new AccountDetailsDao();
			double accBalance=add.getAccountBalance(accNo);
			
			if(amount<0)
				try{
				throw new NegativeAmountException();
				}
			catch (NegativeAmountException e) {
				System.out.println(e);
			}
			
			else
			{
				newAccBal=accBalance+amount;
				System.out.println("Remaining Account balance is\t"+newAccBal);
				i=add.updateAccountBalance(accNo, newAccBal);
				if(i>0)
				{
					System.out.println("Account Details Updated");
					//insert into Transaction table
					PersonalDetailsDao p=new PersonalDetailsDao();
					String fName=p.searchPersonal(accNo);
					String lName=p.searchName(accNo);
					MyBank m=new MyBank();
					AccountHistory ah=new AccountHistory(accNo, accNo, fName + lName, m, "Credited", amount, accBalance, newAccBal, "Successful");
					AccountHistoryDao ahd=new AccountHistoryDao();
					i=ahd.addHistory(ah);
					if(i>0)
					{
						System.out.println("History inserted from deposiit");
					}
					else
					{
						System.out.println("History insertion failed from deposit");
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
			System.out.println("In withdraw servlet");
		}
		response.sendRedirect("MyAccount.jsp");
	
	}

}
