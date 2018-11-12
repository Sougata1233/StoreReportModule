package com.sls.report.services.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.sls.report.component.BillPassComponent;
import com.sls.report.component.DrCrNoteComponent;
import com.sls.report.component.GateStoreEntryDtlComponent;
import com.sls.report.component.GateStoreEntryHdrComponent;
import com.sls.report.component.IssueLineItemComponent;
import com.sls.report.component.ItemGroupDeptDao;
import com.sls.report.component.ItemMasterComponent;
import com.sls.report.component.POHdrComponent;
import com.sls.report.component.POLineItemComponent;
import com.sls.report.component.ScmSrHdrComponent;
import com.sls.report.component.ScmSrLineItemComponent;
import com.sls.report.component.SupplierMasterDao;
import com.sls.report.component.UomMasterComponent;
import com.sls.report.dto.DrCrNoteRegisterDTO;
import com.sls.report.dto.HOStoresReceiptCumBillPassReportDTO;
import com.sls.report.dto.InwardRegisterReportDTO;
import com.sls.report.dto.InwardReportDTO;
import com.sls.report.dto.MillStoreRecieptRegisterDTO;
import com.sls.report.dto.POLineItemDTO;
import com.sls.report.dto.StoreApprovalLineIteDTO;
import com.sls.report.dto.StoreApprovalNoteDTO;
import com.sls.report.dto.StoreReceiptNoteLineDTO;
import com.sls.report.dto.StoreReceiptNoteReportDTO;
import com.sls.report.dto.StoreReportIndentIN01DTO;
import com.sls.report.entity.BillPass;
import com.sls.report.entity.DrCrNote;
import com.sls.report.entity.GateStoreEntryRegDtl;
import com.sls.report.entity.GateStoreEntryRegHdr;
import com.sls.report.entity.ItemGroupDept;
import com.sls.report.entity.ItemMaster;
import com.sls.report.entity.POHeader;
import com.sls.report.entity.POLineItem;
import com.sls.report.entity.ScmSrHdr;
import com.sls.report.entity.ScmSrLineItem;
import com.sls.report.entity.SupplierMaster;
import com.sls.report.entity.UomMaster;
import com.sls.report.services.StoreRegisterReportService;

@Service
public class StoreRegisterReportServiceImpl implements StoreRegisterReportService {

	@Autowired
	DrCrNoteComponent drcrnoteDao;

	@Autowired
	SupplierMasterDao supplierDao;

	@Autowired
	POHdrComponent hdrDao;

	@Autowired
	POLineItemComponent lineitemDao;

	@Autowired
	BillPassComponent billDao;

	@Autowired
	ItemMasterComponent itemDao;

	@Autowired
	UomMasterComponent uomDao;

	@Autowired
	GateStoreEntryHdrComponent gateentryDao;

	@Autowired
	ScmSrHdrComponent srhdrDao;

	@Autowired
	ScmSrLineItemComponent srlineitemDao;

	@Autowired
	GateStoreEntryHdrComponent entryDao;

	@Autowired
	GateStoreEntryDtlComponent entrydtlDao;

	@Autowired
	POHdrComponent pohdrDao;

	@Autowired
	ScmSrHdrComponent srDao;

	@Autowired
	IssueLineItemComponent issuelineitemDao;

	@Autowired
	ItemGroupDeptDao groupdeptDao;

