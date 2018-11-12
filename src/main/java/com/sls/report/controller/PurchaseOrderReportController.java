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

import com.sls.report.dto.OrderRegisterDTO;
import com.sls.report.dto.OrderRegisterForHODTO;
import com.sls.report.dto.OutstandingPODetailsDTO;
import com.sls.report.dto.PO02ReportDTO;
import com.sls.report.dto.POCancelReportDTO;
import com.sls.report.dto.POOrderCancelNoteReportDTO;
import com.sls.report.dto.POOutstandingSummaryDTO;
import com.sls.report.dto.POReport19DTO;
import com.sls.report.dto.PurchaseOrderCancelDTO;
import com.sls.report.dto.PurchaseOrderHistoryReportDTO;
import com.sls.report.services.serviceImpl.PurchaseOrderReportServiceImpl;

@RestController
@RequestMapping("storereport/")
@CrossOrigin(origins = USER_HOST_SERVER)
public class PurchaseOrderReportController {

	@Autowired
	PurchaseOrderReportServiceImpl reportService;
	
	@GetMapping("cancelledpuchaseorderregisterreport/{startDate}/{endDate}")
	public List<PurchaseOrderCancelDTO> getAllPurchaseOrderCancel(@PathVariable("startDate") Date startDate,
																	@PathVariable("endDate") Date endDate) {
		return reportService.getAllPurchaseOrderCancel(startDate, endDate);
	}
	
	@GetMapping("orderpuchaseorderregisterpartywisereport/{startDate}/{endDate}/{partyName}")
	public List<OrderRegisterDTO> getAllOrderRegisterPartyWise(@PathVariable("startDate") Date startDate,
																@PathVariable("endDate") Date endDate,
																@PathVariable("partyName") String partyName) {
		return reportService.getAllOrderRegisterPartyWise(startDate, endDate, partyName);
	}
	
	@GetMapping("orderpuchaseorderregisteritemgroupwisereport/{startDate}/{endDate}/{itemGroup}")
	public List<OrderRegisterDTO> getAllOrderRegisterGroupWise(@PathVariable("startDate") Date startDate,
																@PathVariable("endDate") Date endDate,
																@PathVariable("itemGroup") String itemGroup) {
		return reportService.getAllOrderRegisterGroupWise(startDate, endDate, itemGroup);
	}
	
	@GetMapping("orderpuchaseorderhoregisterreport/{startDate}/{endDate}")
	public List<OrderRegisterForHODTO> getAllOrderRegisterForHO(@PathVariable("startDate") Date startDate,
																@PathVariable("endDate") Date endDate) {
		return reportService.getAllOrderRegisterForHO(startDate, endDate);
	}
	
	@GetMapping("cacnelpuchaseorderhoregisterreport/{startDate}")
	public List<POCancelReportDTO> getAllPOCancelReport(@PathVariable("startDate") Date startDate) {
		return reportService.getAllPOCancelReport(startDate);
	}
	
	@GetMapping("pooutstandingreport/{startDate}/{endDate}")
	public List<OutstandingPODetailsDTO> getAllOutstandingPODetails(@PathVariable("startDate") Date startDate,
																	@PathVariable("endDate") Date endDate) {
		return reportService.getAllOutstandingPODetails(startDate, endDate);
	}
	
	@GetMapping("pooutstandingreportitemwise/{startDate}/{endDate}/{item}")
	public List<OutstandingPODetailsDTO> getAllOutstandingPODetailsItemWise(@PathVariable("startDate") Date startDate,
																			@PathVariable("endDate") Date endDate,
																			@PathVariable("item") String item) {
		return reportService.getAllOutstandingPODetailsItemWise(startDate, endDate, item);
	}
	
	@GetMapping("pooutstandingreportpartywise/{startDate}/{endDate}/{party}")
	public List<OutstandingPODetailsDTO> getAllOutstandingPODetailsPartyWise(@PathVariable("startDate") Date startDate,
																			@PathVariable("endDate") Date endDate,
																			@PathVariable("party") String party) {
		return reportService.getAllOutstandingPODetailsPartyWise(startDate, endDate, party);
	}
	
	@GetMapping("poeport19/{date}")
	public List<POReport19DTO> getAllPOReport19(@PathVariable("date") Date date) {
		return reportService.getAllPOReport19(date);
	}
	
	@GetMapping("orderpuchaseorderhistoryregisterreport/{startDate}/{endDate}/{suppCode}")
	public List<PurchaseOrderHistoryReportDTO> 
						getAllPurchaseOrderHistoryReport(@PathVariable("startDate") Date startDate, 
															@PathVariable("endDate") Date endDate, 
															@PathVariable("suppCode") String suppCode) {
		return reportService.getAllPurchaseOrderHistoryReport(startDate, endDate, suppCode);
	}
	
	@GetMapping("PO02Report/{poDate}/{poNo}")
	public List<PO02ReportDTO> getAllPO02ReportDTO(@PathVariable("poDate") Date poDate,
			@PathVariable("poNo") String poNo) {
		return reportService.getAllPO02ReportDTO(poDate, poNo);
	}
	
	@GetMapping("canceledPONoteReport/{date}")
	public List<POOrderCancelNoteReportDTO> getAllPOOrderCancelNoteReport(@PathVariable("date") Date date) {
		return reportService.getAllPOOrderCancelNoteReport(date);
	}
	
	@GetMapping("outstandingpurchaseordersummaryreport/{startDate}/{endDate}")
	public List<POOutstandingSummaryDTO> getAllOutStandingOrderSummary(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate) {
		return reportService.getAllOutStandingOrderSummary(startDate,endDate);
	}
	
	@GetMapping("outstandingpurchaseordersummaryreportitemwise/{startDate}/{endDate}/{itemcode}")
	public List<POOutstandingSummaryDTO> getAllOutStandingOrderSummaryItemWise(
			@PathVariable("startDate") Date startDate,
			@PathVariable("endDate") Date endDate,
			@PathVariable("itemcode") String itemcode) {
		return reportService.getAllOutStandingOrderSummaryItemWise(startDate,endDate,itemcode);
	}
	
	@GetMapping("outstandingpurchaseordersummaryreportpartywise/{startDate}/{endDate}/{suppcode}")
	public List<POOutstandingSummaryDTO> getAllOutStandingOrderSummaryPartyWise(
			@PathVariable("startDate") Date startDate,
			@PathVariable("endDate") Date endDate,
			@PathVariable("suppcode") String suppcode) {
		return reportService.getAllOutStandingOrderSummaryPartyWise(startDate,endDate,suppcode);
	}
	
}
