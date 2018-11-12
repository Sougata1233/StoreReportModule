package com.sls.report.dto;

import java.sql.Date;

public class VatReportWithRespectToGstDTO {

	private String itemCode;
	private String itemDesc;
	private String uom;
	private String srNo;
	private Date srDate;
	private long srQnt;
	private long srValue;
	private Float vatAmt;
	private String suppName;
	private String billNumber;
	private Date billDate;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

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

	public long getSrQnt() {
		return srQnt;
	}

	public void setSrQnt(long srQnt) {
		this.srQnt = srQnt;
	}

	public long getSrValue() {
		return srValue;
	}

	public void setSrValue(long srValue) {
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
