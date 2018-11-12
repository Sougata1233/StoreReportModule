package com.sls.report.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BILL_PASS")
public class BillPass {
	
	@Id
	@Column(name="BILL_PASS_TRANS_NO")
	private long billPassTransNo;
	
	@Column(name="SUPP_CODE")
	private String suppCode;
	
	@Column(name="BILL_NO")
	private String billNo;
	
	@Column(name="BILL_DATE")
	private Date billDate;
	
	@Column(name="BILL_AMOUNT", nullable = true)
	private long billAmount;
	
	@Column(name="SR_MR_NUM")
	private String srMrNum;
	
	@Column(name="PO_NUM")
	private String poNo;
	
	@Column(name="DOC_TYPE")
	private String docType;
	
	@Column(name="ADJUSTMENT_TYPE")
	private String adjustmentType;
	
	@Column(name="DOC_NUM")
	private String docNum;
	
	@Column(name="FIN_YEAR")
	private String finYear;

	public long getBillPassTransNo() {
		return billPassTransNo;
	}

	public void setBillPassTransNo(long billPassTransNo) {
		this.billPassTransNo = billPassTransNo;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public long getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(long billAmount) {
		this.billAmount = billAmount;
	}

	public String getSrMrNum() {
		return srMrNum;
	}

	public void setSrMrNum(String srMrNum) {
		this.srMrNum = srMrNum;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getAdjustmentType() {
		return adjustmentType;
	}

	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public String getDocNum() {
		return docNum;
	}

	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}

	public String getFinYear() {
		return finYear;
	}

	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}

	@Override
	public String toString() {
		return "BillPass [billPassTransNo=" + billPassTransNo + ", suppCode=" + suppCode + ", billNo=" + billNo
				+ ", billDate=" + billDate + ", billAmount=" + billAmount + ", srMrNum=" + srMrNum + ", poNo=" + poNo
				+ ", docType=" + docType + ", adjustmentType=" + adjustmentType + ", docNum=" + docNum + ", finYear="
				+ finYear + "]";
	}

	public BillPass(long billPassTransNo, String suppCode, String billNo, Date billDate, long billAmount,
			String srMrNum, String poNo, String docType, String adjustmentType, String docNum, String finYear) {
		super();
		this.billPassTransNo = billPassTransNo;
		this.suppCode = suppCode;
		this.billNo = billNo;
		this.billDate = billDate;
		this.billAmount = billAmount;
		this.srMrNum = srMrNum;
		this.poNo = poNo;
		this.docType = docType;
		this.adjustmentType = adjustmentType;
		this.docNum = docNum;
		this.finYear = finYear;
	}

	public BillPass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
