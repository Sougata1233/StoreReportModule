package com.sls.report.dto;

import java.sql.Date;

public class NegativeStoresLedgerReportDTO {

	private String itemCode;
	private String description;
	private String typeDNo;
	private float unitQnt;
	private float unitAmnt;
	private float issueQnt;
	private float issueAmnt;
	private float openningStock;
	private float closingStock;
	private float amount;
	private Date docDate;
	private String department;
	private String supplier;
	
	
	
	public Date getDocDate() {
		return docDate;
	}
	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
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
	public String getTypeDNo() {
		return typeDNo;
	}
	public void setTypeDNo(String typeDNo) {
		this.typeDNo = typeDNo;
	}
	public float getUnitQnt() {
		return unitQnt;
	}
	public void setUnitQnt(float unitQnt) {
		this.unitQnt = unitQnt;
	}
	public float getUnitAmnt() {
		return unitAmnt;
	}
	public void setUnitAmnt(float unitAmnt) {
		this.unitAmnt = unitAmnt;
	}
	public float getIssueQnt() {
		return issueQnt;
	}
	public void setIssueQnt(float issueQnt) {
		this.issueQnt = issueQnt;
	}
	public float getIssueAmnt() {
		return issueAmnt;
	}
	public void setIssueAmnt(float issueAmnt) {
		this.issueAmnt = issueAmnt;
	}
	public float getOpenningStock() {
		return openningStock;
	}
	public void setOpenningStock(float openningStock) {
		this.openningStock = openningStock;
	}
	public float getClosingStock() {
		return closingStock;
	}
	public void setClosingStock(float closingStock) {
		this.closingStock = closingStock;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
}
