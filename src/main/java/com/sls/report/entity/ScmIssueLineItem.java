package com.sls.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Entity class for SCM_ISSUE_LINE_ITEM
 */

@Entity
@Table(name="SCM_ISSUE_LINE_ITEM")
public class ScmIssueLineItem {
	
	@Id
	@Column(name="ISSUE_NO")
	private String issueNo;
	
	@Column(name="ISSUE_SRL_NO", nullable = true)
	private long issueSrlNo;
	
	@Column(name="GROUP_CODE")
	private String groupCode;
	
	@Column(name="ITEM_CODE")
	private String itemCode;
	
	@Column(name="UOM_CODE")
	private String uomCode;
	
	@Column(name="ISSUE_QTY", nullable = true)
	private long issueQty;
	
	@Column(name="REMARK")
	private String remark;
	
	@Column(name="STOCK_IN_HAND", nullable = true)
	private long stockInHand;
	
	@Column(name="QUALITY")
	private String quality;
	
	@Column(name="MARKA")
	private String marka;
	
	@Column(name="ADDITIONAL_REQUIREMENT")
	private String additionalRequirement;

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public long getIssueSrlNo() {
		return issueSrlNo;
	}

	public void setIssueSrlNo(long issueSrlNo) {
		this.issueSrlNo = issueSrlNo;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getUomCode() {
		return uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public long getIssueQty() {
		return issueQty;
	}

	public void setIssueQty(long issueQty) {
		this.issueQty = issueQty;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getStockInHand() {
		return stockInHand;
	}

	public void setStockInHand(long stockInHand) {
		this.stockInHand = stockInHand;
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

	public ScmIssueLineItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScmIssueLineItem(String issueNo, long issueSrlNo, String groupCode, String itemCode, String uomCode,
			long issueQty, String remark, long stockInHand, String quality, String marka,
			String additionalRequirement) {
		super();
		this.issueNo = issueNo;
		this.issueSrlNo = issueSrlNo;
		this.groupCode = groupCode;
		this.itemCode = itemCode;
		this.uomCode = uomCode;
		this.issueQty = issueQty;
		this.remark = remark;
		this.stockInHand = stockInHand;
		this.quality = quality;
		this.marka = marka;
		this.additionalRequirement = additionalRequirement;
	}

	@Override
	public String toString() {
		return "ScmIssueLineItem [issueNo=" + issueNo + ", issueSrlNo=" + issueSrlNo + ", groupCode=" + groupCode
				+ ", itemCode=" + itemCode + ", uomCode=" + uomCode + ", issueQty=" + issueQty + ", remark=" + remark
				+ ", stockInHand=" + stockInHand + ", quality=" + quality + ", marka=" + marka
				+ ", additionalRequirement=" + additionalRequirement + "]";
	}
	
	
	
	

}
