package com.sls.report.services;

import java.sql.Date;
import java.util.List;

import com.sls.report.dto.GroupwiseConsumptionReportDTO;
import com.sls.report.dto.IS22SummaryReportDTO;
import com.sls.report.dto.IssueCheckListReportDTO;
import com.sls.report.dto.IssueConsumptionReportForMonthDTO;
import com.sls.report.dto.StoreConsumptionReportDTO;
import com.sls.report.dto.StoreConsumptionReportMonthlyDTO;
import com.sls.report.dto.StoreConsumptionSummaryReportDTO;
import com.sls.report.dto.StoreIssueReportDTO;
import com.sls.report.dto.StoreIssueReportIS19DTO;

public interface IssueReportService {

	public List<IssueCheckListReportDTO> getAllIssueCheckListReport(Date startDate, Date endDate);

	public List<IssueConsumptionReportForMonthDTO> getAllIssueConsumptionIncreasingReportForMonth(String date);

	public List<IssueConsumptionReportForMonthDTO> prepareIssueConsumptionDecreasingDTO(String date);

	public List<StoreConsumptionReportDTO> getAllStoreConsumptionReport(String startDate, String endDate);

	public List<StoreConsumptionReportDTO> getAllStoreConsumptionReportGroupWise(String grpCode, String startDate,
			String endDate);

	public List<StoreConsumptionReportDTO> getAllStoreConsumptionReportDepartmentWise(long deptCode, String startDate,
			String endDate);

	public List<IS22SummaryReportDTO> getAllStoreConsumptionSummaryReportGroupWise(String grpCode, String startDate,
			String endDate);

	public List<StoreIssueReportIS19DTO> getAllStoreIssueReportIS19(String startDate, String endDate);

	public List<StoreIssueReportDTO> getStoreIssueReportService(String startDate, String endDate);

	public List<StoreConsumptionSummaryReportDTO> getAllStoreConsumptionSummaryReport(String startDate, String endDate);
	
	public List<GroupwiseConsumptionReportDTO> getGroupwiseConsumptionReport(Date date);
	
	public List<StoreConsumptionReportMonthlyDTO> getStoreConsumptionReportMonthly(String yyyymm);
	
	public List<StoreConsumptionReportDTO> 
				getAllStoreConsumptionReportExpTypeWise(String startDate, String endDate, String expType);
}