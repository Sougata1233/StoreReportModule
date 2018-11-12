package com.sls.report.dto;

import java.sql.Date;

public class BillPassDTO {

	private String billNO;
	private Date billDate;
	public String getBillNO() {
		return billNO;
	}
	public void setBillNO(String billNO) {
		this.billNO = billNO;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	
	
	
}
