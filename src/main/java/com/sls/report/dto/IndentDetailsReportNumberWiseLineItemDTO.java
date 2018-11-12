package com.sls.report.dto;

import java.sql.Date;
import java.util.List;

import com.sls.report.entity.ScmIndentCancel;

public class IndentDetailsReportNumberWiseLineItemDTO {

	private long indentQnt;
	private long orederQnt;
	private String itemCode;
	private String description;
	private String uom;
	private long srl;
	private long cancelQnt;
	private long cancelNo;
	private Date cancellationDate;
	
	
	public long getCancelQnt() {
		return cancelQnt;
	}
	public void setCancelQnt(long cancelQnt) {
		this.cancelQnt = cancelQnt;
	}
	public long getCancelNo() {
		return cancelNo;
	}
	public void setCancelNo(long cancelNo) {
		this.cancelNo = cancelNo;
	}
	public Date getCancellationDate() {
		return cancellationDate;
	}
	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}
	public long getIndentQnt() {
		return indentQnt;
	}
	public void setIndentQnt(long indentQnt) {
		this.indentQnt = indentQnt;
	}
	public long getOrederQnt() {
		return orederQnt;
	}
	public void setOrederQnt(long orederQnt) {
		this.orederQnt = orederQnt;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public long getSrl() {
		return srl;
	}
	public void setSrl(long srl) {
		this.srl = srl;
	}
	
	
	
	
}
