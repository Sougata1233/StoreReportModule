package com.sls.report.dto;

import java.sql.Date;
import java.util.List;

public class InwardRegisterReportDTO {
	
	private long inwardNo;
	private Date entryDate;
	private String challanNoDate;
	private String partyName;
	private String ammndNo;
	private Date poDate;
	private long regNo;
	private long rejectedQnt;
	private String srType;
	private String srNo;
	private long regNo1;
	private Date date2;
	private String indentSrlNo;
	private List<InwardReportDTO> inwardreports;
	public long getInwardNo() {
		return inwardNo;
	}
	public void setInwardNo(long inwardNo) {
		this.inwardNo = inwardNo;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public String getChallanNoDate() {
		return challanNoDate;
	}
	public void setChallanNoDate(String challanNoDate) {
		this.challanNoDate = challanNoDate;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getAmmndNo() {
		return ammndNo;
	}
	public void setAmmndNo(String ammndNo) {
		this.ammndNo = ammndNo;
	}
	public Date getPoDate() {
		return poDate;
	}
	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}
	public long getRegNo() {
		return regNo;
	}
	public void setRegNo(long regNo) {
		this.regNo = regNo;
	}
	public long getRejectedQnt() {
		return rejectedQnt;
	}
	public void setRejectedQnt(long rejectedQnt) {
		this.rejectedQnt = rejectedQnt;
	}
	public String getSrType() {
		return srType;
	}
	public void setSrType(String srType) {
		this.srType = srType;
	}
	public String getSrNo() {
		return srNo;
	}
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	public long getRegNo1() {
		return regNo1;
	}
	public void setRegNo1(long regNo1) {
		this.regNo1 = regNo1;
	}
	public Date getDate2() {
		return date2;
	}
	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	public String getIndentSrlNo() {
		return indentSrlNo;
	}
	public void setIndentSrlNo(String indentSrlNo) {
		this.indentSrlNo = indentSrlNo;
	}
	public List<InwardReportDTO> getInwardreports() {
		return inwardreports;
	}
	public void setInwardreports(List<InwardReportDTO> inwardreports) {
		this.inwardreports = inwardreports;
	}
	@Override
	public String toString() {
		return "InwardRegisterReportDTO [inwardNo=" + inwardNo + ", entryDate=" + entryDate + ", challanNoDate="
				+ challanNoDate + ", partyName=" + partyName + ", ammndNo=" + ammndNo + ", poDate=" + poDate
				+ ", regNo=" + regNo + ", rejectedQnt=" + rejectedQnt + ", srType=" + srType + ", srNo=" + srNo
				+ ", regNo1=" + regNo1 + ", date2=" + date2 + ", indentSrlNo=" + indentSrlNo + ", inwardreports="
				+ inwardreports + "]";
	}
	
	
	
}
