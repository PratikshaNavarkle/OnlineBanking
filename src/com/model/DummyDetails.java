package com.model;

public class DummyDetails 
{
	private long accNo;
	private String password;
	
	public DummyDetails(long accNo, String password) {
		super();
		this.accNo = accNo;
		this.password = password;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
