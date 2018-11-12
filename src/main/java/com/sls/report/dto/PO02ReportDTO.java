package com.sls.report.dto;

import java.util.List;

public class PO02ReportDTO {

	private String itemCode;
	private String description;
	private String unit;
	private String make;
	
	private List<PO02ReportLineDTO> lines;
	
	
	
	public List<PO02ReportLineDTO> getLines() {
		return lines;
	}
	public void setLines(List<PO02ReportLineDTO> lines) {
		this.lines = lines;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	
}
