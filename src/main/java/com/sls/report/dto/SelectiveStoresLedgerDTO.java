package com.sls.report.dto;

import java.util.Date;

public class SelectiveStoresLedgerDTO {

	private String itemCode;
	private String type;
	private Date date;
	private String department;
	private String description;
	private String supplier;
	private float unitQnt;
	private float unitAmt;
	private float issueQnt;
	private float issueAmt;
	private float openningStockQnt;
	private float closingStockQnt;
	private float openningStockAmt;
	private float  closingStockAmt;
	private Date issueDate;
	private Date recDate;
	
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public float getUnitQnt() {
		return unitQnt;
	}
	public void setUnitQnt(float unitQnt) {
		this.unitQnt = unitQnt;
	}
	public float getUnitAmt() {
		return unitAmt;
	}
	public void setUnitAmt(float unitAmt) {
		this.unitAmt = unitAmt;
	}
	public float getIssueQnt() {
		return issueQnt;
	}
	public void setIssueQnt(float issueQnt) {
		this.issueQnt = issueQnt;
	}
	public float getIssueAmt() {
		return issueAmt;
	}
	public void setIssueAmt(float issueAmt) {
		this.issueAmt = issueAmt;
	}
	public float getOpenningStockQnt() {
		return openningStockQnt;
	}
	public void setOpenningStockQnt(float openningStockQnt) {
		this.openningStockQnt = openningStockQnt;
	}
	public float getClosingStockQnt() {
		return closingStockQnt;
	}
	public void setClosingStockQnt(float closingStockQnt) {
		this.closingStockQnt = closingStockQnt;
	}
	public float getOpenningStockAmt() {
		return openningStockAmt;
	}
	public void setOpenningStockAmt(float openningStockAmt) {
		this.openningStockAmt = openningStockAmt;
	}
	public float getClosingStockAmt() {
		return closingStockAmt;
	}
	public void setClosingStockAmt(float closingStockAmt) {
		this.closingStockAmt = closingStockAmt;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getRecDate() {
		return recDate;
	}
	public void setRecDate(Date recDate) {
		this.recDate = recDate;
	}
	
}
