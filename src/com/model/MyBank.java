package com.model;

public class MyBank 
{
	private String bankName;
	private String IFSC;
	public MyBank() 
	{
		bankName="ABC BANK";
		IFSC="ABC1099200";
	}
	public String getBankName() {
		return bankName;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	
	
}
