package com.sls.report.dto;

import java.sql.Date;
import java.util.List;

public class HOStoresReceiptCumBillPassReportDTO {

	private long srNo;
	private Date date1;
	private long inwardNo;
	private Date date;
	private String partyName;
	private String orderNo;
	private String billNoDetails;
	private String sign;
	private List<POLineItemDTO> lineitems;
	
	
	
	
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public long getSrNo() {
		return srNo;
	}
	public void setSrNo(long srNo) {
		this.srNo = srNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getInwardNo() {
		return inwardNo;
	}
	public void setInwardNo(long inwardNo) {
		this.inwardNo = inwardNo;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getBillNoDetails() {
		return billNoDetails;
	}
	public void setBillNoDetails(String billNoDetails) {
		this.billNoDetails = billNoDetails;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public List<POLineItemDTO> getLineitems() {
		return lineitems;
	}
	public void setLineitems(List<POLineItemDTO> lineitems) {
		this.lineitems = lineitems;
	}
	@Override
	public String toString() {
		return "HOStoresReceiptCumBillPassReportDTO [srNo=" + srNo + ", date=" + date + ", inwardNo=" + inwardNo
				+ ", inwardDate=" + ", partyName=" + partyName + ", orderNo=" + orderNo + ", itemCode="
				+  ", amount=" + ", billNoDetails=" + billNoDetails + ", sign=" + sign
				+ ", lineitems=" + lineitems + "]";
	}
	public HOStoresReceiptCumBillPassReportDTO(long srNo, Date date, long inwardNo, String partyName,
			String orderNo,  long amount, String billNoDetails, String sign,
			List<POLineItemDTO> lineitems) {
		super();
		this.srNo = srNo;
		this.date = date;
		this.inwardNo = inwardNo;
		this.partyName = partyName;
		this.orderNo = orderNo;
		this.billNoDetails = billNoDetails;
		this.sign = sign;
		this.lineitems = lineitems;
	}
	public HOStoresReceiptCumBillPassReportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
