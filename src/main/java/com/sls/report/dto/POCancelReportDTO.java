package com.sls.report.dto;

import java.util.List;

public class POCancelReportDTO {

	private String cancelRefNo;
	private String orderNo;
	private float sCh;
	private List<POCancelLineitemReportDTO> cancelorderlineitems;
	
	
	public float getsCh() {
		return sCh;
	}
	public void setsCh(float sCh) {
		this.sCh = sCh;
	}
	public List<POCancelLineitemReportDTO> getCancelorderlineitems() {
		return cancelorderlineitems;
	}
	public void setCancelorderlineitems(List<POCancelLineitemReportDTO> cancelorderlineitems) {
		this.cancelorderlineitems = cancelorderlineitems;
	}
	public String getCancelRefNo() {
		return cancelRefNo;
	}
	public void setCancelRefNo(String cancelRefNo) {
		this.cancelRefNo = cancelRefNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	
}
