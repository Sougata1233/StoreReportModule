package com.sls.report.dto;

public class IssueCheckListReportDTO {

	private long lotNo;
	private String issueNo;
	private long machineNo;
	private String dept;
	private String itemCode;
	private String description;
	private String unit;
	private float quantity;
	private float itemValue;
	private float stockQuantity;
	private float approvalQuantity;
	
	
	public long getLotNo() {
		return lotNo;
	}
	public void setLotNo(long lotNo) {
		this.lotNo = lotNo;
	}
	public String getIssueNo() {
		return issueNo;
	}
	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}
	public long getMachineNo() {
		return machineNo;
	}
	public void setMachineNo(long machineNo) {
		this.machineNo = machineNo;
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
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getItemValue() {
		return itemValue;
	}
	public void setItemValue(float itemValue) {
		this.itemValue = itemValue;
	}
	public float getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(float stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public float getApprovalQuantity() {
		return approvalQuantity;
	}
	public void setApprovalQuantity(float approvalQuantity) {
		this.approvalQuantity = approvalQuantity;
	}
	
	
	
	
}
