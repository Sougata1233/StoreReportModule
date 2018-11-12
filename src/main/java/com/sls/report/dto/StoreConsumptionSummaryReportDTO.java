package com.sls.report.dto;

public class StoreConsumptionSummaryReportDTO {

	private String itemCode;
	private String description;
	private String unit;
	private float qauntity;
	private float avgQuantity;
	private float avgValue;
	
	
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
	public float getQauntity() {
		return qauntity;
	}
	public void setQauntity(float qauntity) {
		this.qauntity = qauntity;
	}
	public float getAvgQuantity() {
		return avgQuantity;
	}
	public void setAvgQuantity(float avgQuantity) {
		this.avgQuantity = avgQuantity;
	}
	public float getAvgValue() {
		return avgValue;
	}
	public void setAvgValue(float avgValue) {
		this.avgValue = avgValue;
	}
	
	@Override
	public String toString() {
		return "StoreConsumptionSummaryReportDTO [itemCode=" + itemCode + ", description=" + description + ", unit="
				+ unit + ", qauntity=" + qauntity + ", avgQuantity=" + avgQuantity + ", avgValue=" + avgValue + "]";
	}
	
}
