package com.sls.report.entity;

import java.sql.Date;

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
@Table(name="SCM_PO_HDR")

public class POHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PO_HDR_SEQ")
    @SequenceGenerator(sequenceName = "SCM_PO_HEADER_SEQ", allocationSize = 1, name = "PO_HDR_SEQ")
	@Column(name="PO_NUM")
	private  String id;
	
	@Column(name="PO_TYPE")
	private  String type ;
	
	@Column(name="PO_STATUS")
	private  String status ;
	
	@Column(name="USER_1")
	private  String submitter ;
	
	@Column(name="FIN_YEAR")
	private  String finnacialYear ;
	
	@Column(name="DATE_1")
	private  Date createDate ;
	
	@Column(name="PO_DATE")
	private  Date poDate ;
	
	@Column(name="APPROVER_LEVEL_FIRST")
	private  String approverFirst ;
	@Column(name="APPROVER_LEVEL_SECOND")
	private  String approverSecond ;
	
	@Column(name="APPROVE_LEVEL_FIRST_DATE")
	private  Date approveFirstDate ;
	@Column(name="APPROVE_LEVEL_SECOND_DATE")
	private  Date approveSecondDate ;
	
	@Column(name="FOOTER_NOTE")
	private  String footerNote ;
	
	@Column(name="SUPP_CODE")
	private  String supplierId ;
	
	@Column(name="COOMPANY_CODE")
	private  String companyCode ;
	
	@Column(name="MUKAM")
	private  String mukam ;
	
	@Column(name="DELIVERY_ADDR")
	private  String deliveryAddress ;
	
	@Column(name="TAX", nullable = true)
	private  float tax ;
	
	@Column(name="PO_VAL_WT_TAX", nullable = true)
	private  float valueWithTax ;
	
	@Column(name="PO_VAL_WO_TAX", nullable = true)
	private  float valueWithoutTax ;
	
	
	@Column(name="DISCOUNT", nullable = true)
	private  float discount ;
	
	@Column(name="FRIEGHT_CHARGE", nullable = true)
	private  float frieghtCharge ;
	
	@Column(name="DELIVERY_TIMELINE")
	private  String  deliveryTimeline ;
	
	@Column(name="JUTE_UNIT")
	private  String  juteUnit ;
	
	@Column(name="VEHICLE_TYPE_ID", nullable = true)
	private  long vehicleTypeId ;
	
	@Column(name="VEHICLE_QUANTITY", nullable = true)
	private  long vehicleQuantity ;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="MOD_ON")
	private Date modOn;

	
	
	public Date getModOn() {
		return modOn;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(long vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public long getVehicleQuantity() {
		return vehicleQuantity;
	}

	public void setVehicleQuantity(long vehicleQuantity) {
		this.vehicleQuantity = vehicleQuantity;
	}

	public String getJuteUnit() {
		return juteUnit;
	}

	public void setJuteUnit(String juteUnit) {
		this.juteUnit = juteUnit;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getFrieghtCharge() {
		return frieghtCharge;
	}

	public void setFrieghtCharge(float frieghtCharge) {
		this.frieghtCharge = frieghtCharge;
	}

	public String getDeliveryTimeline() {
		return deliveryTimeline;
	}

	public void setDeliveryTimeline(String deliveryTimeline) {
		this.deliveryTimeline = deliveryTimeline;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getFinnacialYear() {
		return finnacialYear;
	}

	public void setFinnacialYear(String finnacialYear) {
		this.finnacialYear = finnacialYear;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public String getApproverFirst() {
		return approverFirst;
	}

	public void setApproverFirst(String approverFirst) {
		this.approverFirst = approverFirst;
	}

	public String getApproverSecond() {
		return approverSecond;
	}

	public void setApproverSecond(String approverSecond) {
		this.approverSecond = approverSecond;
	}

	public Date getApproveFirstDate() {
		return approveFirstDate;
	}

	public void setApproveFirstDate(Date approveFirstDate) {
		this.approveFirstDate = approveFirstDate;
	}

	public Date getApproveSecondDate() {
		return approveSecondDate;
	}

	public void setApproveSecondDate(Date approveSecondDate) {
		this.approveSecondDate = approveSecondDate;
	}

	public String getFooterNote() {
		return footerNote;
	}

	public void setFooterNote(String footerNote) {
		this.footerNote = footerNote;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getMukam() {
		return mukam;
	}

	public void setMukam(String mukam) {
		this.mukam = mukam;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getValueWithTax() {
		return valueWithTax;
	}

	public void setValueWithTax(float valueWithTax) {
		this.valueWithTax = valueWithTax;
	}

	public float getValueWithoutTax() {
		return valueWithoutTax;
	}

	public void setValueWithoutTax(float valueWithoutTax) {
		this.valueWithoutTax = valueWithoutTax;
	}
	
	
	


}
