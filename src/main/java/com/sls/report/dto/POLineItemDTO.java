package com.sls.report.dto;

public class POLineItemDTO {

	private float acceptedQnt;
	private float rate;
	private String uom;
	private String make;
	private String description;
	private String itemCode;
	private float ammount;
	
	
	
	public float getAmmount() {
		return ammount;
	}
	public void setAmmount(float ammount) {
		this.ammount = ammount;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public float getAcceptedQnt() {
		return acceptedQnt;
	}
	public void setAcceptedQnt(float acceptedQnt) {
		this.acceptedQnt = acceptedQnt;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "POLineItemDTO [acceptedQnt=" + acceptedQnt + ", rate=" + rate + ", unit=" + uom + ", make=" + make
				+ ", description=" + description + "]";
	}
	public POLineItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public POLineItemDTO(float acceptedQnt, float rate, String uom, String make, String description) {
		super();
		this.acceptedQnt = acceptedQnt;
		this.rate = rate;
		this.uom = uom;
		this.make = make;
		this.description = description;
	}
	
	
	
}
