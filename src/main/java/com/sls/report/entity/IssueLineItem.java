package com.sls.report.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity()

@Table(name="SCM_ISSUE_LINE_ITEM")
public class IssueLineItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISSUE_ITM_SEQ")
    @SequenceGenerator(sequenceName = "SCM_ISSUE_ITEM_SEQ", allocationSize = 1, name = "ISSUE_ITM_SEQ")
	@Column(name="ISSUE_SRL_NO")
	private  long id;
	
	@Column(name="ISSUE_NO", nullable = true)
	private  long issueHeaderId;	
	
	
	@Column(name="GROUP_CODE")
	private  String itemGroupId;
	
	@Column(name="ITEM_CODE")
	private  String itemId;
	
	@Column(name="UOM_CODE")
	private  String unitId;
		
	@Column(name="STOCK_IN_HAND", nullable = true)
	private long stock;
	
	@Column(name="ISSUE_QTY", nullable = true)
	private long issueQuantity;	
	
	@Column(name="QUALITY", nullable = true)
	private  long qualityCode;
	
	@Column(name="MARKA")
	private  String marka;
	
	@Column(name="REMARK")
	private  String remark;
	
	@Column(name="ADDITIONAL_REQUIREMENT")
	private  String additionalRequirement;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIssueHeaderId() {
		return issueHeaderId;
	}

	public void setIssueHeaderId(long issueHeaderId) {
		this.issueHeaderId = issueHeaderId;
	}

	public String getItemGroupId() {
		return itemGroupId;
	}

	public void setItemGroupId(String itemGroupId) {
		this.itemGroupId = itemGroupId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public long getIssueQuantity() {
		return issueQuantity;
	}

	public void setIssueQuantity(long issueQuantity) {
		this.issueQuantity = issueQuantity;
	}

	public long getQualityCode() {
		return qualityCode;
	}

	public void setQualityCode(long qualityCode) {
		this.qualityCode = qualityCode;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAdditionalRequirement() {
		return additionalRequirement;
	}

	public void setAdditionalRequirement(String additionalRequirement) {
		this.additionalRequirement = additionalRequirement;
	}
	
	
}
