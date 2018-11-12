package com.sls.report.dto;

import java.sql.Date;

public class CancelledIndentDTO {

	private String indentNO;
	private Date date;
	private String itemCode;
	private String description;
	private long quantity;
	private String reason;
	private String unit;
	private long indentQnt;
	private long cancelQnt;
	
	
	
	public long getIndentQnt() {
		return indentQnt;
	}
	public void setIndentQnt(long indentQnt) {
		this.indentQnt = indentQnt;
	}
	public long getCancelQnt() {
		return cancelQnt;
	}
	public void setCancelQnt(long cancelQnt) {
		this.cancelQnt = cancelQnt;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getIndentNO() {
		return indentNO;
	}
	public void setIndentNO(String indentNO) {
		this.indentNO = indentNO;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	
}
