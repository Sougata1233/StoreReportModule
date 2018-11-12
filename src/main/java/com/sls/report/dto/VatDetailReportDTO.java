package com.sls.report.dto;

import java.sql.Date;

public class VatDetailReportDTO {

	private String srNo;
	private Date srDate;
	private Long srQnt;
	private Long srValue;
	private Float vatAmt;
	private String suppName;
	private String billNumber;
	private Date billDate;

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public Date getSrDate() {
		return srDate;
	}

	public void setSrDate(Date srDate) {
		this.srDate = srDate;
	}

	public Long getSrQnt() {
		return srQnt;
	}

	public void setSrQnt(Long srQnt) {
		this.srQnt = srQnt;
	}

	public Long getSrValue() {
		return srValue;
	}

	public void setSrValue(Long srValue) {
		this.srValue = srValue;
	}

	public Float getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(Float vatAmt) {
		this.vatAmt = vatAmt;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

}
