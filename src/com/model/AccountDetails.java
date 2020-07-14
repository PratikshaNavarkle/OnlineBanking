package com.model;

public class AccountDetails 
{
	private long accNo;
	private String accType;
	private String email;
	private String password;
	
	public AccountDetails(long accNo, String accType, String email, String password) {
		super();
		this.accNo = accNo;
		this.accType = accType;
		this.email = email;
		this.password = password;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
}
