package com.sls.report.dto;

public class PO02ReportLineDTO {

	private String indentNo;
	private String srlNo;
	private long quantity;
	private float rate;
	private float discount;
	private float cst;
	private float surcharge;
	private float excise;
	private String deliverySchedule;
	
	
	
	public String getDeliverySchedule() {
		return deliverySchedule;
	}
	public void setDeliverySchedule(String deliverySchedule) {
		this.deliverySchedule = deliverySchedule;
	}
	public String getIndentNo() {
		return indentNo;
	}
	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
	}
	public String getSrlNo() {
		return srlNo;
	}
	public void setSrlNo(String srlNo) {
		this.srlNo = srlNo;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
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
	public float getCst() {
		return cst;
	}
	public void setCst(float cst) {
		this.cst = cst;
	}
	public float getSurcharge() {
		return surcharge;
	}
	public void setSurcharge(float surcharge) {
		this.surcharge = surcharge;
	}
	public float getExcise() {
		return excise;
	}
	public void setExcise(float excise) {
		this.excise = excise;
	}
	
	
	
}
