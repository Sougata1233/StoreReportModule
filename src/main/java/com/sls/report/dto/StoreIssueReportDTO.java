package com.sls.report.dto;

public class StoreIssueReportDTO {

	private String itemCode;
	private String description;
	private String unit;
	private float quantity;
	private float ammount;
	private float av;
	private float conLastMn;
	
	
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
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getAmmount() {
		return ammount;
	}
	public void setAmmount(float ammount) {
		this.ammount = ammount;
	}
	public float getAv() {
		return av;
	}
	public void setAv(float av) {
		this.av = av;
	}
	public float getConLastMn() {
		return conLastMn;
	}
	public void setConLastMn(float conLastMn) {
		this.conLastMn = conLastMn;
	}
	
	
}
