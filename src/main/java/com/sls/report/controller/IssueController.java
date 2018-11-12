package com.sls.report.controller;

import static com.sls.report.constant.MasterManagementConstant.USER_HOST_SERVER;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sls.report.dto.GroupwiseConsumptionReportDTO;
import com.sls.report.dto.IS22SummaryReportDTO;
import com.sls.report.dto.IssueCheckListReportDTO;
import com.sls.report.dto.IssueConsumptionReportForMonthDTO;
import com.sls.report.dto.StoreConsumptionReportDTO;
import com.sls.report.dto.StoreConsumptionReportMonthlyDTO;
import com.sls.report.dto.StoreConsumptionSummaryReportDTO;
import com.sls.report.dto.StoreIssueReportDTO;
import com.sls.report.dto.StoreIssueReportIS19DTO;
import com.sls.report.services.serviceImpl.IssueReportServiceImpl;
import com.sls.report.services.serviceImpl.StoreIssueReportServiceImpl;

@RestController
@RequestMapping("storereport/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class IssueController {
	
	@Autowired
	IssueReportServiceImpl reportService;
	
	@Autowired
	StoreIssueReportServiceImpl reportService1;
	
	@GetMapping("issuechecklistreport/{startDate}/{endDate}")
	public List<IssueCheckListReportDTO> getAllIssueCheckListReport(@PathVariable("startDate") Date startDate,
																	@PathVariable("endDate") Date endDate) {
		return reportService.getAllIssueCheckListReport(startDate, endDate);
	}
	
	@GetMapping("issuecomparisionincresingreport/{date}")
	public List<IssueConsumptionReportForMonthDTO> 
							getAllIssueComparisionIncreasingReportForMonth(@PathVariable("date") String date){
		return reportService.getAllIssueConsumptionIncreasingReportForMonth(date);
	}
	
	@GetMapping("issuecomparisiondecresingreport/{date}")
	public List<IssueConsumptionReportForMonthDTO> 
							getAllIssueComparisionDecresingReportForMonth(@PathVariable("date") String date){
		return reportService.prepareIssueConsumptionDecreasingDTO(date);
	}
	
	@GetMapping("storeissuereport/{startDate}/{endDate}")
	public List<StoreIssueReportDTO> getStoreIssueReportService(@PathVariable("startDate") String startDate,
																@PathVariable("endDate") String endDate) {
		return reportService.getStoreIssueReportService(startDate, endDate);
	}
	
	@GetMapping("storeconsumptionreport/{startDate}/{endDate}")
	public List<StoreConsumptionReportDTO> getAllStoreConsumptionReport(@PathVariable("startDate") String startDate,
																		@PathVariable("endDate") String endDate) {
		return reportService.getAllStoreConsumptionReport(startDate, endDate);
	}
	
	@GetMapping("storeconsumptionreportexptypewise/{startDate}/{endDate}/{expType}")
	public List<StoreConsumptionReportDTO> getAllStoreConsumptionReportExpTypeWise(@PathVariable("startDate") String startDate,
																		@PathVariable("endDate") String endDate,
																		@PathVariable("expType") String expType) {
		return reportService.getAllStoreConsumptionReportExpTypeWise(startDate, endDate, expType);
	}
	
	@GetMapping("storeconsumptionreportgroupwise/{groupCode}/{startDate}/{endDate}")
	public List<StoreConsumptionReportDTO> getAllStoreConsumptionReportByGroup(
																		@PathVariable("groupCode") String groupCode,
																		@PathVariable("startDate") String startDate,
																		@PathVariable("endDate") String endDate) {
		return reportService.getAllStoreConsumptionReportGroupWise(groupCode,startDate, endDate);
	}
	
	@GetMapping("storeconsumptionsummaryreportgroupwise/{groupCode}/{startDate}/{endDate}")
	public List<IS22SummaryReportDTO> getAllStoreConsumptionSummaryReportByGroup(
																		@PathVariable("groupCode") String groupCode,
																		@PathVariable("startDate") String startDate,
																		@PathVariable("endDate") String endDate) {
		return reportService.getAllStoreConsumptionSummaryReportGroupWise(groupCode,startDate, endDate);
	}
	
	@GetMapping("storeconsumptionreportdeptwise/{deptCode}/{startDate}/{endDate}")
	public List<StoreConsumptionReportDTO> getAllStoreConsumptionDeptwiseReportByGroup(
																		@PathVariable("deptCode") long deptCode,
																		@PathVariable("startDate") String startDate,
																		@PathVariable("endDate") String endDate) {
		return reportService.getAllStoreConsumptionReportDepartmentWise(deptCode,startDate, endDate);
	}
	
	@GetMapping("storeissuereport19/{startDate}/{endDate}")
	public List<StoreIssueReportIS19DTO> getAllStoreIssueReportIS19(@PathVariable("startDate") String startDate,
																	@PathVariable("endDate") String endDate) {
		return reportService1.getAllStoreIssueReportIS19(startDate, endDate);
	}
	
	@GetMapping("storeconsumptionsummaryreport/{startDate}/{endDate}")
	public List<StoreConsumptionSummaryReportDTO> getAllStoreConsumptionSummaryReport(
																		@PathVariable("startDate") String startDate,
																		@PathVariable("endDate") String endDate) {
		return reportService.getAllStoreConsumptionSummaryReport(startDate,endDate);
	}
	
	@GetMapping("groupwiseconsumpsionreport/{startDate}")
	public List<GroupwiseConsumptionReportDTO> getAllGroupwiseConsumptionReport(
																		@PathVariable("startDate") Date startDate) {
		return reportService.getGroupwiseConsumptionReport(startDate);
	}
	
	@GetMapping("getStoreConsumptionReportMonthly/{yyyymm}")
	public List<StoreConsumptionReportMonthlyDTO> getStoreConsumptionReportMonthly(
																@PathVariable("yyyymm") String yyyymm) {
		return reportService.getStoreConsumptionReportMonthly(yyyymm);
	}

}
