package com.sls.report.dto;

import java.sql.Date;
import java.util.List;

public class PurchaseOrderHistoryReportDTO {

	private String partyName;
	private String company;
	private String orderNo;
	private Date date;
	private float discount;
	private List<PurchaseOrderHistoryReportLineitemDTO> lineitems;
	
	
	
	public List<PurchaseOrderHistoryReportLineitemDTO> getLineitems() {
		return lineitems;
	}
	public void setLineitems(List<PurchaseOrderHistoryReportLineitemDTO> lineitems) {
		this.lineitems = lineitems;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	
	
	
}