	@Override
	public List<DrCrNoteRegisterDTO> getAllDrCrNoteRegisterReport(Date startDate, Date endDate) {
		List<DrCrNoteRegisterDTO> drcrnoteDTOs = new ArrayList<>();
		try {
			List<DrCrNote> drcrnoteEntity = drcrnoteDao.getAllDrCrNote();
			drcrnoteEntity.forEach(drcr -> {
				drcrnoteDTOs.add(prepareDrCrNoteDTO(drcr));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return drcrnoteDTOs;
	}

	private DrCrNoteRegisterDTO prepareDrCrNoteDTO(DrCrNote drcr) {
		DrCrNoteRegisterDTO drcrnoteDTO = new DrCrNoteRegisterDTO();

		SupplierMaster supplier = supplierDao.findSupplierMasterById(drcr.getSuppCode());

		drcrnoteDTO.setAmount(drcr.getAdjustmentValue());
		drcrnoteDTO.setDrCrDate(drcr.getAdjustmentDate());
		drcrnoteDTO.setDrCrNum(drcr.getAdjustmentNo());
		drcrnoteDTO.setDrCrQuantity(drcr.getAdjustmentQuantity());
		drcrnoteDTO.setItemCode(drcr.getItemCode());
		drcrnoteDTO.setReason(drcr.getReason());
		drcrnoteDTO.setSuppName(supplier.getId() + "_" + supplier.getsuppName());
		drcrnoteDTO.setSrNum(String.valueOf(drcr.getSrMrNum()));

		return drcrnoteDTO;
	}

	@Override
	public List<HOStoresReceiptCumBillPassReportDTO> getAllHOStoresReceiptCumBillPassReport() {
		List<HOStoresReceiptCumBillPassReportDTO> hostorebillpassreport = new ArrayList<>();
		HOStoresReceiptCumBillPassReportDTO reportDTO = new HOStoresReceiptCumBillPassReportDTO();

		List<BillPass> billpass = billDao.getAllBillPass();
		billpass.forEach(bill -> {
			SupplierMaster supplier = supplierDao.findSupplierMasterById(bill.getSuppCode());
			POHeader pohdr = hdrDao.getPOHeaderById(bill.getPoNo());
			List<POLineItem> lineitem = lineitemDao.getPOLineItemByPoNo(pohdr.getId());

			GateStoreEntryRegHdr gateentry = gateentryDao.getGateStoreEntryRegHdrByPoNo(String.valueOf(pohdr.getId()));
			List<POLineItemDTO> lineitemDTOs = new ArrayList<>();
			POLineItemDTO lineitemDTO = new POLineItemDTO();

			for (int i = 0; i < lineitem.size(); i++) {
				ItemMaster item = itemDao.getItemMasterById(lineitem.get(i).getItemId());
				UomMaster uom = uomDao.getUomMasterById(item.getuomCode());

				lineitemDTO.setAcceptedQnt(lineitem.get(i).getActualQuantity());
				lineitemDTO.setDescription(item.getitemDsc());
				lineitemDTO.setMake(item.getmake());
				lineitemDTO.setRate(lineitem.get(i).getRate());
				lineitemDTO.setUom(uom.getuomDsc());

				lineitemDTOs.add(lineitemDTO);
			}

			reportDTO.setLineitems(lineitemDTOs);
			reportDTO.setBillNoDetails(bill.getBillNo() + " " + bill.getBillDate());
			reportDTO.setDate(bill.getBillDate());
			reportDTO.setInwardNo(gateentry.getHdrId());

			reportDTO.setOrderNo(pohdr.getId());

			// reportDTO.setSign(sign);
			reportDTO.setPartyName(supplier.getsuppName());

			reportDTO.setSrNo(bill.getBillPassTransNo());
			hostorebillpassreport.add(reportDTO);
		});

		return hostorebillpassreport;
	}

	@Override
	public List<HOStoresReceiptCumBillPassReportDTO> getAllHOStoresReceiptCumBillPassReportNew(Date startDate, Date endDate) {
		List<HOStoresReceiptCumBillPassReportDTO> hostorereportsrhdr = new ArrayList<>();
		try {
			List<ScmSrHdr> srhdrs = srhdrDao.getAllApprovedSrBySrDateBetween(startDate, endDate);
			srhdrs.forEach(hdr -> {
				hostorereportsrhdr.add(prepareHoStoreReportDTO(hdr));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hostorereportsrhdr;
	}

	private HOStoresReceiptCumBillPassReportDTO prepareHoStoreReportDTO(ScmSrHdr hdr) {
		HOStoresReceiptCumBillPassReportDTO storeretordto = new HOStoresReceiptCumBillPassReportDTO();
		SupplierMaster supplier = supplierDao.findSupplierMasterById(hdr.getSuppCode());
		POHeader pohdr = hdrDao.getPOHeaderById(hdr.getPoNum());
		// List<POHeader> pohdr = hdrDao.getPOHeadersBySuppCOde(supplier.getId());
		List<POLineItem> lineitems = lineitemDao.getPOLineItemByPoNo(pohdr.getId());
		GateStoreEntryRegHdr entryhdr = gateentryDao.getGateStoreEntryRegHdrByPoNo(pohdr.getId());
		BillPass billpasses = billDao.getAllBillPassByPO(pohdr.getId());
		List<ScmSrLineItem> srlineitems = srlineitemDao.getScmSrLineItemByReceiveNo(hdr.getStoreReceiveNo());

		List<POLineItemDTO> lineitemDTOs = new ArrayList<>();

		for (int i = 0; i < lineitems.size(); i++) {
			ItemMaster item = itemDao.getItemMasterById(lineitems.get(i).getItemId());

			POLineItemDTO lineitemDTO = new POLineItemDTO();

			lineitemDTO.setAcceptedQnt(srlineitems.get(i).getActualQnt());
			lineitemDTO.setDescription(item.getitemDsc());
			lineitemDTO.setMake(item.getmake());
			lineitemDTO.setRate(srlineitems.get(i).getReceivedPrice());
			lineitemDTO.setUom(lineitems.get(i).getUnitId());
			lineitemDTO.setItemCode(item.getgrpCode() + item.getlegacyItemCode());
			lineitemDTO.setAmmount(srlineitems.get(i).getActualQnt() * srlineitems.get(i).getReceivedPrice());

			lineitemDTOs.add(lineitemDTO);
		}

		if (billpasses != null)
			storeretordto.setBillNoDetails(billpasses.getBillNo() + " " + billpasses.getBillDate());

		storeretordto.setDate(entryhdr.getInDate());
		storeretordto.setDate1(hdr.getStoreReceiveDt());
		storeretordto.setInwardNo(entryhdr.getHdrId());
		storeretordto.setLineitems(lineitemDTOs);
		storeretordto.setOrderNo(pohdr.getId());
		storeretordto.setPartyName(supplier.getsuppName());
		storeretordto.setSign("SLS COMPTECH");
		storeretordto.setSrNo(hdr.getStoreReceiveNo());

		return storeretordto;
	}

	@Override
	public List<HOStoresReceiptCumBillPassReportDTO> getAllHOStoresReceiptCumBillPassReportNewBySuppCode(
			String suppCode) {
		List<HOStoresReceiptCumBillPassReportDTO> hostorereportsrhdr = new ArrayList<>();
		try {
			List<ScmSrHdr> srhdrs = srhdrDao.getAllSrHdrBySuppCode(suppCode);
			srhdrs.forEach(hdr -> {
				hostorereportsrhdr.add(prepareHoStoreReportDTO(hdr));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hostorereportsrhdr;
	}

	@Override
	public List<InwardRegisterReportDTO> getAllInwardRegisterReport() {
		List<InwardRegisterReportDTO> inwardRepoprtDTOs = new ArrayList<>();
		try {
			List<GateStoreEntryRegHdr> entryhdrs = entryDao.getAllGateStoreEntryRegHdr();
			entryhdrs.forEach(entry -> {
				inwardRepoprtDTOs.add(prepareInwardReportDTO(entry));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inwardRepoprtDTOs;
	}

	private InwardRegisterReportDTO prepareInwardReportDTO(GateStoreEntryRegHdr entry) {
		InwardRegisterReportDTO inwardreportDTO = new InwardRegisterReportDTO();
		SupplierMaster supplier = supplierDao.findSupplierMasterById(entry.getSuppCode());
		List<GateStoreEntryRegDtl> entrydtl = entrydtlDao.getEntryDtlByHdrId(entry.getHdrId());
		POHeader hdr = pohdrDao.getPOHeaderById(entry.getPoNo());
		ScmSrHdr srhdr = srDao.getScmSrHdrByPoNo(hdr.getId());
		List<ScmSrLineItem> srlineitems = srlineitemDao.getScmSrLineItemByReceiveNo(srhdr.getStoreReceiveNo());
		List<POLineItem> lineitems = lineitemDao.getPOLineItemByPoNo(hdr.getId());

		List<InwardReportDTO> inwardDTOs = new ArrayList<>();
		long issueQnt = 0;
		for (int k = 0; k < srlineitems.size(); k++) {
			issueQnt = issueQnt + srlineitems.get(k).getIssuableQnt();
		}
		for (int i = 0; i < entrydtl.size(); i++) {
			InwardReportDTO inwardDTO = new InwardReportDTO();

			ItemMaster item = itemDao.getItemMasterById(entrydtl.get(i).getItemCode());
			String itemgroup = item.getgrpCode();
			UomMaster uom = uomDao.getUomMasterById(item.getuomCode());
			List<ItemGroupDept> itemgorupdept = groupdeptDao.getItemGroupDeptMappingByItemGroup(itemgroup);

			/*
			 * List<IssueLineItem> issues =
			 * issuelineitemDao.getIssueLineItemByItemId(item.getId());
			 * 
			 * for(int j = 0 ; j < issues.size() ; i++) { issueQnt = issueQnt +
			 * issues.get(j).getIssueQuantity(); }
			 */

			inwardDTO.setItemDesc(item.getitemDsc());
			inwardDTO.setItemCode(item.getgrpCode() + " " + item.getlegacyItemCode());
			inwardDTO.setChallanQnt(entrydtl.get(i).getQuantity());
			inwardDTO.setDept(entrydtl.get(i).getDept());
			inwardDTO.setUnit(uom.getuomDsc());

			inwardDTOs.add(inwardDTO);

		}

		inwardreportDTO.setAmmndNo(entry.getPoNo());
		inwardreportDTO.setChallanNoDate(entry.getChallanNo() + " " + entry.getChallanDate());
		inwardreportDTO.setPoDate(hdr.getPoDate());
		inwardreportDTO.setDate2(null);
		inwardreportDTO.setEntryDate(entry.getInDate());
		inwardreportDTO.setIndentSrlNo(entry.getPoNo());
		inwardreportDTO.setInwardNo(entry.getHdrId());
		inwardreportDTO.setPartyName(entry.getSupplierName());
		if (srhdr != null) {
			inwardreportDTO.setRegNo(srhdr.getStoreReceiveNo());
			inwardreportDTO.setSrNo(srhdr.getStoreNo());
			inwardreportDTO.setSrType(srhdr.getSrGoodReceptStatus());
		}
		inwardreportDTO.setRegNo1(0);
		inwardreportDTO.setInwardreports(inwardDTOs);
		inwardreportDTO.setRejectedQnt(issueQnt);

		return inwardreportDTO;
	}

	@Override
	public List<MillStoreRecieptRegisterDTO> getAllMillStoreRecieptRegister(Date startDate, Date endDate) {
		List<MillStoreRecieptRegisterDTO> storereport = new ArrayList<>();
		try {
			List<ScmSrHdr> srhdrs = srhdrDao.getAllApprovedSrBySrDateBetween(startDate, endDate);
			srhdrs.forEach(hdr -> {
				storereport.add(prepareMillStoreReportDTO(hdr));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return storereport;
	}

	private MillStoreRecieptRegisterDTO prepareMillStoreReportDTO(ScmSrHdr hdr) {
		MillStoreRecieptRegisterDTO storereportDTO = new MillStoreRecieptRegisterDTO();
		SupplierMaster supplier = supplierDao.findSupplierMasterById(hdr.getSuppCode());
		ScmSrLineItem lineitem = srlineitemDao.getScmSrLineItemByReceiveNo(hdr.getStoreReceiveNo()).get(0);

		storereportDTO.setAmount(lineitem.getAdvisedQnt());
		storereportDTO.setChallanDate(hdr.getChallanDate());
		storereportDTO.setChallanNo(hdr.getChallanNo());
		storereportDTO.setPartyName(supplier.getsuppName());
		storereportDTO.setSrDate(hdr.getStoreReceiveDt());
		storereportDTO.setSrNum(hdr.getStoreReceiveNo());

		return storereportDTO;
	}

	@Override
	public MillStoreRecieptRegisterDTO getAllMillStoreRecieptRegisterByReceiveNo(long receiveNo) {
		return prepareMillStoreReportDTO(srhdrDao.getScmSrHdrById(receiveNo));
	}

	@Override
	public List<StoreApprovalNoteDTO> getAllStoreApprovalNote(Date srDate) {
		List<StoreApprovalNoteDTO> storeapprovalnoteDTOs = new ArrayList<>();
		try {
			List<ScmSrHdr> srhdr = srhdrDao.getAllApprovedSrBySrDate(srDate);
			srhdr.forEach(hdr -> {
				storeapprovalnoteDTOs.add(preparestoreaprrovalnoteDTO(hdr));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return storeapprovalnoteDTOs;
	}

	private StoreApprovalNoteDTO preparestoreaprrovalnoteDTO(ScmSrHdr hdr) {
		StoreApprovalNoteDTO storeapprovalnote = new StoreApprovalNoteDTO();
		List<ScmSrLineItem> srlineitem = srlineitemDao.getScmSrLineItemByReceiveNo(hdr.getStoreReceiveNo());
		POHeader pohdr = pohdrDao.getPOHeaderById(hdr.getPoNum());
		GateStoreEntryRegHdr entrystore = entryDao.getGateStoreEntryHdrByPoNoAndChallanNo(hdr.getPoNum(),
				hdr.getChallanNo());

		// storeapprovalnote.setApprovalNo(approvalNo);
		storeapprovalnote.setChalandate(hdr.getChallanDate());
		storeapprovalnote.setChallanNO(hdr.getChallanNo());
		storeapprovalnote.setcNoteNo(hdr.getPoNum() + "/" + hdr.getStoreReceiveNo());
		// storeapprovalnote.setDept(dept);
		storeapprovalnote.setInDate(entrystore.getInDate());
		storeapprovalnote.setInwardno(entrystore.getHdrId());
		storeapprovalnote.setpCode(hdr.getPoNum());
		storeapprovalnote.setPoDate(hdr.getPoDate());

		List<StoreApprovalLineIteDTO> lineitems = new ArrayList<>();
		for (int i = 0; i < srlineitem.size(); i++) {
			StoreApprovalLineIteDTO lineitem = new StoreApprovalLineIteDTO();
			ItemMaster item = itemDao.getItemMasterById(srlineitem.get(i).getLineitemdetails());

			lineitem.setDescription(item.getitemDsc());
			lineitem.setItemCode(item.getgrpCode() + item.getlegacyItemCode());
			lineitem.setMake(item.getmake());
			lineitem.setSrl(srlineitem.get(i).getLineitemno());
			lineitem.setUnit(item.getuomCode());

			lineitems.add(lineitem);
		}

		storeapprovalnote.setStoreApprovalLineItemDTOs(lineitems);

		return storeapprovalnote;
	}

	@Override
	public List<StoreReceiptNoteReportDTO> getAllStoreReceiptNoteReport(Date date) {
		List<StoreReceiptNoteReportDTO> storereceipt = new ArrayList<>();
		try {
			List<ScmSrHdr> entryhdrs = srhdrDao.getAllSrBySrDate(date);
			entryhdrs.forEach(hdr -> {
				storereceipt.add(prepareStoreRecieptDTO(hdr));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return storereceipt;
	}

	private StoreReceiptNoteReportDTO prepareStoreRecieptDTO(ScmSrHdr hdr) {
		StoreReceiptNoteReportDTO storereceipt = new StoreReceiptNoteReportDTO();
		List<ScmSrLineItem> lineitems = srlineitemDao.getScmSrLineItemByReceiveNo(hdr.getStoreReceiveNo());
		GateStoreEntryRegHdr entryhdr = entryDao.getGateStoreEntryRegHdrByChallanNoAndSuppCode(hdr.getSuppCode(),
				hdr.getChallanNo());
		POHeader pohdr = pohdrDao.getPOHeaderById(hdr.getPoNum());

		storereceipt.setChalanDate(hdr.getChallanDate());
		storereceipt.setChallanNo(hdr.getChallanNo());
		storereceipt.setDelivery(pohdr.getDeliveryTimeline());
		storereceipt.setDiscount(pohdr.getDiscount());
		storereceipt.setExcise(pohdr.getTax());
		storereceipt.setInDate(entryhdr.getInDate());
		storereceipt.setPono(hdr.getPoNum());
		// storereceipt.setrNote(rNote);
		// storereceipt.setRound(round);
		storereceipt.setSrDate(hdr.getStoreReceiveDt());
		storereceipt.setSrno(hdr.getStoreReceiveNo());
		storereceipt.setSurCharge(pohdr.getFrieghtCharge());
		// storereceipt.setTotalDed(totalDed);
		// storereceipt.setVat(vat);

		List<StoreReceiptNoteLineDTO> lines = new ArrayList<>();
		float excise = 0.0f;
		float grossAmount = 0.0f;
		for (int i = 0; i < lineitems.size(); i++) {
			StoreReceiptNoteLineDTO line = new StoreReceiptNoteLineDTO();
			ItemMaster item = itemDao.getItemMasterById(lineitems.get(i).getLineitemdetails());

			line.setAmount((lineitems.get(i).getActualQnt()) * (lineitems.get(i).getReceivedPrice()));
			line.setItemCodeUnit(item.getgrpCode() + item.getlegacyItemCode() + "/" + item.getuomCode());
			line.setItemDescMake(item.getitemDsc() + " " + item.getmake());
			line.setQuantity(lineitems.get(i).getActualQnt());
			line.setRate(lineitems.get(i).getReceivedPrice());

			grossAmount = grossAmount + ((lineitems.get(i).getActualQnt()) * (lineitems.get(i).getReceivedPrice()));

			lines.add(line);
		}

		storereceipt.setLines(lines);
		storereceipt.setGrossAmount(grossAmount);
		storereceipt.setNetAmount(grossAmount + ((pohdr.getFrieghtCharge() / grossAmount) * 100));
		return storereceipt;
	}

	@Override
	public List<StoreReportIndentIN01DTO> getAllStoreReportIndentIN01() {
		// TODO Auto-generated method stub
		return null;
	}

}
