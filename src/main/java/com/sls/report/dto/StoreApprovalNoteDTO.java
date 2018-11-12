package com.sls.report.dto;

import java.sql.Date;
import java.util.List;

public class StoreApprovalNoteDTO {

	private long challanNO;
	private String pCode;
	private Date poDate;
	private Date inDate;
	private Date chalandate;
	private String dept;
	private String cNoteNo;
	private String approvalNo;
	private long inwardno;
	
	List<StoreApprovalLineIteDTO> storeApprovalLineItemDTOs;

	public long getChallanNO() {
		return challanNO;
	}

	public void setChallanNO(long challanNO) {
		this.challanNO = challanNO;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getChalandate() {
		return chalandate;
	}

	public void setChalandate(Date chalandate) {
		this.chalandate = chalandate;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getcNoteNo() {
		return cNoteNo;
	}

	public void setcNoteNo(String cNoteNo) {
		this.cNoteNo = cNoteNo;
	}

	public String getApprovalNo() {
		return approvalNo;
	}

	public void setApprovalNo(String approvalNo) {
		this.approvalNo = approvalNo;
	}

	public long getInwardno() {
		return inwardno;
	}

	public void setInwardno(long inwardno) {
		this.inwardno = inwardno;
	}

	public List<StoreApprovalLineIteDTO> getStoreApprovalLineItemDTOs() {
		return storeApprovalLineItemDTOs;
	}

	public void setStoreApprovalLineItemDTOs(List<StoreApprovalLineIteDTO> storeApprovalLineItemDTOs) {
		this.storeApprovalLineItemDTOs = storeApprovalLineItemDTOs;
	}

	
}
