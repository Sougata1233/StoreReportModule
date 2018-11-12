package com.sls.report.dto;

import java.sql.Date;
import java.util.List;

public class POOutstandingSummaryDTO {

	private String poNo;
	private long ammendNo;
	private Date date;
	private String supplier;
	private String cancelNo;
	private Date cancelDate;
	private float balanceQty;

	private float cancelQnt;

	private List<POOutstandingSummaryLineDTO> OOutstandingSummaryLineDTO;

	public List<POOutstandingSummaryLineDTO> getOOutstandingSummaryLineDTO() {
		return OOutstandingSummaryLineDTO;
	}

	public void setOOutstandingSummaryLineDTO(List<POOutstandingSummaryLineDTO> oOutstandingSummaryLineDTO) {
		OOutstandingSummaryLineDTO = oOutstandingSummaryLineDTO;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public long getAmmendNo() {
		return ammendNo;
	}

	public void setAmmendNo(long ammendNo) {
		this.ammendNo = ammendNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getCancelNo() {
		return cancelNo;
	}

	public void setCancelNo(String cancelNo) {
		this.cancelNo = cancelNo;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public float getBalanceQty() {
		return balanceQty;
	}

	public void setBalanceQty(float balanceQty) {
		this.balanceQty = balanceQty;
	}

	public float getCancelQnt() {
		return cancelQnt;
	}

	public void setCancelQnt(float cancelQnt) {
		this.cancelQnt = cancelQnt;
	}

}
