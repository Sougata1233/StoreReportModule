package com.sls.report.services.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sls.report.component.BillPassComponent;
import com.sls.report.component.ItemMasterComponent;
import com.sls.report.component.POHdrComponent;
import com.sls.report.component.POLineItemComponent;
import com.sls.report.component.ScmSrHdrComponent;
import com.sls.report.component.ScmSrLineItemComponent;
import com.sls.report.component.SupplierMasterDao;
import com.sls.report.component.UomMasterComponent;
import com.sls.report.dto.VatDetailReportDTO;
import com.sls.report.dto.VatReportSummaryDTO;
import com.sls.report.dto.VatReportWithRespectToGstDTO;
import com.sls.report.dto.VatSummaryReportDTO;
import com.sls.report.entity.BillPass;
import com.sls.report.entity.ItemMaster;
import com.sls.report.entity.ItemTax;
import com.sls.report.entity.POHeader;
import com.sls.report.entity.POLineItem;
import com.sls.report.entity.ScmSrHdr;
import com.sls.report.entity.ScmSrLineItem;
import com.sls.report.entity.SupplierMaster;
import com.sls.report.repository.ItemTaxRepository;
import com.sls.report.services.VatReportService;



@Service
public class VatReportServiceImpl implements VatReportService {
	@Autowired
	ScmSrHdrComponent srhdrDao;

	@Autowired
	ScmSrLineItemComponent srlineDao;

	@Autowired
	ItemMasterComponent itemDao;

	@Autowired
	UomMasterComponent uomDao;

	@Autowired
	SupplierMasterDao supplierDao;

	@Autowired
	POHdrComponent pohdrDao;

	@Autowired
	BillPassComponent billDao;
	
	@Autowired
	POLineItemComponent polineDao;
	
	@Autowired
	ItemTaxRepository itemtaxRepository;

	@Override
	public List<VatReportWithRespectToGstDTO> getVatReportWithRespectToGstDTO(Date startDate, Date endDate) {
		List<VatReportWithRespectToGstDTO> reportDTO = new ArrayList<>();
		List<ScmSrHdr> srhdrs = srhdrDao.getAllSrHdrByReceiptDate(startDate, endDate);
		for (int i = 0; i < srhdrs.size(); i++) {
			List<ScmSrLineItem> srlines = srlineDao.getScmSrLineItemByReceiveNo(srhdrs.get(i).getStoreReceiveNo());
			for (int j = 0; j < srlines.size(); j++) {
				reportDTO.add(prepareReportDTO(srlines.get(j), srhdrs.get(i)));
			}
		}
		return reportDTO;
	}

	private VatReportWithRespectToGstDTO prepareReportDTO(ScmSrLineItem scmSrLineItem, ScmSrHdr scmSrHdr) {
		VatReportWithRespectToGstDTO reportDTO = new VatReportWithRespectToGstDTO();
		ItemMaster item = itemDao.getItemMasterById(scmSrLineItem.getLineitemdetails());
		SupplierMaster supplier = supplierDao.findSupplierMasterById(scmSrHdr.getSuppCode());
		POHeader pohdr = pohdrDao.getPOHeaderById(scmSrHdr.getPoNum());
		List<BillPass> bill = billDao.getAllBillPass();
		List<BillPass> bills = bill.stream()
				.filter(x -> x.getSrMrNum().equalsIgnoreCase(String.valueOf(scmSrHdr.getStoreReceiveNo())))
				.collect(Collectors.toList());
		Date billDate = null;
		String billNumber = null;
		if (bills.size() > 0) {
			billDate = bills.get(0).getBillDate();
			billNumber = bills.get(0).getBillNo();
		}

		reportDTO.setBillDate(billDate);
		reportDTO.setBillNumber(billNumber);
		reportDTO.setItemCode(scmSrLineItem.getLineitemdetails());
		reportDTO.setItemDesc(item.getitemDsc());
		reportDTO.setSrDate(scmSrHdr.getStoreReceiveDt());
		reportDTO.setSrNo(String.valueOf(scmSrHdr.getStoreReceiveNo()));
		reportDTO.setSrQnt(scmSrLineItem.getActualQnt());
		reportDTO.setSrValue(scmSrLineItem.getActualQnt() * scmSrLineItem.getReceivedPrice());
		reportDTO.setSuppName(supplier.getsuppName());
		reportDTO.setUom(scmSrLineItem.getUom());
		reportDTO.setVatAmt(pohdr.getValueWithTax() - pohdr.getValueWithoutTax());

		return reportDTO;
	}

