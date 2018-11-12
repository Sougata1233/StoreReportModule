package com.sls.report.dto;

import java.sql.Date;
import java.util.List;

public class IndentSummaryReportWaitingForPODTO {

	private String indentNo;
	
	private Date date;
	private float orderQnt;
	
	
	private List<IndentReport10LineDTO> lines;
	
	
	public List<IndentReport10LineDTO> getLines() {
		return lines;
	}
	public void setLines(List<IndentReport10LineDTO> lines) {
		this.lines = lines;
	}
	public String getIndentNo() {
		return indentNo;
	}
	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getOrderQnt() {
		return orderQnt;
	}
	public void setOrderQnt(float orderQnt) {
		this.orderQnt = orderQnt;
	}
	
	
}
