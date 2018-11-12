package com.sls.report.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SCM_SR_HDR")
public class ScmSrHdr {

	@Id
	@Column(name="STORE_RECEIVE_NO")
	private Long storeReceiveNo;
	
	@Column(name="STORE_RECEIVE_DT")
	private Date storeReceiveDt;
	
	@Column(name="SUPP_CODE")
	private String suppCode;
	
	@Column(name="PO_NUM")
	private String poNum;
	
	@Column(name="PO_DATE")
	private Date poDate;
	
	@Column(name="CHALAN_NO", nullable = true)
	private Long challanNo;
	
	@Column(name="CHALAN_DATE")
	private Date challanDate;
	
	@Column(name="STORE_NO")
	private String storeNo;
	
	@Column(name="SR_GOOD_RECEPT_STATUS")
	private String srGoodReceptStatus;
	
	@Column(name="SUBMITTER")
	private String submitter;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="ISSUED_TO")
	private String issuedTo;

	public Long getStoreReceiveNo() {
		return storeReceiveNo;
	}

	public void setStoreReceiveNo(Long storeReceiveNo) {
		this.storeReceiveNo = storeReceiveNo;
	}

	public Date getStoreReceiveDt() {
		return storeReceiveDt;
	}

	public void setStoreReceiveDt(Date storeReceiveDt) {
		this.storeReceiveDt = storeReceiveDt;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public String getPoNum() {
		return poNum;
	}

	public void setPoNum(String poNum) {
		this.poNum = poNum;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public Long getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(Long challanNo) {
		this.challanNo = challanNo;
	}

	public Date getChallanDate() {
		return challanDate;
	}

	public void setChallanDate(Date challanDate) {
		this.challanDate = challanDate;
	}

	public String getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}

	public String getSrGoodReceptStatus() {
		return srGoodReceptStatus;
	}

	public void setSrGoodReceptStatus(String srGoodReceptStatus) {
		this.srGoodReceptStatus = srGoodReceptStatus;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(String issuedTo) {
		this.issuedTo = issuedTo;
	}

	@Override
	public String toString() {
		return "ScmSrHdr [storeReceiveNo=" + storeReceiveNo + ", storeReceiveDt=" + storeReceiveDt + ", suppCode="
				+ suppCode + ", poNum=" + poNum + ", poDate=" + poDate + ", challanNo=" + challanNo + ", challanDate="
				+ challanDate + ", storeNo=" + storeNo + ", srGoodReceptStatus=" + srGoodReceptStatus + ", submitter="
				+ submitter + ", createDate=" + createDate + ", issuedTo=" + issuedTo + "]";
	}

	public ScmSrHdr(Long storeReceiveNo, Date storeReceiveDt, String suppCode, String poNum, Date poDate,
			Long challanNo, Date challanDate, String storeNo, String srGoodReceptStatus, String submitter,
			Date createDate, String issuedTo) {
		super();
		this.storeReceiveNo = storeReceiveNo;
		this.storeReceiveDt = storeReceiveDt;
		this.suppCode = suppCode;
		this.poNum = poNum;
		this.poDate = poDate;
		this.challanNo = challanNo;
		this.challanDate = challanDate;
		this.storeNo = storeNo;
		this.srGoodReceptStatus = srGoodReceptStatus;
		this.submitter = submitter;
		this.createDate = createDate;
		this.issuedTo = issuedTo;
	}

	public ScmSrHdr() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
