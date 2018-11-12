package com.sls.report.services.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sls.report.component.DepartmentComponent;
import com.sls.report.component.ItemGroupComponent;
import com.sls.report.component.ItemGroupDeptDao;
import com.sls.report.component.ItemMasterComponent;
import com.sls.report.component.POHdrComponent;
import com.sls.report.component.POLineItemComponent;
import com.sls.report.component.PhysicalStockComponent;
import com.sls.report.component.ScmIndentLineItemCompnent;
import com.sls.report.component.ScmIssueHdrComponent;
import com.sls.report.component.ScmIssueLineItemComponent;
import com.sls.report.component.ScmSrHdrComponent;
import com.sls.report.component.ScmSrLineItemComponent;
import com.sls.report.component.SupplierMasterDao;
import com.sls.report.component.UomMasterComponent;
import com.sls.report.dto.NegativeStoresLedgerReportDTO;
import com.sls.report.dto.SelectiveStoresLedgerDTO;
import com.sls.report.dto.StockSlowMovementReportDTO;
import com.sls.report.dto.StoresStockReportDTO;
import com.sls.report.entity.Department;
import com.sls.report.entity.ItemGroupDept;
import com.sls.report.entity.ItemGroupMaster;
import com.sls.report.entity.ItemMaster;
import com.sls.report.entity.POHeader;
import com.sls.report.entity.POLineItem;
import com.sls.report.entity.PhysicalStock;
import com.sls.report.entity.ScmIndentLineItem;
import com.sls.report.entity.ScmIssueHdr;
import com.sls.report.entity.ScmIssueLineItem;
import com.sls.report.entity.ScmSrHdr;
import com.sls.report.entity.ScmSrLineItem;
import com.sls.report.entity.SupplierMaster;
import com.sls.report.entity.UomMaster;
import com.sls.report.services.StoreLedgerService;


@Service
public class StoreLedgerServiceImpl implements StoreLedgerService {

	@Autowired
	ItemMasterComponent itemDao;
	
	@Autowired
	ScmSrHdrComponent srhdrDao;
	
	@Autowired
	ScmSrLineItemComponent srlineitemDao;
	
	@Autowired
	UomMasterComponent uomDao;
	
	@Autowired
	ScmIssueHdrComponent issuehdrDao;
	
	@Autowired
	ScmIssueLineItemComponent issuelineitemDao;
	
	@Autowired
	ItemGroupDeptDao itemgrpmapDao;
	
	@Autowired
	ItemGroupComponent itemgrpDao;
	
	@Autowired 
	DepartmentComponent deptDao;
	
	@Autowired
	SupplierMasterDao supplierDao;
	
	@Autowired
	PhysicalStockComponent physicalstockDao;
	
	@Autowired
	POHdrComponent pohdrDao;
	
	@Autowired
	POLineItemComponent polineitemDao;
	
	@Autowired
	ScmIndentLineItemCompnent indentlineitemDao;
	
