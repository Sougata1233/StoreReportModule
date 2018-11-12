package com.sls.report.dto;

import java.sql.Date;
import java.util.List;

public class PurchaseOrderCancelDTO {

	private String cancelNo;
	private Date date;
	private String partyName;
	private String partyCode;
	private String orderNo;
	private String finYear;
	private String reason;
	
	
	private List<OrderCancelLineitemDTO> ordercancellineitems;

	
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCancelNo() {
		return cancelNo;
	}

	public void setCancelNo(String cancelNo) {
		this.cancelNo = cancelNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPartyCode() {
		return partyCode;
	}

	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getFinYear() {
		return finYear;
	}

	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}

	public List<OrderCancelLineitemDTO> getOrdercancellineitems() {
		return ordercancellineitems;
	}

	public void setOrdercancellineitems(List<OrderCancelLineitemDTO> ordercancellineitems) {
		this.ordercancellineitems = ordercancellineitems;
	}
	
	
	
	
	
}
