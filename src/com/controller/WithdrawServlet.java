package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AccountDetailsDao;
import com.dao.AccountHistoryDao;
import com.dao.AddressDetailsDao;
import com.dao.PersonalDetailsDao;
import com.model.AccountDetails;
import com.model.AccountHistory;
import com.model.MyBank;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public WithdrawServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		try
		{
			//get data from jsp page
			String accNum=request.getParameter("accNo");
			String amt=request.getParameter("amount");

			//convert into number
			long accNo=Long.parseLong(accNum);
			double amount=Double.parseDouble(amt);
			int i=0;
			double newAccBal;
			AccountDetailsDao add=new AccountDetailsDao();
			double accBalance=add.getAccountBalance(accNo);

			if(accBalance<amount)
				try{
				throw new InsufficientBalanceException();
				}
			catch (InsufficientBalanceException e) {
				System.out.println(e);
			}
			else if(amount<0)
				try{
					throw new NegativeAmountException();
				}
			catch(NegativeAmountException e)
			{
				System.out.println(e);
			}

			else
			{
				newAccBal=accBalance-amount;
				System.out.println("Remaining Account balance is\t"+newAccBal);
				i=add.updateAccountBalance(accNo, newAccBal);
				if(i>0)
				{
					System.out.println("Account Details Updated");
					if(newAccBal<500)
					{
						try{
							throw new InsufficientBalanceException();
						}
						catch(InsufficientBalanceException e)
						{
							System.out.println(e);
						}
					}
					//insert into Transaction table
					PersonalDetailsDao p=new PersonalDetailsDao();
					String fName=p.searchPersonal(accNo);
					String lName=p.searchName(accNo);
					MyBank m=new MyBank();
					AccountHistory ah=new AccountHistory(accNo, accNo, fName + lName, m, "Debited", amount, accBalance, newAccBal, "Successful");
					AccountHistoryDao ahd=new AccountHistoryDao();
					i=ahd.addHistory(ah);
					if(i>0)
					{
						System.out.println("History inserted");
					}
					else
					{
						System.out.println("History insertion failed");
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
			System.out.println("In withdraw servlet"+e);
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		response.sendRedirect("MyAccount.jsp");
	}

}
