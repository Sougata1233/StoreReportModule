package com.sls.report.dto;

public class IssueConsumptionReportForMonthDTO {

	private String itemCode;
	private String description;
	private String unit;
	private float prevQnt;
	private float prevValue;
	private float nextQnt;
	private float nextValue;
	private float diffQnt;
	private float diffValue;
	private float percentage;
	
	
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
	public float getPrevQnt() {
		return prevQnt;
	}
	public void setPrevQnt(float prevQnt) {
		this.prevQnt = prevQnt;
	}
	public float getPrevValue() {
		return prevValue;
	}
	public void setPrevValue(float prevValue) {
		this.prevValue = prevValue;
	}
	public float getNextQnt() {
		return nextQnt;
	}
	public void setNextQnt(float nextQnt) {
		this.nextQnt = nextQnt;
	}
	public float getNextValue() {
		return nextValue;
	}
	public void setNextValue(float nextValue) {
		this.nextValue = nextValue;
	}
	public float getDiffQnt() {
		return diffQnt;
	}
	public void setDiffQnt(float diffQnt) {
		this.diffQnt = diffQnt;
	}
	public float getDiffValue() {
		return diffValue;
	}
	public void setDiffValue(float diffValue) {
		this.diffValue = diffValue;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
	
}
