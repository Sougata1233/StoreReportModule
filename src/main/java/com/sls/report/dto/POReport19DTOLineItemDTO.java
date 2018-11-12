package com.sls.report.dto;

public class POReport19DTOLineItemDTO {

	private String itemCode;
	private String itemDesc;
	private String unit;
	private float rate;
	private float disc;
	private float cst;
	private float sch;
	private float excise;
	private long deliveryChg;
	private String make;
	
	private AmmendLineitemDTO ammendLineitems;
	
	
	
	public AmmendLineitemDTO getAmmendLineitems() {
		return ammendLineitems;
	}
	public void setAmmendLineitems(AmmendLineitemDTO ammendLineitems) {
		this.ammendLineitems = ammendLineitems;
	}
	
	
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
	public float getSch() {
		return sch;
	}
	public void setSch(float sch) {
		this.sch = sch;
	}
	public float getExcise() {
		return excise;
	}
	public void setExcise(float excise) {
		this.excise = excise;
	}
	public long getDeliveryChg() {
		return deliveryChg;
	}
	public void setDeliveryChg(long deliveryChg) {
		this.deliveryChg = deliveryChg;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	
	
	
}
