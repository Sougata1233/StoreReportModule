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

import com.sls.report.dto.CancelledIndentDTO;
import com.sls.report.dto.IndentCancelRegisterDTO;
import com.sls.report.dto.IndentDetailsReportNumberWiseDTO;
import com.sls.report.dto.IndentSummaryReportWaitingForPODTO;
import com.sls.report.dto.OutstandingIndentReportDTO;
import com.sls.report.services.serviceImpl.IndentServiceImpl;

@RestController
@RequestMapping("storereport/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class IndentController {

	@Autowired
	IndentServiceImpl reportService;
	
	@GetMapping("cancelledindentregisterreport/{startDate}/{endDate}")
	public List<IndentCancelRegisterDTO> getAllIndentCancelRegister(@PathVariable("startDate") Date startDate, 
																	@PathVariable("endDate") Date endDate) {
		return reportService.getAllIndentCancelRegister(startDate, endDate);
	}
	
	@GetMapping("cancelledindentreport/{indentNo}")
	public List<CancelledIndentDTO> getAllCancelledIndentReport(@PathVariable("indentNo") String indentNo) {
		return reportService.getAllCancelledIndentReport(indentNo);
	}
	
	@GetMapping("indentdetailsreport/{startDate}/{endDate}")
	List<IndentDetailsReportNumberWiseDTO> getAllIndentDetailsReport(@PathVariable("startDate") Date startDate,
			@PathVariable("endDate") Date endDate){
		return reportService.getAllIndentDetailsReport(startDate, endDate);
	}
	
	@GetMapping("indentdetailsitemwisereport/{startDate}/{endDate}")
	List<IndentDetailsReportNumberWiseDTO> getAllIndentDetailsItemWiseReport(@PathVariable("startDate") Date startDate,
																				@PathVariable("endDate") Date endDate){
		return reportService.getAllIndentDetailsReportItemWise(startDate, endDate);
	}
	
	@GetMapping("indentdetailsreportnumberwise/{startDate}/{endDate}")
	List<IndentDetailsReportNumberWiseDTO> getAllIndentDetailsReportNumberWise(@PathVariable("startDate") Date startDate,
			@PathVariable("endDate") Date endDate){
		return reportService.getAllIndentDetailsReportNumberWise(startDate, endDate);
	}
	
	
	@GetMapping("outstandingindentreport/{startDate}/{endDate}")
	List<OutstandingIndentReportDTO> getAllOutstandingIndentDetailsReportNumberWise(@PathVariable("startDate") Date startDate, 
																			@PathVariable("endDate") Date endDate){
		return reportService.getAllOutstandingIndentReport(startDate, endDate);
	}
	
	@GetMapping("outstandingindentreportitemwise/{startDate}")
	List<OutstandingIndentReportDTO> getAllIndentDetailsReportItemWise(@PathVariable("startDate") Date startDate){
		return reportService.getAllOutstandingIndentReportItemWise(startDate);
	}
	
	@GetMapping("outstandingindentreportdeptwise/{startDate}")
	List<OutstandingIndentReportDTO> getAllIndentDetailsReportDeptWise(@PathVariable("startDate") Date startDate){
		return reportService.getAllOutstandingIndentReportDeptWise(startDate);
	}
	
	@GetMapping("outstandingindentreportgroupwise/{startDate}/{endDate}/{group}")
	List<OutstandingIndentReportDTO> getAllIndentDetailsReportgroupWise(@PathVariable("startDate") Date startDate, 
																			@PathVariable("endDate") Date endDate,
																			@PathVariable("group") String group){
		return reportService.getAllOutstandingIndentReportGroupWise(startDate, endDate, group);
	}
	
	@GetMapping("indentsummaryreportwaitingforpo/{indentDate}")
	List<IndentSummaryReportWaitingForPODTO> getAllIndentSummaryReportWaitingForPO(
															@PathVariable("indentDate") Date indentDate){
		return reportService.getAllIndentSummaryReportWaitingForPO(indentDate);
	}
	
}
