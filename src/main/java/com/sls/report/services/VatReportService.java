package com.sls.report.services;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sls.report.dto.VatDetailReportDTO;
import com.sls.report.dto.VatReportSummaryDTO;
import com.sls.report.dto.VatReportWithRespectToGstDTO;
import com.sls.report.dto.VatSummaryReportDTO;

@Service
public interface VatReportService {

	public List<VatReportWithRespectToGstDTO> getVatReportWithRespectToGstDTO(Date startDate, Date endDate);
	public List<VatDetailReportDTO> getVatDetailReportDTO(Date startDate, Date endDate);
	public List<VatSummaryReportDTO> getVatSummaryReport(Date startDate, Date endDate);
	public List<VatSummaryReportDTO> getVatSummaryReport1(Date startDate, Date endDate);
	public VatReportSummaryDTO getVatReportSummary(Date startDate, Date endDate);
}
