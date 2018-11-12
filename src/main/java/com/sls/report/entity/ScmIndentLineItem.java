package com.sls.report.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SCM_INDENT_LINE_ITEM")
public class ScmIndentLineItem {

	@Id
	@Column(name="INDENT_SRL_NO", nullable = true)
	private long indentSrlNo;
	
	@Column(name="FIN_YEAR")
	private String finYear;
	
	@Column(name="INDENT_TYPE")
	private String indentType;
	
	@Column(name="INDENT_NO")
	private String indentNo;
	
	@Column(name="GROUP_CODE")
	private String grpCode;
	
	@Column(name="ITEM_CODE")
	private String itemCode;
	
	@Column(name="DTL_ITEM_DESC")
	private String itemDesc;
	
	@Column(name="UOM_CODE")
	private String uomCode;
	
	@Column(name="INDENT_QTY", nullable = true)
	private Long indentQnt;
	
	@Column(name="CANCEL_QTY", nullable = true)
	private Long cancelQnt;
	
	@Column(name="DEPT_CODE")
	private String deptCode;
	
	@Column(name="DEL_TERM")
	private String delTerm;
	
	@Column(name="DEL_NO", nullable = true)
	private Long delNo;
	
	@Column(name="REMARK")
	private String remark;
	
	@Column(name="PO_QTY", nullable = true)
	private Long poQnt;
	
	@Column(name="JOB_NO")
	private String jonNo;
	
	@Column(name="JOB_DATE")
	private Date jobDate;
	
	@Column(name="ENQUIRY_TAG")
	private String enquiryTag;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	@Column(name="STOCK_IN_HAND", nullable = true)
	private Long stockInHand;
	
	@Column(name="INDENT_STATUS")
	private String indentStatus;
	
	@Column(name="APPROVER_LEVEL_FIRST")
	private String approverLevelFirst;
	
	@Column(name="APPROVE_LEVEL_FIRST_DATE")
	private Date approverLevelFirstDate;
	
	@Column(name="APPROVER_LEVEL_SECOND")
	private String approverLevelSecond;
	
	@Column(name="APPROVE_LEVEL_SECOND_DATE")
	private Date approverLevelSecondDate;
	
	@Column(name="QUALITY")
	private String quality;
	
	@Column(name="MARKA")
	private String marka;
	
	@Column(name="ADDITIONAL_REQUIREMENT")
	private String additionalRequirement;

	public long getIndentSrlNo() {
		return indentSrlNo;
	}

	public void setIndentSrlNo(long indentSrlNo) {
		this.indentSrlNo = indentSrlNo;
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

	public String getIndentNo() {
		return indentNo;
	}

	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
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

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getUomCode() {
		return uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public Long getIndentQnt() {
		return indentQnt;
	}

	public void setIndentQnt(Long indentQnt) {
		this.indentQnt = indentQnt;
	}

	public Long getCancelQnt() {
		return cancelQnt;
	}

	public void setCancelQnt(Long cancelQnt) {
		this.cancelQnt = cancelQnt;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDelTerm() {
		return delTerm;
	}

	public void setDelTerm(String delTerm) {
		this.delTerm = delTerm;
	}

	public Long getDelNo() {
		return delNo;
	}

	public void setDelNo(Long delNo) {
		this.delNo = delNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getPoQnt() {
		return poQnt;
	}

	public void setPoQnt(Long poQnt) {
		this.poQnt = poQnt;
	}

	public String getJonNo() {
		return jonNo;
	}

	public void setJonNo(String jonNo) {
		this.jonNo = jonNo;
	}

	public Date getJobDate() {
		return jobDate;
	}

	public void setJobDate(Date jobDate) {
		this.jobDate = jobDate;
	}

	public String getEnquiryTag() {
		return enquiryTag;
	}

	public void setEnquiryTag(String enquiryTag) {
		this.enquiryTag = enquiryTag;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public long getStockInHand() {
		return stockInHand;
	}

	public void setStockInHand(long stockInHand) {
		this.stockInHand = stockInHand;
	}

	public String getIndentStatus() {
		return indentStatus;
	}

	public void setIndentStatus(String indentStatus) {
		this.indentStatus = indentStatus;
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

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getAdditionalRequirement() {
		return additionalRequirement;
	}

	public void setAdditionalRequirement(String additionalRequirement) {
		this.additionalRequirement = additionalRequirement;
	}

	@Override
	public String toString() {
		return "ScmIndentLineItem [indentSrlNo=" + indentSrlNo + ", finYear=" + finYear + ", indentType=" + indentType
				+ ", indentNo=" + indentNo + ", grpCode=" + grpCode + ", itemCode=" + itemCode + ", itemDesc="
				+ itemDesc + ", uomCode=" + uomCode + ", indentQnt=" + indentQnt + ", cancelQnt=" + cancelQnt
				+ ", deptCode=" + deptCode + ", delTerm=" + delTerm + ", delNo=" + delNo + ", remark=" + remark
				+ ", poQnt=" + poQnt + ", jonNo=" + jonNo + ", jobDate=" + jobDate + ", enquiryTag=" + enquiryTag
				+ ", isActive=" + isActive + ", stockInHand=" + stockInHand + ", indentStatus=" + indentStatus
				+ ", approverLevelFirst=" + approverLevelFirst + ", approverLevelFirstDate=" + approverLevelFirstDate
				+ ", approverLevelSecond=" + approverLevelSecond + ", approverLevelSecondDate="
				+ approverLevelSecondDate + ", quality=" + quality + ", marka=" + marka + ", additionalRequirement="
				+ additionalRequirement + "]";
	}
	
	
	
	
	
}
