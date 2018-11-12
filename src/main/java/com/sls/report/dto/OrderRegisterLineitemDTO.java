package com.sls.report.dto;

public class OrderRegisterLineitemDTO {

	private String itemCode;
	private String description;
	private String unit;
	private float qty;
	private long stax;
	private long ammendNo;
	private long srl;
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
	public float getQty() {
		return qty;
	}
	public void setQty(float qty) {
		this.qty = qty;
	}
	public long getStax() {
		return stax;
	}
	public void setStax(long stax) {
		this.stax = stax;
	}
	public long getAmmendNo() {
		return ammendNo;
	}
	public void setAmmendNo(long ammendNo) {
		this.ammendNo = ammendNo;
	}
	public long getSrl() {
		return srl;
	}
	public void setSrl(long srl) {
		this.srl = srl;
	}
	
	
	
	
}
