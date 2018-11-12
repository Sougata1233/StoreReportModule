package com.sls.report.dto;

public class POCancelLineitemReportDTO {

	private long slNo;
	private String itemCode;
	private String description;
	private String unit;
	private float cancelQty;
	private float poQty;
	private float rate;
	private float disc;
	private float cst;
	private float excise;
	
	
	public long getSlNo() {
		return slNo;
	}
	public void setSlNo(long slNo) {
		this.slNo = slNo;
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
	public float getCancelQty() {
		return cancelQty;
	}
	public void setCancelQty(float cancelQty) {
		this.cancelQty = cancelQty;
	}
	public float getPoQty() {
		return poQty;
	}
	public void setPoQty(float poQty) {
		this.poQty = poQty;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getDisc() {
		return disc;
	}
	public void setDisc(float disc) {
		this.disc = disc;
	}
	public float getCst() {
		return cst;
	}
	public void setCst(float cst) {
		this.cst = cst;
	}
	public float getExcise() {
		return excise;
	}
	public void setExcise(float excise) {
		this.excise = excise;
	}
	
	
}
