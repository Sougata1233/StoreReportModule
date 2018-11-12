package com.sls.report.dto;

import java.sql.Date;
import java.util.List;

public class IndentCancelRegisterDTO {

	private Date date;
	private String cancelNO;
	private String finYear;
	private String reason;
	private String indentNO;
	
	private List<CancelledIndentDTO> cancelDTO;
	
	
	
	
	public String getIndentNO() {
		return indentNO;
	}
	public void setIndentNO(String indentNO) {
		this.indentNO = indentNO;
	}
	public List<CancelledIndentDTO> getCancelDTO() {
		return cancelDTO;
	}
	public void setCancelDTO(List<CancelledIndentDTO> cancelDTO) {
		this.cancelDTO = cancelDTO;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCancelNO() {
		return cancelNO;
	}
	public void setCancelNO(String cancelNO) {
		this.cancelNO = cancelNO;
	}
	public String getFinYear() {
		return finYear;
	}
	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	
}
