package com.sls.report.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="GATE_STORE_ENTRY_REG_HDR")
public class GateStoreEntryRegHdr {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GATE_STORE_ENTRY_REG_HDR_SEQ")
	@SequenceGenerator(name="GATE_STORE_ENTRY_REG_HDR_SEQ", sequenceName="GATE_STORE_ENTRY_REG_HDR_SEQ")
	@Column(name="HDR_ID")
	private long hdrId;
	
	@Column(name="CHALLAN_NO", nullable = true)
	private long challanNo;
	
	@Column(name="CHALLAN_DATE")
	private Date challanDate;
	
	@Column(name="VEHICLE_NO")
	private String vehicleNo;
	
	@Column(name="DRIVER_NAME")
	private String driverName;
	
	@Column(name="SUPPLIER_NAME")
	private String supplierName;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="OPEN_CLOSE")
	private String openClose;
	
	@Column(name="IN_DATE")
	private Date inDate;
	
	@Column(name="IN_TIME")
	private Timestamp inTime;
	
	@Column(name="OUT_TIME")
	private Timestamp outTime;
	
	@Column(name="OUT_DATE")
	private Date outDate;
	
	@Column(name="UPDATE_BY")
	private String updateBy;
	
	@Column(name="UPDATE_DATE_TIME")
	private Timestamp updateDateTime;
	
	@Column(name="PO_NO")
	private String poNo;
	
	@Column(name="SUPP_CODE")
	private String suppCode;

	public long getHdrId() {
		return hdrId;
	}

	public void setHdrId(long hdrId) {
		this.hdrId = hdrId;
	}

	public long getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(long challanNo) {
		this.challanNo = challanNo;
	}

	public Date getChallanDate() {
		return challanDate;
	}

	public void setChallanDate(Date challanDate) {
		this.challanDate = challanDate;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getOpenClose() {
		return openClose;
	}

	public void setOpenClose(String openClose) {
		this.openClose = openClose;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Timestamp getInTime() {
		return inTime;
	}

	public void setInTime(Timestamp inTime) {
		this.inTime = inTime;
	}

	public Timestamp getOutTime() {
		return outTime;
	}

	public void setOutTime(Timestamp outTime) {
		this.outTime = outTime;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Timestamp getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Timestamp updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	@Override
	public String toString() {
		return "GateStoreEntryRegHdr [hdrId=" + hdrId + ", challanNo=" + challanNo + ", challanDate=" + challanDate
				+ ", vehicleNo=" + vehicleNo + ", driverName=" + driverName + ", supplierName=" + supplierName
				+ ", remarks=" + remarks + ", openClose=" + openClose + ", inDate=" + inDate + ", inTime=" + inTime
				+ ", outTime=" + outTime + ", outDate=" + outDate + ", updateBy=" + updateBy + ", updateDateTime="
				+ updateDateTime + ", poNo=" + poNo + ", suppCode=" + suppCode + "]";
	}

	public GateStoreEntryRegHdr(long hdrId, long challanNo, Date challanDate, String vehicleNo, String driverName,
			String supplierName, String remarks, String openClose, Date inDate, Timestamp inTime, Timestamp outTime,
			Date outDate, String updateBy, Timestamp updateDateTime, String poNo, String suppCode) {
		super();
		this.hdrId = hdrId;
		this.challanNo = challanNo;
		this.challanDate = challanDate;
		this.vehicleNo = vehicleNo;
		this.driverName = driverName;
		this.supplierName = supplierName;
		this.remarks = remarks;
		this.openClose = openClose;
		this.inDate = inDate;
		this.inTime = inTime;
		this.outTime = outTime;
		this.outDate = outDate;
		this.updateBy = updateBy;
		this.updateDateTime = updateDateTime;
		this.poNo = poNo;
		this.suppCode = suppCode;
	}

	public GateStoreEntryRegHdr() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
