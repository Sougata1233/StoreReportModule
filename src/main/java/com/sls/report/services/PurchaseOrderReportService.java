package com.sls.report.services;

import java.sql.Date;
import java.util.List;

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

public interface PurchaseOrderReportService {

	public List<PurchaseOrderCancelDTO> getAllPurchaseOrderCancel(Date startDate, Date endDate);
	public List<POOrderCancelNoteReportDTO> getAllPOOrderCancelNoteReport(Date date);
	public List<OrderRegisterForHODTO> getAllOrderRegisterForHO(Date startDate, Date endDate);
	
	public List<OrderRegisterDTO> getAllOrderRegisterPartyWise(Date startDate, Date endDate, String partyName);
	public List<OrderRegisterDTO> getAllOrderRegisterGroupWise(Date startDate, Date endDate, String itemGroup);
	
	public List<POCancelReportDTO> getAllPOCancelReport(Date startDate);
	
	public List<OutstandingPODetailsDTO> getAllOutstandingPODetails(Date startDate, Date endDate);
	public List<OutstandingPODetailsDTO> getAllOutstandingPODetailsItemWise(Date startDate, Date endDate, String item);
	public List<OutstandingPODetailsDTO> getAllOutstandingPODetailsPartyWise(Date startDate, Date endDate, String party);
	public List<POOutstandingSummaryDTO> getAllOutStandingOrderSummary(Date startDate, Date endDate);
	public List<POOutstandingSummaryDTO> getAllOutStandingOrderSummaryItemWise(Date startDate, Date endDate, String item);
	public List<POOutstandingSummaryDTO> getAllOutStandingOrderSummaryPartyWise(Date startDate, Date endDate, String party);
	
	public List<POReport19DTO> getAllPOReport19(Date date);
	List<PurchaseOrderHistoryReportDTO> getAllPurchaseOrderHistoryReport(Date startDate, Date endDate, String suppName);
	
	public List<PO02ReportDTO> getAllPO02ReportDTO(Date poDate, String poNo);
	
}
