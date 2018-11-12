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

import com.sls.report.dto.SelectiveStoresLedgerDTO;
import com.sls.report.dto.StockSlowMovementReportDTO;
import com.sls.report.dto.StoresStockReportDTO;
import com.sls.report.services.serviceImpl.StoreLedgerServiceImpl;

@RestController
@RequestMapping("storereport")
@CrossOrigin(origins = USER_HOST_SERVER)
public class StoreLedgerController {

	@Autowired
	StoreLedgerServiceImpl reportService;
	
	
	@GetMapping("/selectiveledgerreport/{startDate}/{endDate}")
	public List<SelectiveStoresLedgerDTO> getAllSelectiveStoresLedger(@PathVariable("startDate") Date startDate, 
																		@PathVariable("endDate") Date endDate) {
		return reportService.getAllSelectiveStoresLedger(startDate,endDate);
	}
	
	@GetMapping("/stockslowmovementreport")
	public List<StockSlowMovementReportDTO> getAllStockSlowMovementReport()  {
		return reportService.getAllStockSlowMovementReport();
	}
	
	@GetMapping("/storesstockreport")
	public List<StoresStockReportDTO> getAllStoresStockReport() {
		return reportService.getAllStoresStockReport();
	}
	
}
