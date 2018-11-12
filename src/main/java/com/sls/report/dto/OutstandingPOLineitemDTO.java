package com.sls.report.dto;

import java.util.List;

public class OutstandingPOLineitemDTO {

	private String itemCode;
	private String description;
	private String unit;
	private float orderQty;
	private float grossRate;
	private long slNo;
	private float cancelQty;
	
	
	private List<POOutstandingSrDTO> supplyDetails;
	
	
	
	public float getCancelQty() {
		return cancelQty;
	}
	public void setCancelQty(float cancelQty) {
		this.cancelQty = cancelQty;
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
	public float getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(float orderQty) {
		this.orderQty = orderQty;
	}
	public float getGrossRate() {
		return grossRate;
	}
	public void setGrossRate(float grossRate) {
		this.grossRate = grossRate;
	}
	public long getSlNo() {
		return slNo;
	}
	public void setSlNo(long slNo) {
		this.slNo = slNo;
	}
	public List<POOutstandingSrDTO> getSupplyDetails() {
		return supplyDetails;
	}
	public void setSupplyDetails(List<POOutstandingSrDTO> supplyDetails) {
		this.supplyDetails = supplyDetails;
	}
	
	
	
	
}
