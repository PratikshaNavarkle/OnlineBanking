package com.model;

public class DocumentDetails 
{
	//private long accNo;
	private String panNo;
	private long adhaarNo;
	
	public DocumentDetails(String panNo, long adhaarNo) {
		super();
		//this.accNo = accNo;
		this.panNo = panNo;
		this.adhaarNo = adhaarNo;
	}
	
/*	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

*/	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public long getAdhaarNo() {
		return adhaarNo;
	}

	public void setAdhaarNo(long adhaarNo) {
		this.adhaarNo = adhaarNo;
	}

}
