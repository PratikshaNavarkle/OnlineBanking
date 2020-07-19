package com.service;

import java.util.List;

import com.model.AccountDetails;
import com.model.AccountHistory;
import com.model.PersonalDetails;

public interface AccountHistoryInterface 
{
	//insert
	public int addHistory(AccountHistory a);
	
	//display
		public List<AccountHistory> getAllHistory(long acNo);
}
