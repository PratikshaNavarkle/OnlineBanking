package com.model;

public class AccountDetails 
{
	private long accNo;
	private String accType;
	private double accBal;
	private String email;
	private String password;
	
	public AccountDetails(long accNo, String accType, double accBal, String email, String password) {
		super();
		this.accNo = accNo;
		this.accType = accType;
		this.accBal = accBal;
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

	public double getAccBal() {
		return accBal;
	}

	public void setAccBal(double d) {
		this.accBal = d;
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

	@Override
	public String toString() {
		return "AccountDetails [accNo=" + accNo + ", accType=" + accType + ", accBal=" + accBal + ", email=" + email
				+ ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
	
}