	@Override
	public List<NegativeStoresLedgerReportDTO> getAllNegativeStoresLedgerReport() {
		List<NegativeStoresLedgerReportDTO> dto = new ArrayList<>();
		try {
			List<ItemMaster> items = itemDao.getAllStoreItemMaster();
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return dto;
	}

	@Override
	public List<SelectiveStoresLedgerDTO> getAllSelectiveStoresLedger(Date startDate, Date endDate) {
		List<SelectiveStoresLedgerDTO> selectiveledgerDTO = new ArrayList<>();
		try {
			List<ScmIssueLineItem> issuelineitem = new ArrayList<>();
			List<ScmSrLineItem> srlineitem = new ArrayList<>();
			ScmIssueHdr issuehdremp = new ScmIssueHdr();
			ScmSrHdr srhdremp = new ScmSrHdr();
			List<ScmSrHdr> srhdrs = srhdrDao.getAllSrHdrByReceiptDate(startDate, endDate);
			List<ScmIssueHdr> issuehdrs = issuehdrDao.getAllIssueHdrByModDate(startDate, endDate);
			int srsize = srhdrs.size();
			for(int i = 0 ; i < srsize ; i++) {
				srlineitem = 
						srlineitemDao.getScmSrLineItemByReceiveNo(srhdrs.get(i).getStoreReceiveNo());
				List<PhysicalStock> stocks = 
						physicalstockDao.getPhysicalStockBySrNo(srhdrs.get(i).getStoreReceiveNo());
				selectiveledgerDTO
							.add(prepareSelectiveLedgerDTO(issuehdremp,srhdrs.get(i), issuelineitem, srlineitem, stocks));
			}
			
			int issuesize = issuehdrs.size();
			for(int j = 0 ; j < issuesize ; j++) {
				issuelineitem = issuelineitemDao.getIssueLineItemByIssueNo(issuehdrs.get(j).getId());
				List<PhysicalStock> stocks = new ArrayList<>();
				selectiveledgerDTO
							.add(prepareSelectiveLedgerDTO(issuehdrs.get(j),srhdremp, issuelineitem, srlineitem, stocks));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return selectiveledgerDTO;
	}

	private SelectiveStoresLedgerDTO prepareSelectiveLedgerDTO(ScmIssueHdr issueHdr2, 
																ScmSrHdr srhdrd, 
																List<ScmIssueLineItem> issuelineitem, 
																List<ScmSrLineItem> srlineitem, 
																List<PhysicalStock> stocks) {
		
		SelectiveStoresLedgerDTO dto = new SelectiveStoresLedgerDTO();

		float closingStockAmt = 0.0f;
		float closingStockQnt = 0.0f;
		float openningStockAmt = 0.0f;
		float openningStockQnt = 0.0f;
		float issueRate = 0.0f;
		float unitAmt = 0.0f;
		float unitQnt = 0.0f;

		if(srlineitem != null) {
			for(int k = 0 ; k < srlineitem.size() ; k++) {
				ItemMaster item = itemDao.getItemMasterById(srlineitem.get(k).getLineitemdetails());
				ItemGroupDept grpdept = itemgrpmapDao.getItemGroupDeptMappingByItemGroup(item.getgrpCode()).get(0);
				Department dept = deptDao.getDepartmentByDeptId(grpdept.getDeptId());
				ScmSrHdr srhdr = srhdrDao.getScmSrHdrById(srlineitem.get(k).getStoreReceiveNo());
				SupplierMaster supplier = supplierDao.findSupplierMasterById(srhdr.getSuppCode());
				dto.setRecDate(srlineitem.get(k).getReceivedDate());
				dto.setSupplier(supplier.getsuppName());
				dto.setDepartment(dept.getdepartmentName());
				dto.setDescription(item.getitemDsc());
				dto.setItemCode(item.getgrpCode()+item.getlegacyItemCode());
				issueRate = srlineitem.get(k).getReceivedPrice();
				dto.setType("SRNH");
				unitQnt = unitQnt + srlineitem.get(k).getActualQnt();
				unitAmt = unitAmt + (srlineitem.get(k).getActualQnt() * srlineitem.get(k).getReceivedPrice());
				dto.setDate(srlineitem.get(k).getApproverLevelFirstDate());
			}
		}
		dto.setUnitAmt(unitAmt);
		dto.setUnitQnt(unitQnt);
		
		
		
		
		float issueAmt = 0.0f;
		float issueQnt = 0.0f;
		if(issuelineitem != null) {
			for(int i = 0 ; i < issuelineitem.size() ; i++) {
				dto.setType("ISU");
				issueQnt = issueQnt + issuelineitem.get(i).getIssueQty();
				issueAmt = issueAmt + (issuelineitem.get(i).getIssueQty()*issueRate);
				dto.setIssueDate(issueHdr2.getIssueDate());
				dto.setDate(issueHdr2.getIssueDate());
				
			}
		}
		
		dto.setIssueAmt(issueAmt);
		dto.setIssueQnt(issueQnt);
		
		if(stocks != null) {
			for(int j = 0 ; j < stocks.size(); j++) {
				
				closingStockQnt = closingStockQnt + stocks.get(j).getStockInHand();
				openningStockQnt = openningStockQnt + stocks.get(j).getNewStock();
				openningStockAmt = openningStockAmt + (openningStockQnt * issueRate);
				closingStockAmt = closingStockAmt + (closingStockQnt * issueRate);
					
			}
		}
		
		dto.setClosingStockAmt(closingStockAmt);
		dto.setClosingStockQnt(closingStockQnt);
		dto.setOpenningStockAmt(openningStockAmt);
		dto.setOpenningStockQnt(openningStockQnt);
		
		return dto;
	}

	@Override
	public List<StockSlowMovementReportDTO> getAllStockSlowMovementReport() {
		List<StockSlowMovementReportDTO> slowmovementReportDTO = new ArrayList<>();
		
		try {
			List<ScmSrLineItem> srlines = new ArrayList<>();
			List<ScmIssueLineItem> issuelines = new ArrayList<>();
			List<ScmSrLineItem> srlinesemp = new ArrayList<>();
			List<ScmIssueLineItem> issuelinesemp = new ArrayList<>();
			ScmSrHdr srhdremp = new ScmSrHdr();
			ScmIssueHdr issuehdremp = new ScmIssueHdr();
			List<ScmSrHdr> srhdrs = srhdrDao.getAllScmSrHdr();
			List<ScmIssueHdr> issuehdrs = issuehdrDao.getAllIssueHdr();
			int srsize = srhdrs.size();
			int issuesize = issuehdrs.size();
			for(int i = 0 ; i < srsize ; i++) {
				srlines = srlineitemDao.getScmSrLineItemByReceiveNo(srhdrs.get(i).getStoreReceiveNo());
				slowmovementReportDTO.add(prepareSlowMovementReportDTO2(srlines, srhdrs.get(i), issuelinesemp, issuehdremp));
			}
			for(int j = 0 ; j < issuesize ; j++) {
				issuelines = issuelineitemDao.getIssueLineItemByIssueNo(issuehdrs.get(j).getId());
				slowmovementReportDTO.add(prepareSlowMovementReportDTO2(srlinesemp, srhdremp, issuelines, issuehdrs.get(j)));
			}
			/*List<ItemMaster> items = itemDao.getAllItemMaster();
			items.forEach(item->{
				slowmovementReportDTO.add(prepareSlowMovementReportDTO(item));
			});*/
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return slowmovementReportDTO;
	}

	private StockSlowMovementReportDTO prepareSlowMovementReportDTO2(List<ScmSrLineItem> srlineitem, ScmSrHdr srhdr,
			List<ScmIssueLineItem> issuelineitem, ScmIssueHdr issuehdr) {
		StockSlowMovementReportDTO stoclslowmovementDTO = new StockSlowMovementReportDTO();
		
		int flag1 = 0;
		int flag2 = 0;
		
		long srtime = 0;
		Date srdate = null;
		float srqnt = 0.0f;
		float rate = 0.0f;
		float srvalue = 0.0f;
		
		long issuetime = 0;
		Date issueDate = null;
		float issueqnt = 0.0f;
		float issuevalue = 0.0f;
		
		int srlinesize = srlineitem.size();
		int issuelinesize = issuelineitem.size();
		
		if(!srlineitem.isEmpty()) {
			for(int i = 0 ; i < srlinesize ; i++) {
				ItemMaster item = itemDao.getItemMasterById(srlineitem.get(i).getLineitemdetails());
				rate = srlineitem.get(i).getReceivedPrice();
				LocalDate d = LocalDate.now();
				java.sql.Date dn = java.sql.Date.valueOf(d);
				LocalDate da = srhdr.getStoreReceiveDt().toLocalDate();
				java.sql.Date dw = java.sql.Date.valueOf(da);
				long diff = (dn.getTime())-(dw.getTime());
				long diffe = diff / 1000 / 60 /60 /24;
				if(diffe >= 0 && diffe <= 365) {
					srtime = diffe;
					srdate = srhdr.getStoreReceiveDt();
					srqnt = srqnt + srlineitem.get(i).getActualQnt();
					srvalue = srvalue + (srqnt*rate);
					flag1++;
				}
				UomMaster uom = uomDao.getUomMasterById(item.getuomCode());
				stoclslowmovementDTO.setItemCode(item.getgrpCode()+item.getlegacyItemCode());
				stoclslowmovementDTO.setItemDesc(item.getitemDsc());
				stoclslowmovementDTO.setUom(uom.getuomDsc());
			}
		}
		
		if(!issuelineitem.isEmpty()) {
			for(int i = 0 ; i < issuelinesize ; i++) {
				ItemMaster item = itemDao.getItemMasterById(issuelineitem.get(i).getItemCode());
				LocalDate d = LocalDate.now();
				java.sql.Date dn = java.sql.Date.valueOf(d);
				java.sql.Date userdate =new java.sql.Date(issuehdr.getIssueDate().getTime());
				LocalDate da = userdate.toLocalDate();
				java.sql.Date dw = java.sql.Date.valueOf(da);
				long diff = (dn.getTime())-(dw.getTime());
				long diffe = diff / 1000 / 60 /60 /24;
				if(diffe >= 0 && diffe <= 365) {
					issuetime = diffe;
					issueDate = issuehdr.getIssueDate();
					issueqnt = issueqnt + issuelineitem.get(i).getIssueQty();
					issuevalue = issuevalue + (issueqnt*rate);
					flag2++;
				}
				UomMaster uom = uomDao.getUomMasterById(item.getuomCode());
				stoclslowmovementDTO.setItemCode(item.getgrpCode()+item.getlegacyItemCode());
				stoclslowmovementDTO.setItemDesc(item.getitemDsc());
				stoclslowmovementDTO.setUom(uom.getuomDsc());
			}
		}
		
		long time = 0;
		float qnt = 0.0f;
		float value = 0.0f;
		if(flag1>=0 || flag2>=0) {
			if(issuetime>srtime) {
				time = issuetime;
				qnt = issueqnt;
				value = issuevalue;
			}else if(issuetime<srtime) {
				time = srtime;
				qnt = srqnt;
				value = srvalue;
			}else if(issuetime==srtime) {
				time = 0;
				qnt = srqnt+issueqnt;
				value = qnt*rate;
			}else {
				time = 0;
				qnt = srqnt+issueqnt;
				value = qnt*rate;
			}
			
				
		}
		
		stoclslowmovementDTO.setDays(time);
		stoclslowmovementDTO.setIssueDate(issueDate);
		stoclslowmovementDTO.setQnt(qnt);
		stoclslowmovementDTO.setReceivedDate(srdate);
		stoclslowmovementDTO.setValue(value);
		
		return stoclslowmovementDTO;
	}

	private StockSlowMovementReportDTO prepareSlowMovementReportDTO(ItemMaster item) {
		StockSlowMovementReportDTO stoclslowmovementDTO = new StockSlowMovementReportDTO();
		UomMaster uom = uomDao.getUomMasterById(item.getuomCode());
		List<ScmIssueLineItem> issuelineitem = issuelineitemDao.getLineItemsByItem(item.getId());
		List<ScmSrLineItem> srlineitem = srlineitemDao.getScmSrLineItemByItemCode(item.getId());
		
		stoclslowmovementDTO.setItemCode(item.getgrpCode()+item.getlegacyItemCode());
		stoclslowmovementDTO.setItemDesc(item.getitemDsc());
		stoclslowmovementDTO.setUom(uom.getuomDsc());
		
		int flag1 = 0;
		int flag2 = 0;
		
		long srtime = 0;
		Date srdate = null;
		float srqnt = 0.0f;
		float rate = 0.0f;
		float srvalue = 0.0f;
		if(!srlineitem.isEmpty()) {
			for(int i = 0 ; i < srlineitem.size() ; i++) {
				ScmSrHdr srhdr = srhdrDao.getScmSrHdrById(srlineitem.get(i).getStoreReceiveNo());
				rate = srlineitem.get(i).getReceivedPrice();
				LocalDate d = LocalDate.now();
				java.sql.Date dn = java.sql.Date.valueOf(d);
				LocalDate da = srhdr.getStoreReceiveDt().toLocalDate();
				java.sql.Date dw = java.sql.Date.valueOf(da);
				long diff = (dn.getTime())-(dw.getTime());
				long diffe = diff / 1000 / 60 /60 /24;
				if(diffe >= 0 && diffe <= 365) {
					srtime = diffe;
					srdate = srhdr.getStoreReceiveDt();
					srqnt = srqnt + srlineitem.get(i).getActualQnt();
					srvalue = srvalue + (srqnt*rate);
					flag1++;
				}
			}
		}
		
		long issuetime = 0;
		Date issueDate = null;
		float issueqnt = 0.0f;
		float issuevalue = 0.0f;
		if(!issuelineitem.isEmpty()) {
			for(int i = 0 ; i < issuelineitem.size() ; i++) {
				ScmIssueHdr issuehdr = 
						issuehdrDao.getScmIssuHdrBySrHdr(issuelineitem.get(i).getIssueNo());
				LocalDate d = LocalDate.now();
				java.sql.Date dn = java.sql.Date.valueOf(d);
				java.sql.Date userdate =new java.sql.Date(issuehdr.getIssueDate().getTime());
				LocalDate da = userdate.toLocalDate();
				java.sql.Date dw = java.sql.Date.valueOf(da);
				long diff = (dn.getTime())-(dw.getTime());
				long diffe = diff / 1000 / 60 /60 /24;
				if(diffe >= 0 && diffe <= 365) {
					issuetime = diffe;
					issueDate = issuehdr.getIssueDate();
					issueqnt = issueqnt + issuelineitem.get(i).getIssueQty();
					issuevalue = issuevalue + (issueqnt*rate);
					flag2++;
				}
			}
		}
		
		long time = 0;
		float qnt = 0.0f;
		float value = 0.0f;
		if(flag1>=0 || flag2>=0) {
			if(issuetime>srtime) {
				time = issuetime;
				qnt = issueqnt;
				value = issuevalue;
			}else if(issuetime<srtime) {
				time = srtime;
				qnt = srqnt;
				value = srvalue;
			}else if(issuetime==srtime) {
				time = 0;
				qnt = srqnt+issueqnt;
				value = qnt*rate;
			}else {
				time = 0;
				qnt = srqnt+issueqnt;
				value = qnt*rate;
			}
			
				
		}
		
		stoclslowmovementDTO.setDays(time);
		stoclslowmovementDTO.setIssueDate(issueDate);
		stoclslowmovementDTO.setQnt(qnt);
		stoclslowmovementDTO.setReceivedDate(srdate);
		stoclslowmovementDTO.setValue(value);
		
		return stoclslowmovementDTO;
	}

	@Override
	public List<StoresStockReportDTO> getAllStoresStockReport() {
		List<StoresStockReportDTO> storesStockReportDTOs = new ArrayList<>();
		try {
			List<ItemMaster> items = itemDao.getAllItemMaster();
			items.forEach(item->{
				storesStockReportDTOs.add(prepareStoresStockReportDTO(item));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return storesStockReportDTOs;
	}

	private StoresStockReportDTO prepareStoresStockReportDTO(ItemMaster item) {
		StoresStockReportDTO storestockreportDTO = new StoresStockReportDTO();
		UomMaster uom = uomDao.getUomMasterById(item.getuomCode());
		ItemGroupMaster grp = itemgrpDao.getItemGroupByGroupId(item.getgrpCode());
		List<POLineItem> polineitems = polineitemDao.getPOLineItemByItemCode(item.getId());
		List<ScmIndentLineItem> indentlineitems = indentlineitemDao.getIndentLineItemByItemCode(item.getId());
		List<ScmSrLineItem> srlineitems = srlineitemDao.getScmSrLineItemByItemCode(item.getId());
		List<PhysicalStock> stocks = physicalstockDao.getPhysicalStockByItem(item.getId());
		
		POHeader pohdr = new POHeader();
		SupplierMaster supplier = new SupplierMaster();
		for(int i = 0 ; i < polineitems.size() ; i++) {
			pohdr = pohdrDao.getPOHeaderById(polineitems.get(i).getPoId());
			supplier = supplierDao.findSupplierMasterById(pohdr.getSupplierId());
			storestockreportDTO.setLastOrderNo(pohdr.getId());
		}
		
		POLineItem lineitem = new POLineItem();
		float reqQnt = 0.0f;
		for(int i = 0 ; i < polineitems.size() ; i++) {
			if(polineitems.get(i).getStatus().equals("3")) {
				storestockreportDTO.setApprovedQnt(polineitems.get(i).getActualQuantity());
				storestockreportDTO.setDiscount(polineitems.get(i).getDiscount());
				reqQnt = reqQnt + polineitems.get(i).getQuantity();
			}
			
		}
		
		storestockreportDTO.setDate(pohdr.getPoDate());
		storestockreportDTO.setGrp(grp.getgrpDsc());
		
		float indentQnt = 0.0f;
		for(int j = 0 ; j < indentlineitems.size() ; j++) {
			indentQnt = indentQnt + indentlineitems.get(j).getIndentQnt();
		}
		
		float rate = 0.0f;
		for(int k = 0 ; k < srlineitems.size() ; k++) {
			rate = rate+srlineitems.get(k).getReceivedPrice();
		}
		
		storestockreportDTO.setIndentQnt(indentQnt);
		storestockreportDTO.setItemCode(item.getgrpCode()+item.getlegacyItemCode());
		storestockreportDTO.setItemDesc(item.getitemDsc());
		
		storestockreportDTO.setMaxQnt(item.getMaxOrderValue());
//		storestockreportDTO.setMtdCons(mtdCons);
		storestockreportDTO.setRate(rate);
		storestockreportDTO.setReqQnt(reqQnt);
		storestockreportDTO.setSupplier(supplier.getsuppName());
		storestockreportDTO.setUnit(uom.getuomDsc());
		
		float stockQnt = 0.0f;
		for(int a = 0 ; a < stocks.size() ; a++) {
			stockQnt = stockQnt + stocks.get(a).getStockInHand();
		}
		
		storestockreportDTO.setStockQnt(stockQnt);
		
		return storestockreportDTO;
	}

}
