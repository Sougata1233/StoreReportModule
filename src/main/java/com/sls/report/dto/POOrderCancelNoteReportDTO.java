package com.sls.report.dto;

import java.util.List;

public class POOrderCancelNoteReportDTO {

	private String cancelReson;
	private String orderNo;
	private float cst;
	private float sch;
	
	private List<POCancelNoteReportLineDTO> line;
	
	
	public float getSch() {
		return sch;
	}
	public void setSch(float sch) {
		this.sch = sch;
	}
	public List<POCancelNoteReportLineDTO> getLine() {
		return line;
	}
	public void setLine(List<POCancelNoteReportLineDTO> line) {
		this.line = line;
	}
	public String getCancelReson() {
		return cancelReson;
	}
	public void setCancelReson(String cancelReson) {
		this.cancelReson = cancelReson;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public float getCst() {
		return cst;
	}
	public void setCst(float cst) {
		this.cst = cst;
	}
	
	
	
}
