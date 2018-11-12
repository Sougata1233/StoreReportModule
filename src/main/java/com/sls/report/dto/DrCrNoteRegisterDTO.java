package com.sls.report.dto;

import java.sql.Date;

public class DrCrNoteRegisterDTO {
	
	private long drCrNum;
	private Date drCrDate;
	private String suppName;
	private String itemCode;
	private String reason;
	private long drCrQuantity;
	private long amount;
	private String srNum;
	
	
	public String getSrNum() {
		return srNum;
	}
	public void setSrNum(String srNum) {
		this.srNum = srNum;
	}
	public long getDrCrNum() {
		return drCrNum;
	}
	public void setDrCrNum(long drCrNum) {
		this.drCrNum = drCrNum;
	}
	public Date getDrCrDate() {
		return drCrDate;
	}
	public void setDrCrDate(Date drCrDate) {
		this.drCrDate = drCrDate;
	}
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public long getDrCrQuantity() {
		return drCrQuantity;
	}
	public void setDrCrQuantity(long drCrQuantity) {
		this.drCrQuantity = drCrQuantity;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "DrCrNoteRegisterDTO [drCrNum=" + drCrNum + ", drCrDate=" + drCrDate + ", suppName=" + suppName
				+ ", itemCode=" + itemCode + ", reason=" + reason + ", drCrQuantity=" + drCrQuantity + ", amount="
				+ amount + "]";
	}
	public DrCrNoteRegisterDTO(long drCrNum, Date drCrDate, String suppName, String itemCode, String reason,
			long drCrQuantity, long amount) {
		super();
		this.drCrNum = drCrNum;
		this.drCrDate = drCrDate;
		this.suppName = suppName;
		this.itemCode = itemCode;
		this.reason = reason;
		this.drCrQuantity = drCrQuantity;
		this.amount = amount;
	}
	public DrCrNoteRegisterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
