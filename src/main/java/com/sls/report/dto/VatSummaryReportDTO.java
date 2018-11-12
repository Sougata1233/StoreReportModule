package com.sls.report.dto;

public class VatSummaryReportDTO {

	private String vatPercentage;
	private String vatAmt5;
	private String vatAmt9;
	private String vatAmt18;
	private String vatAmt28;
	private String grossAmt5;
	private String grossAmt9;
	private String grossAmt18;
	private String grossAmt28;
	public String getVatPercentage() {
		return vatPercentage;
	}
	public void setVatPercentage(String vatPercentage) {
		this.vatPercentage = vatPercentage;
	}
	public String getVatAmt5() {
		return vatAmt5;
	}
	public void setVatAmt5(String vatAmt5) {
		this.vatAmt5 = vatAmt5;
	}
	public String getVatAmt9() {
		return vatAmt9;
	}
	public void setVatAmt9(String vatAmt9) {
		this.vatAmt9 = vatAmt9;
	}
	public String getVatAmt18() {
		return vatAmt18;
	}
	public void setVatAmt18(String vatAmt18) {
		this.vatAmt18 = vatAmt18;
	}
	public String getVatAmt28() {
		return vatAmt28;
	}
	public void setVatAmt28(String vatAmt28) {
		this.vatAmt28 = vatAmt28;
	}
	public String getGrossAmt5() {
		return grossAmt5;
	}
	public void setGrossAmt5(String grossAmt5) {
		this.grossAmt5 = grossAmt5;
	}
	public String getGrossAmt9() {
		return grossAmt9;
	}
	public void setGrossAmt9(String grossAmt9) {
		this.grossAmt9 = grossAmt9;
	}
	public String getGrossAmt18() {
		return grossAmt18;
	}
	public void setGrossAmt18(String grossAmt18) {
		this.grossAmt18 = grossAmt18;
	}
	public String getGrossAmt28() {
		return grossAmt28;
	}
	public void setGrossAmt28(String grossAmt28) {
		this.grossAmt28 = grossAmt28;
	}
	@Override
	public String toString() {
		return "VatSummaryReportDTO [vatPercentage=" + vatPercentage + ", vatAmt5=" + vatAmt5 + ", vatAmt9=" + vatAmt9
				+ ", vatAmt18=" + vatAmt18 + ", vatAmt28=" + vatAmt28 + ", grossAmt5=" + grossAmt5 + ", grossAmt9="
				+ grossAmt9 + ", grossAmt18=" + grossAmt18 + ", grossAmt28=" + grossAmt28 + "]";
	}
	
}
