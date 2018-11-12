package com.sls.report.dto;

import java.util.Date;

public class StockSlowMovementReportDTO {

	private String itemCode;
	private String itemDesc;
	private String uom;
	private float qnt;
	private float value;
	private Date issueDate;
	private Date receivedDate;
	private long days;
	
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public float getQnt() {
		return qnt;
	}
	public void setQnt(float qnt) {
		this.qnt = qnt;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public long getDays() {
		return days;
	}
	public void setDays(long time) {
		this.days = time;
	}
	
	
	
}
