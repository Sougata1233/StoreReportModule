package com.sls.report.dto;

import java.util.List;

public class POReport19DTO {

	private String partyCode;
	private String partAddress;
	private String orderNo;
	private List<POReport19DTOLineItemDTO> lineitems;
	
	public String getPartyCode() {
		return partyCode;
	}
	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}
	public String getPartAddress() {
		return partAddress;
	}
	public void setPartAddress(String partAddress) {
		this.partAddress = partAddress;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public List<POReport19DTOLineItemDTO> getLineitems() {
		return lineitems;
	}
	public void setLineitems(List<POReport19DTOLineItemDTO> lineitemDTOs) {
		this.lineitems = lineitemDTOs;
	}
	
	
}
