package com.sls.report.dto;

import java.sql.Date;
import java.util.List;

public class OutstandingIndentReportDTO {

	private String indentNo;
	private Date date;
	private long supplyQnt;
	private long balanceQntToSupp;
	private Date lastSuppDate;
	
	private List<OutstandingReportLineItemDTO> oustandingreportDTO;
	
	
	
	public List<OutstandingReportLineItemDTO> getOustandingreportDTO() {
		return oustandingreportDTO;
	}
	public void setOustandingreportDTO(List<OutstandingReportLineItemDTO> oustandingreportDTO) {
		this.oustandingreportDTO = oustandingreportDTO;
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
	public long getSupplyQnt() {
		return supplyQnt;
	}
	public void setSupplyQnt(long supplyQnt) {
		this.supplyQnt = supplyQnt;
	}
	public long getBalanceQntToSupp() {
		return balanceQntToSupp;
	}
	public void setBalanceQntToSupp(long balanceQntToSupp) {
		this.balanceQntToSupp = balanceQntToSupp;
	}
	public Date getLastSuppDate() {
		return lastSuppDate;
	}
	public void setLastSuppDate(Date lastSuppDate) {
		this.lastSuppDate = lastSuppDate;
	}
	
	
	
	
}
