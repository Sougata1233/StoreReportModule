package com.sls.report.dto;

import java.sql.Date;
import java.util.List;

public class StoreReceiptNoteReportDTO {

	private String pono;
	private long srno;
	private Date date;
	private Date srDate;
	private Date inDate;
	private long challanNo;
	private Date chalanDate;
	private String rNote;
	private double grossAmount;
	private double discount;
	private double excise;
	private double vat;
	private double surCharge;
	private String delivery;
	private double totalDed;
	private long round;
	private double netAmount;
	
	private List<StoreReceiptNoteLineDTO> lines;
	
	
	
	public List<StoreReceiptNoteLineDTO> getLines() {
		return lines;
	}
	public void setLines(List<StoreReceiptNoteLineDTO> lines) {
		this.lines = lines;
	}
	public String getPono() {
		return pono;
	}
	public void setPono(String pono) {
		this.pono = pono;
	}
	public long getSrno() {
		return srno;
	}
	public void setSrno(long srno) {
		this.srno = srno;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getSrDate() {
		return srDate;
	}
	public void setSrDate(Date srDate) {
		this.srDate = srDate;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public long getChallanNo() {
		return challanNo;
	}
	public void setChallanNo(long challanNo) {
		this.challanNo = challanNo;
	}
	public Date getChalanDate() {
		return chalanDate;
	}
	public void setChalanDate(Date chalanDate) {
		this.chalanDate = chalanDate;
	}
	public String getrNote() {
		return rNote;
	}
	public void setrNote(String rNote) {
		this.rNote = rNote;
	}
	public double getGrossAmount() {
		return grossAmount;
	}
	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getExcise() {
		return excise;
	}
	public void setExcise(double excise) {
		this.excise = excise;
	}
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}
	public double getSurCharge() {
		return surCharge;
	}
	public void setSurCharge(double surCharge) {
		this.surCharge = surCharge;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public double getTotalDed() {
		return totalDed;
	}
	public void setTotalDed(double totalDed) {
		this.totalDed = totalDed;
	}
	public long getRound() {
		return round;
	}
	public void setRound(long round) {
		this.round = round;
	}
	public double getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}
	
	
}
