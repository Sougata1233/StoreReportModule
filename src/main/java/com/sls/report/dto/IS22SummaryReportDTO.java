package com.sls.report.dto;

public class IS22SummaryReportDTO {

	private String itemCode;
	private String description;
	private String unit;
	private float totqnt;
	private float avgqnt;
	private float totvalue;
	private float avgvalue;
	
	
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
	public float getTotqnt() {
		return totqnt;
	}
	public void setTotqnt(float totqnt) {
		this.totqnt = totqnt;
	}
	public float getAvgqnt() {
		return avgqnt;
	}
	public void setAvgqnt(float avgqnt) {
		this.avgqnt = avgqnt;
	}
	public float getTotvalue() {
		return totvalue;
	}
	public void setTotvalue(float totvalue) {
		this.totvalue = totvalue;
	}
	public float getAvgvalue() {
		return avgvalue;
	}
	public void setAvgvalue(float avgvalue) {
		this.avgvalue = avgvalue;
	}
	
	
	
	
}
