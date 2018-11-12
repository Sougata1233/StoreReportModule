package com.sls.report.dto;

public class StoresMonthlyConsumptionReportDTO {

	private String department;
	private long costCenter;
	private long capital;
	private String maintainance;
	private String overHauling;
	private String general;
	private double totalCost;
	private double lmCost;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public long getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(long costCenter) {
		this.costCenter = costCenter;
	}
	public long getCapital() {
		return capital;
	}
	public void setCapital(long capital) {
		this.capital = capital;
	}
	public String getMaintainance() {
		return maintainance;
	}
	public void setMaintainance(String maintainance) {
		this.maintainance = maintainance;
	}
	public String getOverHauling() {
		return overHauling;
	}
	public void setOverHauling(String overHauling) {
		this.overHauling = overHauling;
	}
	public String getGeneral() {
		return general;
	}
	public void setGeneral(String general) {
		this.general = general;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public double getLmCost() {
		return lmCost;
	}
	public void setLmCost(double lmCost) {
		this.lmCost = lmCost;
	}
	
	
	
	
}
