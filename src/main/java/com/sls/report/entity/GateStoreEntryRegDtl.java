package com.sls.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="GATE_STORE_ENTRY_REG_DTL")
public class GateStoreEntryRegDtl {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GATE_STORE_ENTRY_REG_DTL_SEQ")
//	@SequenceGenerator(name="GATE_STORE_ENTRY_REG_DTL_SEQ", sequenceName="GATE_STORE_ENTRY_REG_DTL_SEQ")
	@Column(name="DTL_ID", nullable = true)
	private long dtlId;
	
	@Column(name="HDR_ID", nullable = true)
	private long hdrId;
	
	@Column(name="SRL_NO", nullable = true)
	private long srlNo;
	
	@Column(name="QUANTITY", nullable = true)
	private long quantity;
	
	@Column(name="DEPT")
	private String dept;
	
	@Column(name="OPEN_CLOSE")
	private String openClose;
	
	@Column(name="UOM")
	private String uom;
	
	@Column(name="ITEM_CODE")
	private String itemCode;
	
	@Column(name="ITEM_DESC")
	private String itemDesc;
	
	@Column(name="REQ_QUANTITY", nullable = true)
	private long reqQuantity;

	public long getDtlId() {
		return dtlId;
	}

	public void setDtlId(long dtlId) {
		this.dtlId = dtlId;
	}

	public long getHdrId() {
		return hdrId;
	}

	public void setHdrId(long hdrId) {
		this.hdrId = hdrId;
	}

	public long getSrlNo() {
		return srlNo;
	}

	public void setSrlNo(long srlNo) {
		this.srlNo = srlNo;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getOpenClose() {
		return openClose;
	}

	public void setOpenClose(String openClose) {
		this.openClose = openClose;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
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

	public long getReqQuantity() {
		return reqQuantity;
	}

	public void setReqQuantity(long reqQuantity) {
		this.reqQuantity = reqQuantity;
	}

	@Override
	public String toString() {
		return "GateStoreEntryRegDtl [dtlId=" + dtlId + ", hdrId=" + hdrId + ", srlNo=" + srlNo + ", item=" 
				+ ", quantity=" + quantity + ", dept=" + dept + ", openClose=" + openClose + ", uom=" + uom
				+ ", itemCode=" + itemCode + ", itemDesc=" + itemDesc + ", reqQuantity=" + reqQuantity + "]";
	}

	public GateStoreEntryRegDtl(long dtlId, long hdrId, long srlNo, String item, long quantity, String dept,
			String openClose, String uom, String itemCode, String itemDesc, long reqQuantity) {
		super();
		this.dtlId = dtlId;
		this.hdrId = hdrId;
		this.srlNo = srlNo;
		this.quantity = quantity;
		this.dept = dept;
		this.openClose = openClose;
		this.uom = uom;
		this.itemCode = itemCode;
		this.itemDesc = itemDesc;
		this.reqQuantity = reqQuantity;
	}

	public GateStoreEntryRegDtl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
