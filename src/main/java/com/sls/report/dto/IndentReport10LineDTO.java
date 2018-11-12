package com.sls.report.dto;

public class IndentReport10LineDTO {

	private long srlNo;
	private String itemCode;
	private String description;
	private String unit;
	private float indentQnt;
	private String dept;
	private float cancelQnt;
	private float balanceQnt;
	
	
	
	public float getCancelQnt() {
		return cancelQnt;
	}
	public void setCancelQnt(float cancelQnt) {
		this.cancelQnt = cancelQnt;
	}
	public float getBalanceQnt() {
		return balanceQnt;
	}
	public void setBalanceQnt(float balanceQnt) {
		this.balanceQnt = balanceQnt;
	}
	public long getSrlNo() {
		return srlNo;
	}
	public void setSrlNo(long srlNo) {
		this.srlNo = srlNo;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public float getIndentQnt() {
		return indentQnt;
	}
	public void setIndentQnt(float indentQnt) {
		this.indentQnt = indentQnt;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
}
