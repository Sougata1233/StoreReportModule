package com.sls.report.dto;

public class PurchaseOrderHistoryReportLineitemDTO {

	private String itemCode;
	private String description;
	private String unit;
	private float rate;
	private long srl;
	private float stax;
	
	
	public float getStax() {
		return stax;
	}
	public void setStax(float stax) {
		this.stax = stax;
	}
	public long getSrl() {
		return srl;
	}
	public void setSrl(long srl) {
		this.srl = srl;
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
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	
}
