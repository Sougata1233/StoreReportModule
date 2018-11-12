package com.sls.report.services;

import java.sql.Date;
import java.util.List;

import com.sls.report.dto.CancelledIndentDTO;
import com.sls.report.dto.IndentCancelRegisterDTO;
import com.sls.report.dto.IndentDetailsReportNumberWiseDTO;
import com.sls.report.dto.IndentSummaryReportWaitingForPODTO;
import com.sls.report.dto.OutstandingIndentReportDTO;

public interface IndentService {

	List<CancelledIndentDTO> getAllCancelledIndentReport(String indentNo);
	public List<IndentCancelRegisterDTO> getAllIndentCancelRegister(Date startDate, Date endDate);
	
	List<IndentDetailsReportNumberWiseDTO> getAllIndentDetailsReportItemWise(Date startDate, Date endDate);
	List<IndentDetailsReportNumberWiseDTO> getAllIndentDetailsReport(Date startDate, Date endDate);
	List<IndentDetailsReportNumberWiseDTO> getAllIndentDetailsReportNumberWise(Date startDate, Date endDate);
	
	List<OutstandingIndentReportDTO> getAllOutstandingIndentReport(Date startDate, Date endDate);
	List<OutstandingIndentReportDTO> getAllOutstandingIndentReportItemWise(Date startDate);
	List<OutstandingIndentReportDTO> getAllOutstandingIndentReportDeptWise(Date startDate);
	List<OutstandingIndentReportDTO> getAllOutstandingIndentReportGroupWise(Date startDate, Date endDate, String group);
	
	List<IndentSummaryReportWaitingForPODTO> getAllIndentSummaryReportWaitingForPO(Date indentDate);
	
}
