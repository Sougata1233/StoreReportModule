package com.sls.report.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SCM_INDENT_CANCEL")
public class ScmIndentCancel {
	
	@Id
	@Column(name="CANCEL_NO")
	private long cancelNo;
	
	@Column(name="FIN_YEAR")
	private String finYear;
	
	@Column(name="INDENT_TYPE")
	private String indentType;
	
	@Column(name="INDENT_NO")
	private String indentNO;
	
	@Column(name="INDENT_SRL_NO", nullable = true)
	private long indentSrlNo;
	
	@Column(name="CANCEL_FIN_YEAR")
	private String cancelFinYear;
	
	@Column(name="GROUP_CODE")
	private String grpCode;
	
	@Column(name="ITEM_CODE")
	private String itemCode;
	
	@Column(name="INDENT_QTY", nullable = true)
	private long indentQnt;
	
	@Column(name="CANCEL_QTY", nullable = true)
	private long cancelQnt;
	
	@Column(name="CANCEL_DATE")
	private Date cancelDate;
	
	@Column(name="CANCEL_REASON")
	private String cancelReason;
	
	@Column(name="CANCEL_CODE")
	private String cancelCode;
	
	@Column(name="YYMM")
	private String yymm;
	
	@Column(name="MILL_CODE")
	private String millCode;
	
	@Column(name="PRINT_TAG")
	private String printTag;
	
	@Column(name="USER_1")
	private String user1;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="INDENT_STATUS")
	private String indentStatus;
	
	@Column(name="IS_ACTIVE")
	private String isActive;

	public long getCancelNo() {
		return cancelNo;
	}

	public void setCancelNo(long cancelNo) {
		this.cancelNo = cancelNo;
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

	public String getIndentNO() {
		return indentNO;
	}

	public void setIndentNO(String indentNO) {
		this.indentNO = indentNO;
	}

	public long getIndentSrlNo() {
		return indentSrlNo;
	}

	public void setIndentSrlNo(long indentSrlNo) {
		this.indentSrlNo = indentSrlNo;
	}

	public String getCancelFinYear() {
		return cancelFinYear;
	}

	public void setCancelFinYear(String cancelFinYear) {
		this.cancelFinYear = cancelFinYear;
	}

	public String getGrpCode() {
		return grpCode;
	}

	public void setGrpCode(String grpCode) {
		this.grpCode = grpCode;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

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

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCancelCode() {
		return cancelCode;
	}

	public void setCancelCode(String cancelCode) {
		this.cancelCode = cancelCode;
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

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
	

}
