package com.sls.report.dto;

import java.util.List;

public class OrderRegisterDTO {

	private String orderNo;
	private String partyCode;
	private String partyName;
	private float SChr;
	private float discount;
	private float excise;
	
	private List<OrderRegisterLineitemDTO> orderregisterlineitems;
	
	
	
	
	public float getExcise() {
		return excise;
	}
	public void setExcise(float excise) {
		this.excise = excise;
	}
	public List<OrderRegisterLineitemDTO> getOrderregisterlineitems() {
		return orderregisterlineitems;
	}
	public void setOrderregisterlineitems(List<OrderRegisterLineitemDTO> orderregisterlineitems) {
		this.orderregisterlineitems = orderregisterlineitems;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getPartyCode() {
		return partyCode;
	}
	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public float getSChr() {
		return SChr;
	}
	public void setSChr(float sChr) {
		SChr = sChr;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	
	
	
}
