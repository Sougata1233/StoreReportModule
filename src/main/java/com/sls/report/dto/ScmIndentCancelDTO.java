package com.sls.report.dto;

import java.sql.Date;

public class ScmIndentCancelDTO {

	private long cancelQnt;
	private long cancelNo;
	private Date cancellationDate;
	private long outstQnt;
	
	
	
	public long getOutstQnt() {
		return outstQnt;
	}
	public void setOutstQnt(long outstQnt) {
		this.outstQnt = outstQnt;
	}
	public long getCancelQnt() {
		return cancelQnt;
	}
	public void setCancelQnt(long cancelQnt) {
		this.cancelQnt = cancelQnt;
	}
	public long getCancelNo() {
		return cancelNo;
	}
	public void setCancelNo(long cancelNo) {
		this.cancelNo = cancelNo;
	}
	public Date getCancellationDate() {
		return cancellationDate;
	}
	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}
	
	
	
	
}
