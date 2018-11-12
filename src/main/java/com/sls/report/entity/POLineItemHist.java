package com.sls.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SCM_PO_LINE_ITEM_HIST")
public class POLineItemHist {

	@Id
	@Column(name="AMMENDMENT_NO")
	private long ammendNo;
	
	@Column(name="LINE_ITEM_NUM", nullable = true)
	private long lineItemNum;
	
	@Column(name="PO_NUM")
	private String poNum;

	public long getAmmendNo() {
		return ammendNo;
	}

	public void setAmmendNo(long ammendNo) {
		this.ammendNo = ammendNo;
	}

	public long getLineItemNum() {
		return lineItemNum;
	}

	public void setLineItemNum(long lineItemNum) {
		this.lineItemNum = lineItemNum;
	}

	public String getPoNum() {
		return poNum;
	}

	public void setPoNum(String poNum) {
		this.poNum = poNum;
	}
	
	
	
	
}
