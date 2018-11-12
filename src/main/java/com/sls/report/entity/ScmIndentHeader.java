package com.sls.report.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SCM_INDENT_HDR")
public class ScmIndentHeader {

	@Id
	@Column(name="INDENT_NO")
	private String indentNo;
	
	@Column(name="FIN_YEAR")
	private String finYear;
	
	@Column(name="INDENT_TYPE")
	private String indentType;
	
	@Column(name="INDENT_DATE")
	private Date indentDate;
	
	@Column(name="YYMM")
	private String yymm;
	
	@Column(name="MILL_CODE")
	private String millCode;
	
	@Column(name="PRINT_TAG")
	private String printTag;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	@Column(name="USER_1")
	private String user1;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="INDENT_STATUS")
	private String indentStatus;
	
	@Column(name="MOD_BY")
	private String modBy;
	
	@Column(name="MOD_ON")
	private Date modOn;
	
	@Column(name="APPROVER_LEVEL_FIRST")
	private String approverLevelFirst;
	
	@Column(name="APPROVE_LEVEL_FIRST_DATE")
	private Date approverLevelFirstDate;
	
	@Column(name="APPROVER_LEVEL_SECOND")
	private String approverLevelSecond;
	
	@Column(name="APPROVE_LEVEL_SECOND_DATE")
	private Date approverLevelSecondDate;
	
	@Column(name="MUKAM")
	private String mukam;
	
	@Column(name="VEHICLE_TYPE_ID", nullable = true)
	private long vehicleTypeId;
	
	@Column(name="VEHICLE_QUANTITY", nullable = true)
	private long vehicleQnt;

	public String getIndentNo() {
		return indentNo;
	}

	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
	}

	public String getFinYear() {
		return finYear;
	}

	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}

	public String getIndentType() {
		return indentType;
	}

	public void setIndentType(String indentType) {
		this.indentType = indentType;
	}

	public Date getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}

	public String getYymm() {
		return yymm;
	}

	public void setYymm(String yymm) {
		this.yymm = yymm;
	}

	public String getMillCode() {
		return millCode;
	}

	public void setMillCode(String millCode) {
		this.millCode = millCode;
	}

	public String getPrintTag() {
		return printTag;
	}

	public void setPrintTag(String printTag) {
		this.printTag = printTag;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		this.user1 = user1;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getIndentStatus() {
		return indentStatus;
	}

	public void setIndentStatus(String indentStatus) {
		this.indentStatus = indentStatus;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}

	public String getApproverLevelFirst() {
		return approverLevelFirst;
	}

	public void setApproverLevelFirst(String approverLevelFirst) {
		this.approverLevelFirst = approverLevelFirst;
	}

	public Date getApproverLevelFirstDate() {
		return approverLevelFirstDate;
	}

	public void setApproverLevelFirstDate(Date approverLevelFirstDate) {
		this.approverLevelFirstDate = approverLevelFirstDate;
	}

	public String getApproverLevelSecond() {
		return approverLevelSecond;
	}

	public void setApproverLevelSecond(String approverLevelSecond) {
		this.approverLevelSecond = approverLevelSecond;
	}

	public Date getApproverLevelSecondDate() {
		return approverLevelSecondDate;
	}

	public void setApproverLevelSecondDate(Date approverLevelSecondDate) {
		this.approverLevelSecondDate = approverLevelSecondDate;
	}

	public String getMukam() {
		return mukam;
	}

	public void setMukam(String mukam) {
		this.mukam = mukam;
	}

	public long getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(long vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public long getVehicleQnt() {
		return vehicleQnt;
	}

	public void setVehicleQnt(long vehicleQnt) {
		this.vehicleQnt = vehicleQnt;
	}

	@Override
	public String toString() {
		return "ScmIndentHeader [indentNo=" + indentNo + ", finYear=" + finYear + ", indentType=" + indentType
				+ ", indentDate=" + indentDate + ", yymm=" + yymm + ", millCode=" + millCode + ", printTag=" + printTag
				+ ", isActive=" + isActive + ", user1=" + user1 + ", createDate=" + createDate + ", indentStatus="
				+ indentStatus + ", modBy=" + modBy + ", modOn=" + modOn + ", approverLevelFirst=" + approverLevelFirst
				+ ", approverLevelFirstDate=" + approverLevelFirstDate + ", approverLevelSecond=" + approverLevelSecond
				+ ", approverLevelSecondDate=" + approverLevelSecondDate + ", mukam=" + mukam + ", vehicleTypeId="
				+ vehicleTypeId + ", vehicleQnt=" + vehicleQnt + "]";
	}
	
	
	
	
}