	@Override
	public List<VatDetailReportDTO> getVatDetailReportDTO(Date startDate, Date endDate) {
		List<VatDetailReportDTO> reportDTOs = new ArrayList<>();
		List<ScmSrHdr> srhdrs = srhdrDao.getAllSrHdrByReceiptDate(startDate, endDate);
		for (int i = 0; i < srhdrs.size(); i++) {
			List<ScmSrLineItem> srlines = srlineDao.getScmSrLineItemByReceiveNo(srhdrs.get(i).getStoreReceiveNo());
			for (int j = 0; j < srlines.size(); j++) {
				reportDTOs.add(prepareDetailReportDTO(srhdrs.get(i), srlines.get(j)));
			}
		}
		return reportDTOs;
	}

	private VatDetailReportDTO prepareDetailReportDTO(ScmSrHdr scmSrHdr, ScmSrLineItem scmSrLineItem) {
		VatDetailReportDTO reportDTO = new VatDetailReportDTO();
		SupplierMaster supplier = supplierDao.findSupplierMasterById(scmSrHdr.getSuppCode());
		POHeader pohdr = pohdrDao.getPOHeaderById(scmSrHdr.getPoNum());
		List<BillPass> bill = billDao.getAllBillPass();
		List<BillPass> bills = bill.stream()
				.filter(x -> x.getSrMrNum().equalsIgnoreCase(String.valueOf(scmSrHdr.getStoreReceiveNo())))
				.collect(Collectors.toList());
		Date billDate = null;
		String billNumber = null;
		if (bills.size() > 0) {
			billDate = bills.get(0).getBillDate();
			billNumber = bills.get(0).getBillNo();
		}

		reportDTO.setBillDate(billDate);
		reportDTO.setBillNumber(billNumber);
		reportDTO.setSrDate(scmSrHdr.getStoreReceiveDt());
		reportDTO.setSrNo(String.valueOf(scmSrHdr.getStoreReceiveNo()));
		reportDTO.setSrQnt(scmSrLineItem.getActualQnt());
		reportDTO.setSrValue(scmSrLineItem.getActualQnt() * scmSrLineItem.getReceivedPrice());
		reportDTO.setSuppName(supplier.getsuppName());
		reportDTO.setVatAmt(pohdr.getValueWithTax() - pohdr.getValueWithoutTax());

		return reportDTO;
	}

