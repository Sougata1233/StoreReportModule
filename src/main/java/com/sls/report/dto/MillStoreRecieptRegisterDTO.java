package com.sls.report.dto;

import java.sql.Date;

public class MillStoreRecieptRegisterDTO {
	
	private long srNum;
	private Date srDate;
	private long challanNo;
	private Date challanDate;
	private String partyName;
	private long Amount;
	public long getSrNum() {
		return srNum;
	}
	public void setSrNum(long srNum) {
		this.srNum = srNum;
	}
	public Date getSrDate() {
		return srDate;
	}
	public void setSrDate(Date srDate) {
		this.srDate = srDate;
	}
	public long getChallanNo() {
		return challanNo;
	}
	public void setChallanNo(long challanNo) {
		this.challanNo = challanNo;
	}
	public Date getChallanDate() {
		return challanDate;
	}
	public void setChallanDate(Date challanDate) {
		this.challanDate = challanDate;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public long getAmount() {
		return Amount;
	}
	public void setAmount(long amount) {
		Amount = amount;
	}
	
	
	

}
