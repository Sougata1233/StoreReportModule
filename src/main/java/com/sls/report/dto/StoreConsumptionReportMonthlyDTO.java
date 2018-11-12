package com.sls.report.dto;

public class StoreConsumptionReportMonthlyDTO {

	private String department;
	private String costCenter;
	private String capital;
	private String maintainance;
	private String production;
	private String overhauling;
	private String general;
	private String total;
	private String lmcost;
	
	
	public String getGeneral() {
		return general;
	}
	public void setGeneral(String general) {
		this.general = general;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getMaintainance() {
		return maintainance;
	}
	public void setMaintainance(String maintainance) {
		this.maintainance = maintainance;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public String getOverhauling() {
		return overhauling;
	}
	public void setOverhauling(String overhauling) {
		this.overhauling = overhauling;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getLmcost() {
		return lmcost;
	}
	public void setLmcost(String lmcost) {
		this.lmcost = lmcost;
	}
	
}
