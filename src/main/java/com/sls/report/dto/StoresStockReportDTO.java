package com.sls.report.dto;

import java.sql.Date;

public class StoresStockReportDTO {

	private String itemCode;
	private String itemDesc;
	private String unit;
	private float stockQnt;
	private float indentQnt;
	private double maxQnt;
	private float approvedQnt;
	private float reqQnt;
	private String lastOrderNo;
	private Date date;
	private String supplier;
	private float rate;
	private float discount;
	private float mtdCons;
	private String grp;
	
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public float getStockQnt() {
		return stockQnt;
	}
	public void setStockQnt(float stockQnt) {
		this.stockQnt = stockQnt;
	}
	public float getIndentQnt() {
		return indentQnt;
	}
	public void setIndentQnt(float indentQnt) {
		this.indentQnt = indentQnt;
	}
	public double getMaxQnt() {
		return maxQnt;
	}
	public void setMaxQnt(double maxQnt) {
		this.maxQnt = maxQnt;
	}
	public float getApprovedQnt() {
		return approvedQnt;
	}
	public void setApprovedQnt(float approvedQnt) {
		this.approvedQnt = approvedQnt;
	}
	public float getReqQnt() {
		return reqQnt;
	}
	public void setReqQnt(float reqQnt) {
		this.reqQnt = reqQnt;
	}
	public String getLastOrderNo() {
		return lastOrderNo;
	}
	public void setLastOrderNo(String lastOrderNo) {
		this.lastOrderNo = lastOrderNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getMtdCons() {
		return mtdCons;
	}
	public void setMtdCons(float mtdCons) {
		this.mtdCons = mtdCons;
	}
	public String getGrp() {
		return grp;
	}
	public void setGrp(String grp) {
		this.grp = grp;
	}
	
	
	
	
}
