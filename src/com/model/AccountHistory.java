package com.model;

import java.util.Date;

public class AccountHistory 
{
	private long accNo;
	private long recipientAccNo;
	private String receipientName;
	private MyBank mb;
	private String trType;
//	private Date trDateTime;
	private double trAmount;
	private double accBalBefore; 
	private double accBalAfter;
	private String trStatus;
	
	public AccountHistory(long accNo, long recipientAccNo, String receipientName, MyBank mb, String trType, double trAmount, double accBalBefore, double accBalAfter, String trStatus) {
		super();
		this.accNo = accNo;
		this.recipientAccNo = recipientAccNo;
		this.receipientName = receipientName;
		this.mb = mb;
		this.trType = trType;
		//this.trDateTime = trDateTime;
		this.trAmount = trAmount;
		this.accBalBefore = accBalBefore;
		this.accBalAfter = accBalAfter;
		this.trStatus = trStatus;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public long getRecipientAccNo() {
		return recipientAccNo;
	}

	public void setRecipientAccNo(long recipientAccNo) {
		this.recipientAccNo = recipientAccNo;
	}

	public String getReceipientName() {
		return receipientName;
	}

	public void setReceipientName(String receipientName) {
		this.receipientName = receipientName;
	}

	public MyBank getMb() {
		return mb;
	}

	public void setMb(MyBank mb) {
		this.mb = mb;
	}

	public String getTrType() {
		return trType;
	}

	public void setTrType(String trType) {
		this.trType = trType;
	}

/*	public Date getTrDateTime() {
		return trDateTime;
	}

	public void setTrDateTime(Date trDateTime) {
		this.trDateTime = trDateTime;
	}
*/
	public double getTrAmount() {
		return trAmount;
	}

	public void setTrAmount(double trAmount) {
		this.trAmount = trAmount;
	}

	public double getAccBalBefore() {
		return accBalBefore;
	}

	public void setAccBalBefore(double accBalBefore) {
		this.accBalBefore = accBalBefore;
	}

	public double getAccBalAfter() {
		return accBalAfter;
	}

	public void setAccBalAfter(double accBalAfter) {
		this.accBalAfter = accBalAfter;
	}

	public String getTrStatus() {
		return trStatus;
	}

	public void setTrStatus(String trStatus) {
		this.trStatus = trStatus;
	}

	@Override
	public String toString() {
		return "AccountHistory [accNo=" + accNo + ", recipientAccNo=" + recipientAccNo + ", receipientName="
				+ receipientName + ", mb=" + mb + ", trType=" + trType + ", trAmount="
				+ trAmount + ", accBalBefore=" + accBalBefore + ", accBalAfter=" + accBalAfter + ", trStatus="
				+ trStatus + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
	
}