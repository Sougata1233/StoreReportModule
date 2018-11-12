package com.sls.report.dto;

public class OutstandingReportLineItemDTO {

	private String itemCode;
	private String description;
	private String unit;
	private long indentQnt;
	private long orderQnt;
	private long cancelQnt;
	private String dept;
	private long srlNo;
	private long balanceQnt;
	
	
	
	
	public long getBalanceQnt() {
		return balanceQnt;
	}
	public void setBalanceQnt(long balanceQnt) {
		this.balanceQnt = balanceQnt;
	}
	public long getSrlNo() {
		return srlNo;
	}
	public void setSrlNo(long srlNo) {
		this.srlNo = srlNo;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
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
	public long getIndentQnt() {
		return indentQnt;
	}
	public void setIndentQnt(long indentQnt) {
		this.indentQnt = indentQnt;
	}
	public long getOrderQnt() {
		return orderQnt;
	}
	public void setOrderQnt(long orderQnt) {
		this.orderQnt = orderQnt;
	}
	public long getCancelQnt() {
		return cancelQnt;
	}
	public void setCancelQnt(long cancelQnt) {
		this.cancelQnt = cancelQnt;
	}
	
	
	
	
}
