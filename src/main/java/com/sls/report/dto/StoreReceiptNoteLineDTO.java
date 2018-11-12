package com.sls.report.dto;

public class StoreReceiptNoteLineDTO {

	private String itemCodeUnit;
	private String itemDescMake;
	private long quantity;
	private long rate;
	private long amount;
	
	
	public String getItemCodeUnit() {
		return itemCodeUnit;
	}
	public void setItemCodeUnit(String itemCodeUnit) {
		this.itemCodeUnit = itemCodeUnit;
	}
	public String getItemDescMake() {
		return itemDescMake;
	}
	public void setItemDescMake(String itemDescMake) {
		this.itemDescMake = itemDescMake;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getRate() {
		return rate;
	}
	public void setRate(long rate) {
		this.rate = rate;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
}
