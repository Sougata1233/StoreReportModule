package com.sls.report.dto;

import java.sql.Date;
import java.util.List;

public class OrderRegisterForHODTO {

	private String orderNo;
	private String partyName;
	private String partyCode;
	private Date orderDate;
	private String rejNote;
	private float rejQty;
	private String deliverSchedule;
	private long challanNo;
	private Date challanDate;
	private long challanQnty;
	private long srNo;
	private Date srDate;
	private long srQty;
	
	private List<OrderRegisterLineItemForHODTO> orderregisLineitems;
	
	
	
	public List<OrderRegisterLineItemForHODTO> getOrderregisLineitems() {
		return orderregisLineitems;
	}
	public void setOrderregisLineitems(List<OrderRegisterLineItemForHODTO> orderregisLineitems) {
		this.orderregisLineitems = orderregisLineitems;
	}
	public String getRejNote() {
		return rejNote;
	}
	public void setRejNote(String rejNote) {
		this.rejNote = rejNote;
	}
	public float getRejQty() {
		return rejQty;
	}
	public void setRejQty(float rejQty) {
		this.rejQty = rejQty;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getPartyCode() {
		return partyCode;
	}
	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliverSchedule() {
		return deliverSchedule;
	}
	public void setDeliverSchedule(String deliverSchedule) {
		this.deliverSchedule = deliverSchedule;
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
	public long getChallanQnty() {
		return challanQnty;
	}
	public void setChallanQnty(long challanQnty) {
		this.challanQnty = challanQnty;
	}
	public long getSrNo() {
		return srNo;
	}
	public void setSrNo(long srNo) {
		this.srNo = srNo;
	}
	public Date getSrDate() {
		return srDate;
	}
	public void setSrDate(Date srDate) {
		this.srDate = srDate;
	}
	public long getSrQty() {
		return srQty;
	}
	public void setSrQty(long srQty) {
		this.srQty = srQty;
	}
	
	
	
	
}
