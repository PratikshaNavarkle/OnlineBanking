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
	public List<AccountDetails> getAllAccountDetails();

	//delete record
	public int deleteAccount(long accNo);

	//search
	public String searchEmail(long accNo);
	public String searchPassword(long accNo);

	//update 
	public AccountDetails updateAccount(AccountDetails acc); 

}
