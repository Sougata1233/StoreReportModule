package com.sls.report.dto;

import java.sql.Date;

public class POOutstandingSummaryLineDTO {

	private String itemCode;
	private String description;
	private String slNO;
	private float orderQnt;
	private float grossRate;
	private String unit;
	private String indentNoFinYear;
	private float supplyQnt;
	private float balanceQnt;
	private Date lastSuppDate;

	public float getSupplyQnt() {
		return supplyQnt;
	}

	public void setSupplyQnt(float supplyQnt) {
		this.supplyQnt = supplyQnt;
	}

	public float getBalanceQnt() {
		return balanceQnt;
	}

	public void setBalanceQnt(float balanceQnt) {
		this.balanceQnt = balanceQnt;
	}

	public Date getLastSuppDate() {
		return lastSuppDate;
	}

	public void setLastSuppDate(Date lastSuppDate) {
		this.lastSuppDate = lastSuppDate;
	}

	public String getSlNO() {
		return slNO;
	}

	public void setSlNO(String slNO) {
		this.slNO = slNO;
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

	public float getOrderQnt() {
		return orderQnt;
	}

	public void setOrderQnt(float orderQnt) {
		this.orderQnt = orderQnt;
	}

	public float getGrossRate() {
		return grossRate;
	}

	public void setGrossRate(float grossRate) {
		this.grossRate = grossRate;
	}

	public String getIndentNoFinYear() {
		return indentNoFinYear;
	}

	public void setIndentNoFinYear(String indentNoFinYear) {
		this.indentNoFinYear = indentNoFinYear;
	}
}