	@Override
	@Transactional
	public List<VatSummaryReportDTO> getVatSummaryReport(Date startDate, Date endDate) {
		List<VatSummaryReportDTO> dtos = new ArrayList<>();
		List<VatSummaryReportDTO> dtos2 = new ArrayList<>();
		List<POLineItem> polineitems = new ArrayList<>();
//		try {
			List<POHeader> pohdrs = pohdrDao.getApprovedPOHeaderBetweenByPODate(startDate, endDate);
			int posize = pohdrs.size();
			float grossAmt5 = 0.0f;
			float grossAmt9 = 0.0f;
			float grossAmt18 = 0.0f;
			float grossAmt28 = 0.0f;
			
			float vatAmt5 = 0.0f;
			float vatAmt9 = 0.0f;
			float vatAmt18 = 0.0f;
			float vatAmt28 = 0.0f;
			for(int i = 0 ; i < posize ; i++) {
				polineitems = polineDao.getPOLineItemByPoNo(pohdrs.get(i).getId());
				int lineitemsize = polineitems.size();
				if(!pohdrs.get(i).getType().equalsIgnoreCase("J")) {
					dtos.add(prepareVatSummaryReportDTO(polineitems));
				}
			}
			List<String> vatperdist = 
					dtos.stream().map(VatSummaryReportDTO::getVatPercentage).distinct().collect(Collectors.toList());
			for(int j = 0 ; j < dtos.size() ; j++) {
				vatAmt5 = vatAmt5 + Float.parseFloat(dtos.get(j).getVatAmt5());
				vatAmt9 = vatAmt9 + Float.parseFloat(dtos.get(j).getVatAmt9());
				vatAmt18 = vatAmt18 + Float.parseFloat(dtos.get(j).getVatAmt18());
				vatAmt28 = vatAmt28 + Float.parseFloat(dtos.get(j).getVatAmt28());
				
				grossAmt5 = grossAmt5 + Float.parseFloat(dtos.get(j).getGrossAmt5());
				grossAmt9 = grossAmt9 + Float.parseFloat(dtos.get(j).getGrossAmt9());
				grossAmt18 = grossAmt18 + Float.parseFloat(dtos.get(j).getGrossAmt18());
				grossAmt28 = grossAmt28 + Float.parseFloat(dtos.get(j).getGrossAmt28());
			}
			for(int k = 0 ; k < vatperdist.size(); k++) {
				VatSummaryReportDTO dto = new VatSummaryReportDTO();
				
				dto.setVatPercentage(vatperdist.get(k));
				
				if(vatperdist.get(k)!=null) {
					if(vatperdist.get(k).equalsIgnoreCase("5")) {
						dto.setGrossAmt5(String.valueOf(grossAmt5));
						dto.setVatAmt5(String.valueOf(vatAmt5));
					}
					if(vatperdist.get(k).equalsIgnoreCase("12")) {
						dto.setGrossAmt9(String.valueOf(grossAmt9));
						dto.setVatAmt9(String.valueOf(vatAmt9));
					}
					if(vatperdist.get(k).equalsIgnoreCase("18")) {
						dto.setGrossAmt18(String.valueOf(grossAmt18));
						dto.setVatAmt18(String.valueOf(vatAmt18));
					}
					if(vatperdist.get(k).equalsIgnoreCase("28")) {
						dto.setGrossAmt28(String.valueOf(grossAmt28));
						dto.setVatAmt28(String.valueOf(vatAmt28));
					}
				}
				
				dtos2.add(dto);
			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		System.out.println(dtos);
		
		return dtos2.stream().distinct().collect(Collectors.toList());
	}

	private VatSummaryReportDTO prepareVatSummaryReportDTO(List<POLineItem> polineitems) {
		VatSummaryReportDTO dto = new VatSummaryReportDTO();
		
		int vat5 = 5;
		int vat12 = 12;
		int vat18 = 18;
		int vat28 = 28;
		
		float grossAmt5 = 0.0f;
		float grossAmt9 = 0.0f;
		float grossAmt18 = 0.0f;
		float grossAmt28 = 0.0f;
		
		float vatAmt5 = 0.0f;
		float vatAmt9 = 0.0f;
		float vatAmt18 = 0.0f;
		float vatAmt28 = 0.0f;
		
		for(int i = 0 ; i < polineitems.size(); i++) {
			ItemMaster item = itemDao.getItemMasterById(polineitems.get(i).getItemId());
			ItemTax itemtax = itemtaxRepository.findByHsnCode(item.gethsnCode());
			if(itemtax!=null) {
				if(itemtax.getGst()==5) {
					dto.setVatPercentage(String.valueOf(vat5));
					grossAmt5 = grossAmt5 + (polineitems.get(i).getValueWithoutTax()+polineitems.get(i).getTax());
					vatAmt5 = vatAmt5 + polineitems.get(i).getTax();
				}else if(itemtax.getGst()==12) {
					dto.setVatPercentage(String.valueOf(vat12));
					grossAmt9 = grossAmt9 + (polineitems.get(i).getValueWithoutTax()+polineitems.get(i).getTax());
					vatAmt9 = vatAmt9 + polineitems.get(i).getTax();
				}else if(itemtax.getGst()==18) {
					dto.setVatPercentage(String.valueOf(vat18));
					grossAmt18 = grossAmt18 + (polineitems.get(i).getValueWithoutTax()+polineitems.get(i).getTax());
					vatAmt18 = vatAmt18 + polineitems.get(i).getTax();
				}else if(itemtax.getGst()==28) {
					dto.setVatPercentage(String.valueOf(vat28));
					grossAmt28 = grossAmt28 + (polineitems.get(i).getValueWithoutTax()+polineitems.get(i).getTax());
					vatAmt28 = vatAmt28 + polineitems.get(i).getTax();
				}
			}
		}
		
		dto.setGrossAmt5(String.valueOf(grossAmt5));
		dto.setVatAmt5(String.valueOf(vatAmt5));
		
		dto.setGrossAmt9(String.valueOf(grossAmt9));
		dto.setVatAmt9(String.valueOf(vatAmt9));
		
		dto.setGrossAmt18(String.valueOf(grossAmt18));
		dto.setVatAmt18(String.valueOf(vatAmt18));
		
		dto.setGrossAmt28(String.valueOf(grossAmt28));
		dto.setVatAmt28(String.valueOf(vatAmt28));
//		System.out.println()
		return dto;
	}

	@Override
	public VatReportSummaryDTO getVatReportSummary(Date startDate, Date endDate) {
		VatReportSummaryDTO dtos = new VatReportSummaryDTO();
		
		List<ItemTax> taxs = itemtaxRepository.findAll();
		Float tax5 = 0.0F;
		Float tax9 = 0.0F;
		Float tax12 = 0.0F;
		Float tax18 = 0.0F;
		Float tax28 = 0.0F;
		for(int i = 0 ; i < taxs.size() ; i++) {
			if(taxs.get(i).getGst()==5) {
				List<ItemMaster> item = itemDao.getItemMasterByHsnCode(taxs.get(i).getHsnCode());
				for(int j = 0 ; j < item.size(); j++) {
					if(!item.get(j).getgrpCode().equalsIgnoreCase("999")) {
						List<POLineItem> poline = polineDao.getPOLineItemByItemCode(item.get(j).getId());
						for(int k = 0 ; k < poline.size(); k++) {
							tax5 = tax5 + poline.get(k).getTax();
						}
					}
				}
			}else if(taxs.get(i).getGst()==9) {
				List<ItemMaster> item = itemDao.getItemMasterByHsnCode(taxs.get(i).getHsnCode());
				for(int j = 0 ; j < item.size(); j++) {
					if(!item.get(j).getgrpCode().equalsIgnoreCase("999")) {
						List<POLineItem> poline = polineDao.getPOLineItemByItemCode(item.get(j).getId());
						for(int k = 0 ; k < poline.size(); k++) {
							tax9 = tax9 + poline.get(k).getTax();
						}
					}
					
				}
			}else if(taxs.get(i).getGst()==12) {
				List<ItemMaster> item = itemDao.getItemMasterByHsnCode(taxs.get(i).getHsnCode());
				for(int j = 0 ; j < item.size(); j++) {
					if(!item.get(j).getgrpCode().equalsIgnoreCase("999")) {
						List<POLineItem> poline = polineDao.getPOLineItemByItemCode(item.get(j).getId());
						for(int k = 0 ; k < poline.size(); k++) {
							tax12 = tax12 + poline.get(k).getTax();
						}
					}
					
				}
			}else if(taxs.get(i).getGst()==18) {
				List<ItemMaster> item = itemDao.getItemMasterByHsnCode(taxs.get(i).getHsnCode());
				for(int j = 0 ; j < item.size(); j++) {
					if(!item.get(j).getgrpCode().equalsIgnoreCase("999")) {
						List<POLineItem> poline = polineDao.getPOLineItemByItemCode(item.get(j).getId());
						for(int k = 0 ; k < poline.size(); k++) {
							tax18 = tax18 + poline.get(k).getTax();
						}
					}
					
				}
			}else if(taxs.get(i).getGst()==28) {
				List<ItemMaster> item = itemDao.getItemMasterByHsnCode(taxs.get(i).getHsnCode());
				for(int j = 0 ; j < item.size(); j++) {
					if(!item.get(j).getgrpCode().equalsIgnoreCase("999")) {
						List<POLineItem> poline = polineDao.getPOLineItemByItemCode(item.get(j).getId());
						for(int k = 0 ; k < poline.size(); k++) {
							tax28 = tax28 + poline.get(k).getTax();
						}
					}
					
				}
			}
		}
		dtos.setTax12(String.valueOf(tax12));
		dtos.setTax18(String.valueOf(tax18));
		dtos.setTax28(String.valueOf(tax28));
		dtos.setTax5(String.valueOf(tax5));
		dtos.setTax9(String.valueOf(tax9));
//		dtos.setVatPercentage(vatPercentage);
		return dtos;
	}
	
	@Override
	@Transactional
	public List<VatSummaryReportDTO> getVatSummaryReport1(Date startDate, Date endDate) {
		List<VatSummaryReportDTO> dtos = new ArrayList<>();
		
		List<ItemTax> taxs = itemtaxRepository.findAll();
		/*List<POHeader> pohdrs = pohdrDao.getAllPOHeaderByPODate(startDate, endDate);
		int posize = pohdrs.size();
		for(int i = 0 ; i < posize ; i++) {
			List<POLineItem> poline = polineDao.getPOLineItemByPoNo(pohdrs.get(i).getId());
		}*/
		List<ItemMaster> itemcodes = new ArrayList<>();
		List<String> disthsn = taxs.stream().map(ItemTax::getHsnCode).distinct().collect(Collectors.toList());
		List<Integer> distgst = taxs.stream().map(ItemTax::getGst).distinct().collect(Collectors.toList());
		/*for(int j = 0 ; j < disthsn.size(); j++) {
			itemcodes = itemDao.getItemMasterByHsnCode(disthsn.get(j));
		}*/
		List<ItemTax> taxsdistgst = new ArrayList<>();
		for(int k = 0 ; k < distgst.size() ; k++) {
			taxsdistgst = itemtaxRepository.findByGst(distgst.get(k));
			dtos.add(preparevatsummaryreportDTO(taxs));
		}
		
		System.out.println(taxs);
		System.out.println(taxs.size());
		
		System.out.println(taxsdistgst);
		System.out.println(taxsdistgst.size());
		
		return dtos;
	}

	private VatSummaryReportDTO preparevatsummaryreportDTO(List<ItemTax> taxs) {
		VatSummaryReportDTO dto = new VatSummaryReportDTO();
		
		int vat5 = 0;
		int vat9 = 0;
		int vat18 = 0;
		int vat28 = 0;
		
		float grossAmt5 = 0.0f;
		float grossAmt9 = 0.0f;
		float grossAmt18 = 0.0f;
		float grossAmt28 = 0.0f;
		
		float vatAmt5 = 0.0f;
		float vatAmt9 = 0.0f;
		float vatAmt18 = 0.0f;
		float vatAmt28 = 0.0f;
		
		for(int i = 0 ; i < taxs.size() ; i++) {
			if(taxs.get(i).getGst()==5) {
				List<ItemMaster> item = itemDao.getItemMasterByHsnCode(taxs.get(i).getHsnCode());
				for(int j = 0 ; j < item.size(); j++) {
					if(!item.get(j).getgrpCode().equalsIgnoreCase("999")) {
						List<POLineItem> poline = polineDao.getPOLineItemByItemCode(item.get(j).getId());
						for(int k = 0 ; k < poline.size(); k++) {
							vat5 = (int) (vat5 + poline.get(k).getTax());
							grossAmt5 = grossAmt5 + (poline.get(k).getTax() + poline.get(k).getValueWithoutTax());
						}
					}
				}
			}else if(taxs.get(i).getGst()==9) {
				List<ItemMaster> item = itemDao.getItemMasterByHsnCode(taxs.get(i).getHsnCode());
				for(int j = 0 ; j < item.size(); j++) {
					if(!item.get(j).getgrpCode().equalsIgnoreCase("999")) {
						List<POLineItem> poline = polineDao.getPOLineItemByItemCode(item.get(j).getId());
						for(int k = 0 ; k < poline.size(); k++) {
							vat9 = (int) (vat9 + poline.get(k).getTax());
							grossAmt9 = grossAmt9 + (poline.get(k).getTax() + poline.get(k).getValueWithoutTax());
						}
					}
					
				}
			}else if(taxs.get(i).getGst()==18) {
				List<ItemMaster> item = itemDao.getItemMasterByHsnCode(taxs.get(i).getHsnCode());
				for(int j = 0 ; j < item.size(); j++) {
					if(!item.get(j).getgrpCode().equalsIgnoreCase("999")) {
						List<POLineItem> poline = polineDao.getPOLineItemByItemCode(item.get(j).getId());
						for(int k = 0 ; k < poline.size(); k++) {
							vat18 = (int) (vat18 + poline.get(k).getTax());
							grossAmt18 = grossAmt18 + (poline.get(k).getTax() + poline.get(k).getValueWithoutTax());
						}
					}
					
				}
			}else if(taxs.get(i).getGst()==28) {
				List<ItemMaster> item = itemDao.getItemMasterByHsnCode(taxs.get(i).getHsnCode());
				for(int j = 0 ; j < item.size(); j++) {
					if(!item.get(j).getgrpCode().equalsIgnoreCase("999")) {
						List<POLineItem> poline = polineDao.getPOLineItemByItemCode(item.get(j).getId());
						for(int k = 0 ; k < poline.size(); k++) {
							vat28 = (int) (vat28 + poline.get(k).getTax());
							grossAmt28 = grossAmt28 + (poline.get(k).getTax() + poline.get(k).getValueWithoutTax());
						}
					}
					
				}
			}
		}
		
		dto.setGrossAmt5(String.valueOf(grossAmt5));
		dto.setVatAmt5(String.valueOf(vatAmt5));
		
		dto.setGrossAmt9(String.valueOf(grossAmt9));
		dto.setVatAmt9(String.valueOf(vatAmt5));
		
		dto.setGrossAmt18(String.valueOf(grossAmt5));
		dto.setVatAmt18(String.valueOf(vatAmt5));
		
		dto.setGrossAmt28(String.valueOf(grossAmt5));
		dto.setVatAmt28(String.valueOf(vatAmt5));
		return dto;
	}

}
