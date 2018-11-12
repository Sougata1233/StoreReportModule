package com.sls.report.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sls.report.dto.VatDetailReportDTO;
import com.sls.report.dto.VatReportSummaryDTO;
import com.sls.report.dto.VatReportWithRespectToGstDTO;
import com.sls.report.dto.VatSummaryReportDTO;
import com.sls.report.services.VatReportService;

@RestController
@RequestMapping("storereport/")
public class VatReportController {

	@Autowired
	VatReportService reportService;

	@GetMapping("getvatreportgst/{startDate}/{endDate}")
	public List<VatReportWithRespectToGstDTO> getVatReportWithRespectToGst(@PathVariable("startDate") Date startDate,
			@PathVariable("endDate") Date endDate) {
		return reportService.getVatReportWithRespectToGstDTO(startDate, endDate);
	}
	
	@GetMapping("getvatdetailreport/{startDate}/{endDate}")
	public List<VatDetailReportDTO> getVatDetailReport(@PathVariable("startDate") Date startDate,
			@PathVariable("endDate") Date endDate) {
		return reportService.getVatDetailReportDTO(startDate, endDate);
	}
	
	@GetMapping("getvatsummaryreport/{startDate}/{endDate}")
	public List<VatSummaryReportDTO> getVatSummaryReport(@PathVariable("startDate") Date startDate,
			@PathVariable("endDate") Date endDate) {
		return reportService.getVatSummaryReport(startDate, endDate);
	}
	
	@GetMapping("getvatreportsummary/{startDate}/{endDate}")
	public VatReportSummaryDTO getVatReportSummary(@PathVariable("startDate") Date startDate,
			@PathVariable("endDate") Date endDate) {
		return reportService.getVatReportSummary(startDate, endDate);
	}

}
