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

import com.sls.report.dto.DrCrNoteRegisterDTO;
import com.sls.report.dto.HOStoresReceiptCumBillPassReportDTO;
import com.sls.report.dto.InwardRegisterReportDTO;
import com.sls.report.dto.MillStoreRecieptRegisterDTO;
import com.sls.report.dto.StoreApprovalNoteDTO;
import com.sls.report.dto.StoreReceiptNoteReportDTO;
import com.sls.report.services.serviceImpl.StoreRegisterReportServiceImpl;


@RestController
@RequestMapping("storereport")
@CrossOrigin(origins = USER_HOST_SERVER)
public class StoreRegisterReportController {

	@Autowired
	StoreRegisterReportServiceImpl reportService;
	
	@GetMapping("/drcrnoteregisterreport/{startDate}/{endDate}")
	public List<DrCrNoteRegisterDTO> getAllDrCrNoteRegisterReport(@PathVariable("startDate") Date startDate, 
			@PathVariable("endDate") Date endDate){
		return reportService.getAllDrCrNoteRegisterReport(startDate, endDate);
	}
	
	@GetMapping("hostorereceiptbillpassreportsr/{startDate}/{endDate}")
	public List<HOStoresReceiptCumBillPassReportDTO> getAllHOStoresReceiptCumBillPassReportSR(@PathVariable("startDate") 
					Date startDate, @PathVariable("endDate") Date endDate){
		return reportService.getAllHOStoresReceiptCumBillPassReportNew(startDate, endDate);
	}
	
	@GetMapping("hostorereceiptbillpassreportsr/{suppCode}")
	public List<HOStoresReceiptCumBillPassReportDTO> getAllHOStoresReceiptCumBillPassReportSRBySuppCode(
																		@PathVariable("suppCode") String suppCode){
		return reportService.getAllHOStoresReceiptCumBillPassReportNewBySuppCode(suppCode);
	}
	
	@GetMapping("inwardregisterreport")
	public List<InwardRegisterReportDTO> getAllInwardRegisterReport(){
		return reportService.getAllInwardRegisterReport();
	}
	
	@GetMapping("/millstorereceivereport/{startDate}/{endDate}")
	public List<MillStoreRecieptRegisterDTO> getAllMillStoreRecieptRegister(@PathVariable("startDate") Date startDate, 
			@PathVariable("endDate") Date endDate){
		return reportService.getAllMillStoreRecieptRegister(startDate, endDate);
	}
	
	@GetMapping("storeapprovalnote/{date}")
	public List<StoreApprovalNoteDTO> getAllStoreApprovalNote(@PathVariable("date") Date date){
		return reportService.getAllStoreApprovalNote(date);
	}
	
	@GetMapping("storereceiptnote/{date}")
	public List<StoreReceiptNoteReportDTO> getAllStoreReceiptNoteReport(@PathVariable("date") Date date){
		return reportService.getAllStoreReceiptNoteReport(date);
	}
	
}
