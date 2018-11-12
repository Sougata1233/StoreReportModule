package com.sls.report.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SCM_SR_LINE_ITEM")
public class ScmSrLineItem {
	
	@Id
	@Column(name="STORE_LINE_ITEM_NO")
	private long lineitemno;
	
	@Column(name="STORE_LINE_ITEM_DETAILS")
	private String lineitemdetails;
	
	@Column(name="STORE_RECEIVE_NO", nullable = true)
	private long storeReceiveNo;
	
	@Column(name="ADDITIONAL_REQUIREMENT")
	private String additionalReq;
	
	@Column(name="ADVISED_QUANTITY", nullable = true)
	private long advisedQnt;
	
	@Column(name="ACTUAL_QUANTITY", nullable = true)
	private long actualQnt;
	
	@Column(name="DEVIATION", nullable = true)
	private long deviation;
	
	@Column(name="ORDERED_PRICE", nullable = true)
	private long orderedPrice;
	
	@Column(name="RECEIVED_PRICE", nullable = true)
	private long receivedPrice;
	
	@Column(name="CLAIMS")
	private String claims;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="RECEIVE_DATE")
	private Date receivedDate;
	
	@Column(name="STORE_ID", nullable = true)
	private long storeId;
	
	@Column(name="FLOOR", nullable = true)
	private long floor;
	
	@Column(name="ROOM", nullable = true)
	private long room;
	
	@Column(name="RACK", nullable = true)
	private long rack;
	
	@Column(name="POSITION", nullable = true)
	private long position;
	
	@Column(name="EXPIRY_DATE")
	private Date expiryDate;
	
	@Column(name="BATCH_NO", nullable = true)
	private long batchNo;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="DR_NOTE")
	private String drNote;
	
	@Column(name="CR_NOTE")
	private String crNote;
	
	@Column(name="DR_DATE")
	private Date drDate;
	
	@Column(name="CR_DATE")
	private Date crDate;
	
	@Column(name="UOM_CODE")
	private String uom;
	
	@Column(name="DEBIT_CREDIT_NOTES_FLAG")
	private String debitCreditNoteFlag;
	
	@Column(name="APPROVER_LEVEL_FIRST")
	private String approverLevelFirst;
	
	@Column(name="APPROVER_LEVEL_SECOND")
	private String approverLevelSecond;
	
	@Column(name="APPROVE_LEVEL_FIRST_DATE")
	private Date approverLevelFirstDate;
	
	@Column(name="APPROVE_LEVEL_SECOND_DATE")
	private Date approverLevelSecondDate;
	
	@Column(name="ISSUABLE_QUANTITY", nullable = true)
	private long issuableQnt;
	
	
	public long getLineitemno() {
		return lineitemno;
	}

	public void setLineitemno(long lineitemno) {
		this.lineitemno = lineitemno;
	}

	public String getLineitemdetails() {
		return lineitemdetails;
	}

	public void setLineitemdetails(String lineitemdetails) {
		this.lineitemdetails = lineitemdetails;
	}

	public long getStoreReceiveNo() {
		return storeReceiveNo;
	}

	public void setStoreReceiveNo(long storeReceiveNo) {
		this.storeReceiveNo = storeReceiveNo;
	}

	public String getAdditionalReq() {
		return additionalReq;
	}

	public void setAdditionalReq(String additionalReq) {
		this.additionalReq = additionalReq;
	}

	public long getAdvisedQnt() {
		return advisedQnt;
	}

	public void setAdvisedQnt(long advisedQnt) {
		this.advisedQnt = advisedQnt;
	}

	public long getActualQnt() {
		return actualQnt;
	}

	public void setActualQnt(long actualQnt) {
		this.actualQnt = actualQnt;
	}

	public long getDeviation() {
		return deviation;
	}

	public void setDeviation(long deviation) {
		this.deviation = deviation;
	}

	public long getOrderedPrice() {
		return orderedPrice;
	}

	public void setOrderedPrice(long orderedPrice) {
		this.orderedPrice = orderedPrice;
	}

	public long getReceivedPrice() {
		return receivedPrice;
	}

	public void setReceivedPrice(long receivedPrice) {
		this.receivedPrice = receivedPrice;
	}

	public String getClaims() {
		return claims;
	}

	public void setClaims(String claims) {
		this.claims = claims;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public long getFloor() {
		return floor;
	}

	public void setFloor(long floor) {
		this.floor = floor;
	}

	public long getRoom() {
		return room;
	}

	public void setRoom(long room) {
		this.room = room;
	}

	public long getRack() {
		return rack;
	}

	public void setRack(long rack) {
		this.rack = rack;
	}

	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public long getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(long batchNo) {
		this.batchNo = batchNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDrNote() {
		return drNote;
	}

	public void setDrNote(String drNote) {
		this.drNote = drNote;
	}

	public String getCrNote() {
		return crNote;
	}

	public void setCrNote(String crNote) {
		this.crNote = crNote;
	}

	public Date getDrDate() {
		return drDate;
	}

	public void setDrDate(Date drDate) {
		this.drDate = drDate;
	}

	public Date getCrDate() {
		return crDate;
	}

	public void setCrDate(Date crDate) {
		this.crDate = crDate;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getDebitCreditNoteFlag() {
		return debitCreditNoteFlag;
	}

	public void setDebitCreditNoteFlag(String debitCreditNoteFlag) {
		this.debitCreditNoteFlag = debitCreditNoteFlag;
	}

	public String getApproverLevelFirst() {
		return approverLevelFirst;
	}

	public void setApproverLevelFirst(String approverLevelFirst) {
		this.approverLevelFirst = approverLevelFirst;
	}

	public String getApproverLevelSecond() {
		return approverLevelSecond;
	}

	public void setApproverLevelSecond(String approverLevelSecond) {
		this.approverLevelSecond = approverLevelSecond;
	}

	public Date getApproverLevelFirstDate() {
		return approverLevelFirstDate;
	}

	public void setApproverLevelFirstDate(Date approverLevelFirstDate) {
		this.approverLevelFirstDate = approverLevelFirstDate;
	}

	public Date getApproverLevelSecondDate() {
		return approverLevelSecondDate;
	}

	public void setApproverLevelSecondDate(Date approverLevelSecondDate) {
		this.approverLevelSecondDate = approverLevelSecondDate;
	}

	public long getIssuableQnt() {
		return issuableQnt;
	}

	public void setIssuableQnt(long issuableQnt) {
		this.issuableQnt = issuableQnt;
	}

	@Override
	public String toString() {
		return "ScmSrLineItem [lineitemno=" + lineitemno + ", lineitemdetails=" + lineitemdetails + ", storeReceiveNo="
				+ storeReceiveNo + ", additionalReq=" + additionalReq + ", advisedQnt=" + advisedQnt + ", actualQnt="
				+ actualQnt + ", deviation=" + deviation + ", orderedPrice=" + orderedPrice + ", receivedPrice="
				+ receivedPrice + ", claims=" + claims + ", remarks=" + remarks + ", receivedDate=" + receivedDate
				+ ", storeId=" + storeId + ", floor=" + floor + ", room=" + room + ", rack=" + rack + ", position="
				+ position + ", expiryDate=" + expiryDate + ", batchNo=" + batchNo + ", status=" + status + ", drNote="
				+ drNote + ", crNote=" + crNote + ", drDate=" + drDate + ", crDate=" + crDate + ", uom=" + uom
				+ ", debitCreditNoteFlag=" + debitCreditNoteFlag + ", approverLevelFirst=" + approverLevelFirst
				+ ", approverLevelSecond=" + approverLevelSecond + ", approverLevelFirstDate=" + approverLevelFirstDate
				+ ", approverLevelSecondDate=" + approverLevelSecondDate + ", issuableQnt=" + issuableQnt + "]";
	}

	public ScmSrLineItem(long lineitemno, String lineitemdetails, long storeReceiveNo, String additionalReq,
			long advisedQnt, long actualQnt, long deviation, long orderedPrice, long receivedPrice, String claims,
			String remarks, Date receivedDate, long storeId, long floor, long room, long rack, long position,
			Date expiryDate, long batchNo, String status, String drNote, String crNote, Date drDate, Date crDate,
			String uom, String debitCreditNoteFlag, String approverLevelFirst, String approverLevelSecond,
			Date approverLevelFirstDate, Date approverLevelSecondDate, long issuableQnt) {
		super();
		this.lineitemno = lineitemno;
		this.lineitemdetails = lineitemdetails;
		this.storeReceiveNo = storeReceiveNo;
		this.additionalReq = additionalReq;
		this.advisedQnt = advisedQnt;
		this.actualQnt = actualQnt;
		this.deviation = deviation;
		this.orderedPrice = orderedPrice;
		this.receivedPrice = receivedPrice;
		this.claims = claims;
		this.remarks = remarks;
		this.receivedDate = receivedDate;
		this.storeId = storeId;
		this.floor = floor;
		this.room = room;
		this.rack = rack;
		this.position = position;
		this.expiryDate = expiryDate;
		this.batchNo = batchNo;
		this.status = status;
		this.drNote = drNote;
		this.crNote = crNote;
		this.drDate = drDate;
		this.crDate = crDate;
		this.uom = uom;
		this.debitCreditNoteFlag = debitCreditNoteFlag;
		this.approverLevelFirst = approverLevelFirst;
		this.approverLevelSecond = approverLevelSecond;
		this.approverLevelFirstDate = approverLevelFirstDate;
		this.approverLevelSecondDate = approverLevelSecondDate;
		this.issuableQnt = issuableQnt;
	}

	public ScmSrLineItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
