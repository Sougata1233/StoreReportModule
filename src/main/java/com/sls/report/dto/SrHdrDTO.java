package com.sls.report.dto;

import java.sql.Date;

public class SrHdrDTO {

	private String orderNo;
	private long srNo;
	private long srQnt;
	private Date srDate;
	private long lineitemsrl;
	
	
	
	public long getLineitemsrl() {
		return lineitemsrl;
	}
	public void setLineitemsrl(long lineitemsrl) {
		this.lineitemsrl = lineitemsrl;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public long getSrNo() {
		return srNo;
	}
	public void setSrNo(long srNo) {
		this.srNo = srNo;
	}
	public long getSrQnt() {
		return srQnt;
	}
	public void setSrQnt(long srQnt) {
		this.srQnt = srQnt;
	}
	public Date getSrDate() {
		return srDate;
	}
	public void setSrDate(Date srDate) {
		this.srDate = srDate;
	}
	
	
	
	
}
