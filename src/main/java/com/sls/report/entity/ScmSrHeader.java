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
@Table(name="SCM_SR_HDR")

public class ScmSrHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SR_GRN_HDR_SEQ")
    @SequenceGenerator(sequenceName = "SCM_GRN_HEADER_SEQ", allocationSize = 1, name = "SR_GRN_HDR_SEQ")
	@Column(name="STORE_RECEIVE_NO")
	private  long id;
	
	@Column(name="STORE_RECEIVE_DT")
	private  Date goodReceiptDate ;
	
	@Column(name="SUPP_CODE")
	private  String supplierId ;	
	
	@Column(name="PO_NUM")
	private  String poId ;
	
	@Column(name="PO_DATE")
	private  Date poDate ;	
	
	
	@Column(name="CHALAN_NO", nullable = true)
	private  long chalanNo ;
	
	@Column(name="CHALAN_DATE")
	private  Date chalanDate ;
	
	@Column(name="STORE_NO")
	private  String storeNo ;
	
	@Column(name="SR_GOOD_RECEPT_STATUS")
	private  String status ;
	
	@Column(name="SUBMITTER")
	private  String submitter ;
	
	
	@Column(name="CREATE_DATE")
	private  Date createDate ;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getGoodReceiptDate() {
		return goodReceiptDate;
	}


	public void setGoodReceiptDate(Date goodReceiptDate) {
		this.goodReceiptDate = goodReceiptDate;
	}


	public String getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}


	public String getPoId() {
		return poId;
	}


	public void setPoId(String poId) {
		this.poId = poId;
	}


	public Date getPoDate() {
		return poDate;
	}


	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}


	public long getChalanNo() {
		return chalanNo;
	}


	public void setChalanNo(long chalanNo) {
		this.chalanNo = chalanNo;
	}


	public Date getChalanDate() {
		return chalanDate;
	}


	public void setChalanDate(Date chalanDate) {
		this.chalanDate = chalanDate;
	}


	public String getStoreNo() {
		return storeNo;
	}


	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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
	
	
	


	
	
}