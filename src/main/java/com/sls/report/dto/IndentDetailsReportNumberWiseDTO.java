package com.sls.report.dto;

import java.sql.Date;
import java.util.List;

public class IndentDetailsReportNumberWiseDTO {

	private String indentNo;
	private Date indentDate;
	
	private long outstQnt;
	
	private List<IndentDetailsReportNumberWiseLineItemDTO> IndentDetailsReportNumberWiseLineItems;
	private List<SrHdrDTO> srhdrs;
	
	
	
	
	public List<SrHdrDTO> getSrhdrs() {
		return srhdrs;
	}
	public void setSrhdrs(List<SrHdrDTO> srhdrs) {
		this.srhdrs = srhdrs;
	}
	public List<IndentDetailsReportNumberWiseLineItemDTO> getIndentDetailsReportNumberWiseLineItems() {
		return IndentDetailsReportNumberWiseLineItems;
	}
	public void setIndentDetailsReportNumberWiseLineItems(
			List<IndentDetailsReportNumberWiseLineItemDTO> indentDetailsReportNumberWiseLineItems) {
		IndentDetailsReportNumberWiseLineItems = indentDetailsReportNumberWiseLineItems;
	}
	public String getIndentNo() {
		return indentNo;
	}
	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
	}
	public Date getIndentDate() {
		return indentDate;
	}
	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}
	public long getOutstQnt() {
		return outstQnt;
	}
	public void setOutstQnt(long outstQnt) {
		this.outstQnt = outstQnt;
	}
	
	
	
}
