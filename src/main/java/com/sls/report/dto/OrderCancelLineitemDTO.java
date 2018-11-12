package com.sls.report.dto;

public class OrderCancelLineitemDTO {

	private String itemCode;
	private String description;
	private String unit;
	private float orderQnt;
	private float cancelQnt;
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
	public float getOrderQnt() {
		return orderQnt;
	}
	public void setOrderQnt(float orderQnt) {
		this.orderQnt = orderQnt;
	}
	public float getCancelQnt() {
		return cancelQnt;
	}
	public void setCancelQnt(float cancelQnt) {
		this.cancelQnt = cancelQnt;
	}
	public long getSrl() {
		return srl;
	}
	public void setSrl(long srl) {
		this.srl = srl;
	}
	
	
	
	
}
