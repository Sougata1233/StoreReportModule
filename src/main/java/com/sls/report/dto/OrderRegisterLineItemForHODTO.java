package com.sls.report.dto;

public class OrderRegisterLineItemForHODTO {

	private String itemCode;
	private String itemDesc;
	private String unit;
	private long srlNo;
	private String indentNo;
	private float rate;
	private float qty;
	
	
	
	
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public long getSrlNo() {
		return srlNo;
	}
	public void setSrlNo(long srlNo) {
		this.srlNo = srlNo;
	}
	public String getIndentNo() {
		return indentNo;
	}
	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getQty() {
		return qty;
	}
	public void setQty(float qty) {
		this.qty = qty;
	}
	
	
	
}
