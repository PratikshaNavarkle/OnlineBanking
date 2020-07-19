package com.model;

public class BeneficiaryDetails {
	private long accNo;
	private long bAccNo;
	private String acctype;
	private String bemail;
	private String bname;
	private String ifsc;
	private String bankname;
	
	public BeneficiaryDetails(long accNo,long bAccNo, String acctype,String bemail,String bname,String ifsc,String bankname ) {
		super();
		this.setAccNo(accNo);
		this.setbAccNo(bAccNo);
		this.setBname(bname);
		this.setAcctype(acctype);
		this.setBemail(bemail);
		this.setBankname(bankname);
		this.setIfsc(ifsc);
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public long getbAccNo() {
		return bAccNo;
	}

	public void setbAccNo(long bAccNo) {
		this.bAccNo = bAccNo;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public String getBemail() {
		return bemail;
	}

	public void setBemail(String bemail) {
		this.bemail = bemail;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

}
