package com.sls.report.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name="DR_CR_NOTE")
public class DrCrNote {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PHYSICAL_STOCK_SEQ")
    @SequenceGenerator(sequenceName = "SCM_PHYSICAL_STOCK_SEQ", allocationSize = 1, name = "PHYSICAL_STOCK_SEQ")
	@Column(name="ADJUSTMENT_NO")
	private long adjustmentNo;
	
	@Column(name="ADJUSTMENT_TYPE")
	private String adjustmentType;
	
	@Column(name="ADJUSTMENT_DATE")
	private Date adjustmentDate;
	
	@Column(name="FIN_YEAR")
	private String finYear;
	
	@Column(name="SUPP_CODE")
	private String suppCode;
	
	@Column(name="SR_MR_NUM", nullable = true)
	private long srMrNum;
	
	@Column(name="SR_MR_YEAR")
	private String srMrYear;
	
	@Column(name="SR_MR_DATE")
	private Date srMrDate;
	
	@Column(name="ITEM_CODE")
	private String itemCode;
	
	@Column(name="ADJUSTMENT_QUANTITY", nullable = true)
	private long adjustmentQuantity;
	
	@Column(name="ADJUSTMENT_VALUE", nullable = true)
	private long adjustmentValue;
	
	@Column(name="REASON")
	private String reason;
	
	@Column(name="UOM_CODE")
	private String uomCode;

	public long getAdjustmentNo() {
		return adjustmentNo;
	}

	public void setAdjustmentNo(long adjustmentNo) {
		this.adjustmentNo = adjustmentNo;
	}

	public String getAdjustmentType() {
		return adjustmentType;
	}

	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public Date getAdjustmentDate() {
		return adjustmentDate;
	}

	public void setAdjustmentDate(Date adjustmentDate) {
		this.adjustmentDate = adjustmentDate;
	}

	public String getFinYear() {
		return finYear;
	}

	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public long getSrMrNum() {
		return srMrNum;
	}

	public void setSrMrNum(long srMrNum) {
		this.srMrNum = srMrNum;
	}

	public String getSrMrYear() {
		return srMrYear;
	}

	public void setSrMrYear(String srMrYear) {
		this.srMrYear = srMrYear;
	}

	public Date getSrMrDate() {
		return srMrDate;
	}

	public void setSrMrDate(Date srMrDate) {
		this.srMrDate = srMrDate;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public long getAdjustmentQuantity() {
		return adjustmentQuantity;
	}

	public void setAdjustmentQuantity(long adjustmentQuantity) {
		this.adjustmentQuantity = adjustmentQuantity;
	}

	public long getAdjustmentValue() {
		return adjustmentValue;
	}

	public void setAdjustmentValue(long adjustmentValue) {
		this.adjustmentValue = adjustmentValue;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getUomCode() {
		return uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	@Override
	public String toString() {
		return "DrCrNote [adjustmentNo=" + adjustmentNo + ", adjustmentType=" + adjustmentType + ", adjustmentDate="
				+ adjustmentDate + ", finYear=" + finYear + ", suppCode=" + suppCode + ", srMrNum=" + srMrNum
				+ ", srMrYear=" + srMrYear + ", srMrDate=" + srMrDate + ", itemCode=" + itemCode
				+ ", adjustmentQuantity=" + adjustmentQuantity + ", adjustmentValue=" + adjustmentValue + ", reason="
				+ reason + ", uomCode=" + uomCode + "]";
	}

	public DrCrNote(long adjustmentNo, String adjustmentType, Date adjustmentDate, String finYear, String suppCode,
			long srMrNum, String srMrYear, Date srMrDate, String itemCode, long adjustmentQuantity,
			long adjustmentValue, String reason, String uomCode) {
		super();
		this.adjustmentNo = adjustmentNo;
		this.adjustmentType = adjustmentType;
		this.adjustmentDate = adjustmentDate;
		this.finYear = finYear;
		this.suppCode = suppCode;
		this.srMrNum = srMrNum;
		this.srMrYear = srMrYear;
		this.srMrDate = srMrDate;
		this.itemCode = itemCode;
		this.adjustmentQuantity = adjustmentQuantity;
		this.adjustmentValue = adjustmentValue;
		this.reason = reason;
		this.uomCode = uomCode;
	}

	public DrCrNote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
