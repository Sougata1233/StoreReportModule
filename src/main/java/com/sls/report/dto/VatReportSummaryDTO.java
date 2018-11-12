package com.sls.report.dto;

public class VatReportSummaryDTO {

	private String tax5;
	private String tax9;
	private String tax12;
	private String tax18;
	private String tax28;

	public String getTax5() {
		return tax5;
	}
	public void setTax5(String tax5) {
		this.tax5 = tax5;
	}
	
	public String getTax9() {
		return tax9;
	}
	public void setTax9(String tax9) {
		this.tax9 = tax9;
	}
	public String getTax12() {
		return tax12;
	}
	public void setTax12(String tax12) {
		this.tax12 = tax12;
	}
	public String getTax18() {
		return tax18;
	}
	public void setTax18(String tax18) {
		this.tax18 = tax18;
	}
	public String getTax28() {
		return tax28;
	}
	public void setTax28(String tax28) {
		this.tax28 = tax28;
	}
	@Override
	public String toString() {
		return "VatReportSummaryDTO [tax5=" + tax5 + ", tax9=" + tax9 + ", tax12=" + tax12 + ", tax18=" + tax18
				+ ", tax28=" + tax28 + "]";
	}
	
}
