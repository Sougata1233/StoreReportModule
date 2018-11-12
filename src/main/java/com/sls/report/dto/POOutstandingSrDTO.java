package com.sls.report.dto;

import java.sql.Date;

public class POOutstandingSrDTO {

	private long srNO;
	private Date srDate;
	private float srQty;
	private float balanceQty;
	
	
	
	public float getBalanceQty() {
		return balanceQty;
	}
	public void setBalanceQty(float balanceQty) {
		this.balanceQty = balanceQty;
	}
	public long getSrNO() {
		return srNO;
	}
	public void setSrNO(long srNO) {
		this.srNO = srNO;
	}
	public Date getSrDate() {
		return srDate;
	}
	public void setSrDate(Date srDate) {
		this.srDate = srDate;
	}
	public float getSrQty() {
		return srQty;
	}
	public void setSrQty(float srQty) {
		this.srQty = srQty;
	}
	
	
	
}
