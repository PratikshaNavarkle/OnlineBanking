package com.service;

import java.util.List;

import com.model.AccountDetails;
import com.model.PersonalDetails;
import com.model.Regsiter;

public interface AccountDetailsInterface 
{
	//insert
	public int addAccount(AccountDetails acc);

	//display
	public List<AccountDetails> getAllAccounts(long acNo);

	//delete record
	public int deleteAccount(long accNo);

	//search
	public String searchEmail(long accNo);
	public String searchPassword(long accNo);
	public double getAccountBalance(long accNo);
	public String searchAccount(long accNo,String email);
	
	//update 
	public int updateAccountBalance(long accNo,double bal);
	public void updatePassword(long accNo,String password);

}
