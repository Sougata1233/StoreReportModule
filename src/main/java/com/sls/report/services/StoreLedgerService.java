package com.sls.report.services;

import java.sql.Date;
import java.util.List;

import com.sls.report.dto.NegativeStoresLedgerReportDTO;
import com.sls.report.dto.SelectiveStoresLedgerDTO;
import com.sls.report.dto.StockSlowMovementReportDTO;
import com.sls.report.dto.StoresStockReportDTO;

public interface StoreLedgerService {

	public List<NegativeStoresLedgerReportDTO> getAllNegativeStoresLedgerReport();
	public List<SelectiveStoresLedgerDTO> getAllSelectiveStoresLedger(Date startDate, Date endDate);
	List<StockSlowMovementReportDTO> getAllStockSlowMovementReport();
	public List<StoresStockReportDTO> getAllStoresStockReport();
	
}
