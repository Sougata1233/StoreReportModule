package com.sls.report.dto;

public class InwardReportDTO {

	private String itemDesc;
	private String itemCode;
	private long challanQnt;
	private String dept;
	private String unit;
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public long getChallanQnt() {
		return challanQnt;
	}
	public void setChallanQnt(long challanQnt) {
		this.challanQnt = challanQnt;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "InwardReportDTO [itemDesc=" + itemDesc + ", itemCode=" + itemCode + ", challanQnt=" + challanQnt
				+ ", dept=" + dept + ", unit=" + unit + "]";
	}
	
	
	
	
}
