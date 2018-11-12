package com.sls.report.dto;

public class POCancelNoteReportLineDTO {

	private String itemCode;
	private String description;
	private String unit;
	private String srl;
	private float poQnt;
	private float excise;
	private float disc;
	private float rate;
	
	
	
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
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
	public String getSrl() {
		return srl;
	}
	public void setSrl(String srl) {
		this.srl = srl;
	}
	public float getPoQnt() {
		return poQnt;
	}
	public void setPoQnt(float poQnt) {
		this.poQnt = poQnt;
	}
	public float getExcise() {
		return excise;
	}
	public void setExcise(float excise) {
		this.excise = excise;
	}
	public float getDisc() {
		return disc;
	}
	public void setDisc(float disc) {
		this.disc = disc;
	}
	
	
}
