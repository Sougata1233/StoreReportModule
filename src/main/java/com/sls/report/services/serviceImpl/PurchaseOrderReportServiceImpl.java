package com.sls.report.services.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sls.report.component.ItemGroupComponent;
import com.sls.report.component.ItemMasterComponent;
import com.sls.report.component.POHdrComponent;
import com.sls.report.component.POLineItemComponent;
import com.sls.report.component.POLineItemHistComponent;
import com.sls.report.component.ScmIndentHeaderComponent;
import com.sls.report.component.ScmIndentLineItemCompnent;
import com.sls.report.component.ScmSrHdrComponent;
import com.sls.report.component.ScmSrLineItemComponent;
import com.sls.report.component.SupplierMasterDao;
import com.sls.report.dto.AmmendLineitemDTO;
import com.sls.report.dto.OrderCancelLineitemDTO;
import com.sls.report.dto.OrderRegisterDTO;
import com.sls.report.dto.OrderRegisterForHODTO;
import com.sls.report.dto.OrderRegisterLineItemForHODTO;
import com.sls.report.dto.OrderRegisterLineitemDTO;
import com.sls.report.dto.OutstandingPODetailsDTO;
import com.sls.report.dto.OutstandingPOLineitemDTO;
import com.sls.report.dto.PO02ReportDTO;
import com.sls.report.dto.PO02ReportLineDTO;
import com.sls.report.dto.POCancelLineitemReportDTO;
import com.sls.report.dto.POCancelNoteReportLineDTO;
import com.sls.report.dto.POCancelReportDTO;
import com.sls.report.dto.POOrderCancelNoteReportDTO;
import com.sls.report.dto.POOutstandingSrDTO;
import com.sls.report.dto.POOutstandingSummaryDTO;
import com.sls.report.dto.POOutstandingSummaryLineDTO;
import com.sls.report.dto.POReport19DTO;
import com.sls.report.dto.POReport19DTOLineItemDTO;
import com.sls.report.dto.PurchaseOrderCancelDTO;
import com.sls.report.dto.PurchaseOrderHistoryReportDTO;
import com.sls.report.dto.PurchaseOrderHistoryReportLineitemDTO;
import com.sls.report.entity.ItemGroupMaster;
import com.sls.report.entity.ItemMaster;
import com.sls.report.entity.POHeader;
import com.sls.report.entity.POLineItem;
import com.sls.report.entity.POLineItemHist;
import com.sls.report.entity.ScmIndentHeader;
import com.sls.report.entity.ScmIndentLineItem;
import com.sls.report.entity.ScmSrHdr;
import com.sls.report.entity.ScmSrLineItem;
import com.sls.report.entity.SupplierMaster;
import com.sls.report.services.PurchaseOrderReportService;

@Service
public class PurchaseOrderReportServiceImpl implements PurchaseOrderReportService {

	@Autowired
	POHdrComponent pohdrDao;

	@Autowired
	POLineItemComponent polineitemDao;

	@Autowired
	ItemMasterComponent itemDao;

	@Autowired
	SupplierMasterDao supplierDao;

	@Autowired
	ScmSrHdrComponent srhdrDao;

	@Autowired
	ScmSrLineItemComponent srlineitemDao;

	@Autowired
	POLineItemHistComponent lineitemhistDao;

	@Autowired
	ItemGroupComponent groupDao;

	@Autowired
	ScmIndentHeaderComponent indenthdrDao;

	@Autowired
	ScmIndentLineItemCompnent indentlineitemDao;

	@Override
	public List<PurchaseOrderCancelDTO> getAllPurchaseOrderCancel(Date startDate, Date endDate) {
		List<PurchaseOrderCancelDTO> purchaseorderDTOs = new ArrayList<>();
		try {
			List<POHeader> poheaders = pohdrDao.getAllPOHeaderByPODate(startDate, endDate);
			poheaders.forEach(hdr -> {
				if (hdr.getStatus().equalsIgnoreCase("6")) {
					if (!hdr.getId().startsWith("J")) {
						purchaseorderDTOs.add(preparePurchaseOrderDTO(hdr));
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return purchaseorderDTOs;
	}

	private PurchaseOrderCancelDTO preparePurchaseOrderDTO(POHeader hdr) {
		PurchaseOrderCancelDTO purchaseorderDTO = new PurchaseOrderCancelDTO();
		SupplierMaster supplier = supplierDao.findSupplierMasterById(hdr.getSupplierId());
		List<POLineItem> line = polineitemDao.getPOLineItemByPoNo(hdr.getId());

		purchaseorderDTO.setCancelNo(hdr.getId());
		purchaseorderDTO.setDate(hdr.getPoDate());
		purchaseorderDTO.setFinYear(hdr.getFinnacialYear());
		purchaseorderDTO.setOrderNo(hdr.getId());
		purchaseorderDTO.setPartyCode(hdr.getSupplierId());
		purchaseorderDTO.setPartyName(supplier.getsuppName());
		purchaseorderDTO.setReason(hdr.getRemarks());

		List<OrderCancelLineitemDTO> lineitemDTOs = new ArrayList<>();
		for (int i = 0; i < line.size(); i++) {
			OrderCancelLineitemDTO lineitemDTO = new OrderCancelLineitemDTO();
			ItemMaster item = itemDao.getItemMasterById(line.get(i).getItemId());

			lineitemDTO.setCancelQnt(line.get(i).getActualQuantity());
			lineitemDTO.setDescription(item.getitemDsc());
			lineitemDTO.setItemCode(item.getId());
			lineitemDTO.setOrderQnt(line.get(i).getQuantity());
			lineitemDTO.setSrl(line.get(i).getId());
			lineitemDTO.setUnit(line.get(i).getUnitId());

			lineitemDTOs.add(lineitemDTO);
		}

		purchaseorderDTO.setOrdercancellineitems(lineitemDTOs);

		return purchaseorderDTO;
	}

	@Override
	public List<OrderRegisterForHODTO> getAllOrderRegisterForHO(Date startDate, Date endDate) {
		List<OrderRegisterForHODTO> orderregisterDTO = new ArrayList<>();
		try {
			List<POHeader> poheaders = pohdrDao.getAllPOHeaderByPODate(startDate, endDate);
			poheaders.forEach(hdr -> {
				orderregisterDTO.add(prepareOrderRegisterDTO(hdr));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderregisterDTO;
	}

	private OrderRegisterForHODTO prepareOrderRegisterDTO(POHeader hdr) {
		OrderRegisterForHODTO orderregisterDTO = new OrderRegisterForHODTO();
		List<POLineItem> poLineItem = polineitemDao.getPOLineItemByPoNo(hdr.getId());
		ScmSrHdr srhdr = srhdrDao.getScmSrHdrByPoNo(hdr.getId());

		List<ScmSrLineItem> srlineitems = new ArrayList<>();
		if (srhdr != null) {
			srlineitems = srlineitemDao.getScmSrLineItemByReceiveNo(srhdr.getStoreReceiveNo());
		}

		SupplierMaster supplier = supplierDao.findSupplierMasterById(hdr.getSupplierId());

		long srqnt = 0;
		for (int j = 0; j < srlineitems.size(); j++) {
			srqnt = srqnt + srlineitems.get(j).getActualQnt();
		}

		float rejQnt = 0;
		List<OrderRegisterLineItemForHODTO> orderregisDTOs = new ArrayList<>();
		for (int i = 0; i < poLineItem.size(); i++) {
			OrderRegisterLineItemForHODTO orderregisterDTOEmp = new OrderRegisterLineItemForHODTO();
			ItemMaster item = itemDao.getItemMasterById(poLineItem.get(i).getItemId());

			orderregisterDTOEmp.setIndentNo(poLineItem.get(i).getIndentId());
			orderregisterDTOEmp.setItemCode(item.getId());
			orderregisterDTOEmp.setItemDesc(item.getitemDsc());
			orderregisterDTOEmp.setQty(poLineItem.get(i).getActualQuantity());
			orderregisterDTOEmp.setRate(poLineItem.get(i).getRate());

			orderregisterDTOEmp.setSrlNo(poLineItem.get(i).getId());
			orderregisterDTOEmp.setUnit(item.getuomCode());

			rejQnt = rejQnt + poLineItem.get(i).getActualQuantity();

			orderregisDTOs.add(orderregisterDTOEmp);

		}

		orderregisterDTO.setOrderregisLineitems(orderregisDTOs);

		orderregisterDTO.setDeliverSchedule(hdr.getDeliveryTimeline());
		orderregisterDTO.setOrderDate(hdr.getPoDate());
		orderregisterDTO.setOrderNo(hdr.getId());
		orderregisterDTO.setPartyCode(hdr.getSupplierId());
		orderregisterDTO.setPartyName(supplier.getsuppName());
		orderregisterDTO.setRejNote(hdr.getRemarks());
		orderregisterDTO.setRejQty(rejQnt);

		if (srhdr != null) {
			orderregisterDTO.setSrDate(srhdr.getPoDate());
			orderregisterDTO.setSrNo(srhdr.getStoreReceiveNo());
			orderregisterDTO.setSrQty(srqnt);
			orderregisterDTO.setChallanDate(srhdr.getChallanDate());
			orderregisterDTO.setChallanNo(srhdr.getChallanNo());
			orderregisterDTO.setChallanQnty(srqnt);
		}

		return orderregisterDTO;
	}

	@Override
	public List<OrderRegisterDTO> getAllOrderRegisterPartyWise(Date startDate, Date endDate, String partyName) {
		List<OrderRegisterDTO> orderregisDTOs = new ArrayList<>();
		try {
			List<POHeader> poheaders = pohdrDao.getAllPOHeaderByPODate(startDate, endDate);
			poheaders.forEach(hdr -> {
				if (!hdr.getId().startsWith("J")) {
					SupplierMaster supplier = supplierDao.findSupplierMasterById(hdr.getSupplierId());
					if (supplier.getsuppName().equalsIgnoreCase(partyName)) {
						orderregisDTOs.add(prepareOrderRegiDTO(hdr));
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderregisDTOs;
	}

	private OrderRegisterDTO prepareOrderRegiDTO(POHeader hdr) {
		OrderRegisterDTO orderDTO = new OrderRegisterDTO();
		SupplierMaster supplier = supplierDao.findSupplierMasterById(hdr.getSupplierId());
		List<POLineItem> lineitems = polineitemDao.getPOLineItemByPoNo(hdr.getId());

		orderDTO.setDiscount(hdr.getDiscount());
		orderDTO.setOrderNo(hdr.getId());
		orderDTO.setPartyCode(hdr.getSupplierId());
		orderDTO.setPartyName(supplier.getsuppName());
		orderDTO.setSChr(hdr.getFrieghtCharge());
		orderDTO.setExcise(0);

		List<OrderRegisterLineitemDTO> orderlines = new ArrayList<>();
		for (int i = 0; i < lineitems.size(); i++) {
			OrderRegisterLineitemDTO orderline = new OrderRegisterLineitemDTO();
			ItemMaster item = itemDao.getItemMasterById(lineitems.get(i).getItemId());

			POLineItemHist lineitemhist = lineitemhistDao.getPOLineItemHistByPoNumAndLineItemNum(hdr.getId(),
					lineitems.get(i).getId());

			if (lineitemhist != null)
				orderline.setAmmendNo(lineitemhist.getAmmendNo());
			orderline.setDescription(item.getitemDsc());
			orderline.setItemCode(item.getId());
			orderline.setQty(lineitems.get(i).getActualQuantity());
			orderline.setSrl(lineitems.get(i).getId());
			// orderline.setStax(stax);
			orderline.setUnit(lineitems.get(i).getUnitId());

			orderlines.add(orderline);
		}

		orderDTO.setOrderregisterlineitems(orderlines);

		return orderDTO;
	}

	@Override
	public List<OrderRegisterDTO> getAllOrderRegisterGroupWise(Date startDate, Date endDate, String itemGroup) {
		List<OrderRegisterDTO> orderregisDTOs = new ArrayList<>();
		try {
			List<POHeader> poheaders = pohdrDao.getAllPOHeaderByPODate(startDate, endDate);
			poheaders.forEach(hdr -> {
				if (hdr.getId().startsWith("J")) {
					orderregisDTOs.add(prepareOrderRegiGroupWiseDTO(hdr, itemGroup));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderregisDTOs;
	}

	private OrderRegisterDTO prepareOrderRegiGroupWiseDTO(POHeader hdr, String itemGroup) {
		OrderRegisterDTO orderDTO = new OrderRegisterDTO();

		List<POLineItem> lineitems = polineitemDao.getPOLineItemByPoNo(hdr.getId());

		for (int j = 0; j < lineitems.size(); j++) {
			ItemGroupMaster group = groupDao.getItemGroupByGroupgrpdsc(itemGroup);
			if (group != null) {
				if (lineitems.get(j).getItemGroupId().equals(group.getId())) {
					SupplierMaster supplier = supplierDao.findSupplierMasterById(hdr.getSupplierId());
					orderDTO.setDiscount(hdr.getDiscount());
					orderDTO.setOrderNo(hdr.getId());
					orderDTO.setPartyCode(hdr.getSupplierId());
					orderDTO.setPartyName(supplier.getsuppName());
					orderDTO.setSChr(hdr.getFrieghtCharge());
					orderDTO.setExcise(0);

					List<OrderRegisterLineitemDTO> orderlines = new ArrayList<>();
					for (int i = 0; i < lineitems.size(); i++) {
						OrderRegisterLineitemDTO orderline = new OrderRegisterLineitemDTO();
						ItemMaster item = itemDao.getItemMasterById(lineitems.get(i).getItemId());

						POLineItemHist lineitemhist = lineitemhistDao
								.getPOLineItemHistByPoNumAndLineItemNum(hdr.getId(), lineitems.get(i).getId());

						if (lineitemhist != null)
							orderline.setAmmendNo(lineitemhist.getAmmendNo());
						orderline.setDescription(item.getitemDsc());
						orderline.setItemCode(item.getId());
						orderline.setQty(lineitems.get(i).getActualQuantity());
						orderline.setSrl(lineitems.get(i).getId());
						// orderline.setStax(stax);
						orderline.setUnit(lineitems.get(i).getUnitId());

						orderlines.add(orderline);
					}

					orderDTO.setOrderregisterlineitems(orderlines);

				}
			}
		}

		return orderDTO;
	}

	@Override
	public List<POCancelReportDTO> getAllPOCancelReport(Date startDate) {
		List<POCancelReportDTO> cancelreport = new ArrayList<>();
		try {
			List<POHeader> poheaders = pohdrDao.getPOHeaderByPODate(startDate);
			poheaders.forEach(hdr -> {
				cancelreport.add(prepareCancelReportDTO(hdr));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cancelreport;
	}

	private POCancelReportDTO prepareCancelReportDTO(POHeader hdr) {
		POCancelReportDTO cancelreportDTO = new POCancelReportDTO();
		List<POLineItem> lineitems = polineitemDao.getPOLineItemByPoNo(hdr.getId());

		cancelreportDTO.setCancelRefNo(hdr.getId());
		cancelreportDTO.setOrderNo(hdr.getId());
		cancelreportDTO.setsCh(hdr.getFrieghtCharge());

		List<POCancelLineitemReportDTO> cancelorderlineitems = new ArrayList<>();
		for (int i = 0; i < lineitems.size(); i++) {
			POCancelLineitemReportDTO cancelorderlineitem = new POCancelLineitemReportDTO();
			ItemMaster item = itemDao.getItemMasterById(lineitems.get(i).getItemId());

			cancelorderlineitem.setCancelQty(lineitems.get(i).getActualQuantity());
			// cancelorderlineitem.setCst(cst);
			cancelorderlineitem.setDescription(item.getitemDsc());
			cancelorderlineitem.setDisc(lineitems.get(i).getDiscount());
			// cancelorderlineitem.setExcise(excise);
			cancelorderlineitem.setItemCode(item.getId());
			cancelorderlineitem.setPoQty(lineitems.get(i).getActualQuantity());
			cancelorderlineitem.setRate(lineitems.get(i).getRate());
			cancelorderlineitem.setSlNo(lineitems.get(i).getId());
			cancelorderlineitem.setUnit(item.getuomCode());

			cancelorderlineitems.add(cancelorderlineitem);
		}

		cancelreportDTO.setCancelorderlineitems(cancelorderlineitems);

		return cancelreportDTO;
	}

	@Override
	public List<OutstandingPODetailsDTO> getAllOutstandingPODetails(Date startDate, Date endDate) {
		List<OutstandingPODetailsDTO> outstandingPoReportDTOs = new ArrayList<>();
		try {
			List<POHeader> poheaders = pohdrDao.getAllPOHeaderByPODate(startDate, endDate);
			poheaders.forEach(hdr -> {
				outstandingPoReportDTOs.add(prepareOutstandingDTO(hdr));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outstandingPoReportDTOs;
	}

	private OutstandingPODetailsDTO prepareOutstandingDTO(POHeader hdr) {
		OutstandingPODetailsDTO oustandingDTO = new OutstandingPODetailsDTO();
		SupplierMaster supplier = supplierDao.findSupplierMasterById(hdr.getSupplierId());
		List<POLineItem> lineitems = polineitemDao.getPOLineItemByPoNo(hdr.getId());
		ScmSrHdr srhdr = srhdrDao.getScmSrHdrByPoNo(hdr.getId());

		List<ScmSrLineItem> srlineitems = new ArrayList<>();
		if (srhdr != null)
			srlineitems = srlineitemDao.getScmSrLineItemByReceiveNo(srhdr.getStoreReceiveNo());

		if (hdr.getStatus().equalsIgnoreCase("6")) {
			oustandingDTO.setCancelDate(hdr.getPoDate());
			oustandingDTO.setCancelNo(hdr.getId());
		}

		oustandingDTO.setDate(hdr.getPoDate());
		oustandingDTO.setPoNo(hdr.getId());
		oustandingDTO.setSupplier(supplier.getsuppName());

		List<OutstandingPOLineitemDTO> POOutstadingLineitems = new ArrayList<>();
		for (int i = 0; i < lineitems.size(); i++) {
			OutstandingPOLineitemDTO POOutstadingLineitem = new OutstandingPOLineitemDTO();
			ItemMaster item = itemDao.getItemMasterById(lineitems.get(i).getItemId());

			if (hdr.getStatus().equalsIgnoreCase("6")) {
				POOutstadingLineitem.setCancelQty(lineitems.get(i).getActualQuantity());
			}

			POOutstadingLineitem.setDescription(item.getitemDsc());
			POOutstadingLineitem.setGrossRate(lineitems.get(i).getRate());
			POOutstadingLineitem.setItemCode(item.getId());
			POOutstadingLineitem.setOrderQty(lineitems.get(i).getActualQuantity());
			POOutstadingLineitem.setSlNo(lineitems.get(i).getId());
			POOutstadingLineitem.setUnit(item.getuomCode());

			List<POOutstandingSrDTO> supplyDetails = new ArrayList<>();

			for (int j = 0; j < srlineitems.size(); j++) {
				POOutstandingSrDTO srlineitem = new POOutstandingSrDTO();

				srlineitem.setSrDate(srlineitems.get(j).getReceivedDate());
				srlineitem.setSrNO(srlineitems.get(j).getStoreReceiveNo());
				srlineitem.setSrQty(srlineitems.get(j).getActualQnt());
				srlineitem.setBalanceQty(lineitems.get(i).getActualQuantity() - srlineitems.get(j).getActualQnt());

				supplyDetails.add(srlineitem);
			}
			POOutstadingLineitem.setSupplyDetails(supplyDetails);

			POOutstadingLineitems.add(POOutstadingLineitem);
		}

		oustandingDTO.setPOOutstadingLineitems(POOutstadingLineitems);

		// oustandingDTO.setAmmendNo(ammendNo);
		// oustandingDTO.setBalanceQty(balanceQty);

		return oustandingDTO;
	}

	@Override
	public List<OutstandingPODetailsDTO> getAllOutstandingPODetailsItemWise(Date startDate, Date endDate, String item) {
		List<OutstandingPODetailsDTO> outstandingPoReportDTOs = new ArrayList<>();
		try {
			List<POHeader> poheaders = pohdrDao.getAllPOHeaderByPODate(startDate, endDate);
			poheaders.forEach(hdr -> {
				outstandingPoReportDTOs.add(prepareOutstandingDTO(hdr, item));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outstandingPoReportDTOs;
	}

	private OutstandingPODetailsDTO prepareOutstandingDTO(POHeader hdr, String item) {
		OutstandingPODetailsDTO oustandingDTO = new OutstandingPODetailsDTO();
		List<POLineItem> lineitems = polineitemDao.getPOLineItemByPoNo(hdr.getId());

		ItemMaster itemm = itemDao.getItemMasterByDesc(item);
		List<POLineItem> itemcodes = lineitems.stream().filter(line -> line.getItemId().equals(itemm.getId()))
				.collect(Collectors.toList());

		if (!itemcodes.isEmpty()) {
			ScmSrHdr srhdr = srhdrDao.getScmSrHdrByPoNo(hdr.getId());
			SupplierMaster supplier = supplierDao.findSupplierMasterById(hdr.getSupplierId());

			List<ScmSrLineItem> srlineitems = new ArrayList<>();
			if (srhdr != null)
				srlineitems = srlineitemDao.getScmSrLineItemByReceiveNo(srhdr.getStoreReceiveNo());

			if (hdr.getStatus().equalsIgnoreCase("6")) {
				oustandingDTO.setCancelDate(hdr.getPoDate());
				oustandingDTO.setCancelNo(hdr.getId());
			}

			oustandingDTO.setDate(hdr.getPoDate());
			oustandingDTO.setPoNo(hdr.getId());
			oustandingDTO.setSupplier(supplier.getsuppName());

			List<OutstandingPOLineitemDTO> POOutstadingLineitems = new ArrayList<>();
			for (int i = 0; i < lineitems.size(); i++) {
				OutstandingPOLineitemDTO POOutstadingLineitem = new OutstandingPOLineitemDTO();
				ItemMaster items = itemDao.getItemMasterById(lineitems.get(i).getItemId());

				if (hdr.getStatus().equalsIgnoreCase("6")) {
					POOutstadingLineitem.setCancelQty(lineitems.get(i).getActualQuantity());
				}

				POOutstadingLineitem.setDescription(items.getitemDsc());
				POOutstadingLineitem.setGrossRate(lineitems.get(i).getRate());
				POOutstadingLineitem.setItemCode(items.getId());
				POOutstadingLineitem.setOrderQty(lineitems.get(i).getActualQuantity());
				POOutstadingLineitem.setSlNo(lineitems.get(i).getId());
				POOutstadingLineitem.setUnit(items.getuomCode());

				List<POOutstandingSrDTO> supplyDetails = new ArrayList<>();

				for (int j = 0; j < srlineitems.size(); j++) {
					POOutstandingSrDTO srlineitem = new POOutstandingSrDTO();

					srlineitem.setSrDate(srlineitems.get(j).getReceivedDate());
					srlineitem.setSrNO(srlineitems.get(j).getStoreReceiveNo());
					srlineitem.setSrQty(srlineitems.get(j).getActualQnt());
					srlineitem.setBalanceQty(lineitems.get(i).getActualQuantity() - srlineitems.get(j).getActualQnt());

					supplyDetails.add(srlineitem);
				}
				POOutstadingLineitem.setSupplyDetails(supplyDetails);

				POOutstadingLineitems.add(POOutstadingLineitem);
			}

			oustandingDTO.setPOOutstadingLineitems(POOutstadingLineitems);
		}

		return oustandingDTO;
	}

	@Override
	public List<OutstandingPODetailsDTO> getAllOutstandingPODetailsPartyWise(Date startDate, Date endDate,
			String party) {
		List<OutstandingPODetailsDTO> outstandingPoReportDTOs = new ArrayList<>();
		try {
			List<POHeader> poheaders = pohdrDao.getAllPOHeaderByPODate(startDate, endDate);
			SupplierMaster supplier = supplierDao.findBySuppName(party);
			poheaders.forEach(hdr -> {
				if (supplier.getsuppName().equalsIgnoreCase(party)) {
					outstandingPoReportDTOs.add(prepareOutstandingDTO(hdr));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outstandingPoReportDTOs;
	}

	@Override
	public List<POReport19DTO> getAllPOReport19(Date date) {
		List<POReport19DTO> POReport19 = new ArrayList<>();
		try {
			List<POHeader> poheaders = pohdrDao.getPOHeaderByPODate(date);
			poheaders.forEach(hdr -> {
				POReport19.add(preparePOReport19DTO(hdr));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return POReport19;
	}

	private POReport19DTO preparePOReport19DTO(POHeader hdr) {
		POReport19DTO poreport19 = new POReport19DTO();
		SupplierMaster supplier = supplierDao.findSupplierMasterById(hdr.getSupplierId());
		List<POLineItem> polineitems = polineitemDao.getPOLineItemByPoNo(hdr.getId());

		poreport19.setOrderNo(hdr.getId());
		poreport19.setPartAddress(supplier.getaddress1());
		poreport19.setPartyCode(supplier.getId());

		List<POReport19DTOLineItemDTO> lineitemDTOs = new ArrayList<>();
		for (int i = 0; i < polineitems.size(); i++) {
			POReport19DTOLineItemDTO lineitem = new POReport19DTOLineItemDTO();
			ItemMaster item = itemDao.getItemMasterById(polineitems.get(i).getItemId());
			POLineItemHist lineitemhist = lineitemhistDao.getPOLineItemHistByPoNumAndLineItemNum(hdr.getId(),
					polineitems.get(i).getId());

			// lineitem.setCst(cst);
			// lineitem.setDeliveryChg(polineitems.get(i).get);
			lineitem.setDisc(polineitems.get(i).getDiscount());
			// lineitem.setExcise(excise);
			lineitem.setItemCode(item.getId());
			lineitem.setItemDesc(item.getitemDsc());
			lineitem.setMake(item.getmake());
			lineitem.setRate(polineitems.get(i).getRate());
			// lineitem.setSch(sch);
			lineitem.setUnit(item.getuomCode());

			lineitemDTOs.add(lineitem);

			AmmendLineitemDTO ammendlineitem = new AmmendLineitemDTO();

			// ammendlineitem.setCst(cst);
			// ammendlineitem.setDeliveryChg(polineitems.get(i).get);
			ammendlineitem.setDisc(polineitems.get(i).getDiscount());
			// ammendlineitem.setExcise(excise);
			ammendlineitem.setItemCode(item.getId());
			ammendlineitem.setItemDesc(item.getitemDsc());
			ammendlineitem.setMake(item.getmake());
			ammendlineitem.setRate(polineitems.get(i).getRate());
			// ammendlineitem.setSch(sch);
			ammendlineitem.setUnit(item.getuomCode());

			lineitem.setAmmendLineitems(ammendlineitem);

		}
		poreport19.setLineitems(lineitemDTOs);

		return poreport19;
	}

	@Override
	public List<PurchaseOrderHistoryReportDTO> getAllPurchaseOrderHistoryReport(Date startDate, Date endDate,
			String suppName) {
		List<PurchaseOrderHistoryReportDTO> purchasehistryDTO = new ArrayList<>();
		try {
			SupplierMaster supplier = supplierDao.findBySuppName(suppName);
			List<POHeader> poheaders = pohdrDao.getAllPOHeaderByPODateAndSuppCode(startDate, endDate, supplier.getId());
			poheaders.forEach(hdr -> {
				purchasehistryDTO.add(preparePurchaseHistoryReportByPartyNameDTO(hdr, supplier));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return purchasehistryDTO;
	}

	private PurchaseOrderHistoryReportDTO preparePurchaseHistoryReportByPartyNameDTO(POHeader hdr,
			SupplierMaster supplier) {
		PurchaseOrderHistoryReportDTO dto = new PurchaseOrderHistoryReportDTO();
		List<POLineItem> lineitems = polineitemDao.getPOLineItemByPoNo(hdr.getId());

		dto.setCompany(hdr.getCompanyCode());
		dto.setDate(hdr.getPoDate());
		dto.setDiscount(hdr.getDiscount());
		dto.setOrderNo(hdr.getId());
		dto.setPartyName(supplier.getsuppName());

		List<PurchaseOrderHistoryReportLineitemDTO> lineitemsDTO = new ArrayList<>();
		for (int i = 0; i < lineitems.size(); i++) {
			PurchaseOrderHistoryReportLineitemDTO lineitem = new PurchaseOrderHistoryReportLineitemDTO();
			ItemMaster item = itemDao.getItemMasterById(lineitems.get(i).getItemId());

			lineitem.setDescription(item.getitemDsc());
			lineitem.setItemCode(item.getId());
			lineitem.setRate(lineitems.get(i).getRate());
			lineitem.setSrl(lineitems.get(i).getId());
			lineitem.setStax(lineitems.get(i).getTax());
			lineitem.setUnit(item.getuomCode());

			lineitemsDTO.add(lineitem);
		}

		dto.setLineitems(lineitemsDTO);

		return dto;
	}

	@Override
	public List<PO02ReportDTO> getAllPO02ReportDTO(Date poDate, String poNo) {
		List<PO02ReportDTO> PO02DTOs = new ArrayList<>();

		try {
			POHeader pohdrs = pohdrDao.getAllPOHeaderByPoDateAndPONum(poDate, poNo);
			List<POLineItem> polines = polineitemDao.getPOLineItemByPoNo(pohdrs.getId());

			polines.forEach(poline -> {
				PO02DTOs.add(preparePO02DTO(poline));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return PO02DTOs;
	}

	private PO02ReportDTO preparePO02DTO(POLineItem poline) {
		PO02ReportDTO dto = new PO02ReportDTO();
		List<ScmIndentLineItem> indentlines = indentlineitemDao.getIndentLineItemByItemCode(poline.getItemId());
		ItemMaster item = itemDao.getItemMasterById(poline.getItemId());

		List<PO02ReportLineDTO> linedtos = new ArrayList<>();
		for (int i = 0; i < indentlines.size(); i++) {
			PO02ReportLineDTO linedto = new PO02ReportLineDTO();
			ScmIndentHeader indenthdr = indenthdrDao.getScmIndentHeaderByIndentNo(indentlines.get(i).getIndentNo());
			List<POLineItem> polines = polineitemDao.getPOLineItemByIndentNo(indenthdr.getIndentNo());
			for (int j = 0; j < polines.size(); j++) {
				POHeader pohdr = pohdrDao.getPOHeaderById(polines.get(j).getPoId());
				linedto.setDeliverySchedule(pohdr.getDeliveryTimeline());
				linedto.setDiscount(pohdr.getDiscount());
				linedto.setSurcharge(pohdr.getFrieghtCharge());
				linedto.setExcise(pohdr.getTax());

			}

			linedto.setIndentNo(indenthdr.getIndentNo());
			linedto.setSrlNo(String.valueOf(indentlines.get(i).getIndentSrlNo()));
			// linedto.setCst(cst);
			linedto.setQuantity(indentlines.get(i).getIndentQnt());
			// linedto.setRate(rate);

			linedtos.add(linedto);
		}

		// dto.setCst(cst);
		dto.setDescription(item.getitemDsc());

		// dto.setExcise(excise);
		dto.setItemCode(item.getId());
		dto.setMake(item.getmake());
		dto.setUnit(item.getuomCode());
		dto.setLines(linedtos);

		return dto;
	}

	@Override
	public List<POOrderCancelNoteReportDTO> getAllPOOrderCancelNoteReport(Date date) {
		List<POOrderCancelNoteReportDTO> ordercancelnoteDTO = new ArrayList<>();
		try {
			List<POHeader> pohdrs = pohdrDao.getCancelledPOHeaderByPODate(date);
			pohdrs.forEach(hdr -> {
				ordercancelnoteDTO.add(prepareCancelNoteReportDTO(hdr));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordercancelnoteDTO;
	}

	private POOrderCancelNoteReportDTO prepareCancelNoteReportDTO(POHeader hdr) {
		POOrderCancelNoteReportDTO cancelNoteReportDTO = new POOrderCancelNoteReportDTO();
		List<POLineItem> polineitems = polineitemDao.getPOLineItemByPoNo(hdr.getId());

		float rate = 0.0f;
		List<POCancelNoteReportLineDTO> lineDTOs = new ArrayList<>();
		for (int i = 0; i < polineitems.size(); i++) {

			POCancelNoteReportLineDTO lineDTO = new POCancelNoteReportLineDTO();
			ItemMaster item = itemDao.getItemMasterById(polineitems.get(i).getItemId());

			lineDTO.setDescription(item.getitemDsc());
			lineDTO.setDisc(polineitems.get(i).getDiscount());
			lineDTO.setExcise(polineitems.get(i).getTax());
			lineDTO.setItemCode(item.getgrpCode() + item.getlegacyItemCode());
			lineDTO.setSrl(String.valueOf(polineitems.get(i).getId()));
			lineDTO.setUnit(item.getuomCode());
			lineDTO.setPoQnt(polineitems.get(i).getQuantity());
			lineDTO.setRate(polineitems.get(i).getRate());

			lineDTOs.add(lineDTO);
		}

		// cancelNoteReportDTO.setCancelReson(cancelReson);
		// cancelNoteReportDTO.setCst(cst);
		cancelNoteReportDTO.setOrderNo(hdr.getId());
		cancelNoteReportDTO.setSch(hdr.getFrieghtCharge());
		cancelNoteReportDTO.setLine(lineDTOs);

		return cancelNoteReportDTO;
	}

	@Override
	public List<POOutstandingSummaryDTO> getAllOutStandingOrderSummary(Date startDate, Date endDate) {
		List<POOutstandingSummaryDTO> outstandingPoReportDTOs = new ArrayList<>();
		try {
			List<POHeader> poheaders = pohdrDao.getAllPOHeaderByPODate(startDate, endDate);
			poheaders.forEach(hdr -> {
				outstandingPoReportDTOs.add(prepareOutstandingSummaryDTO(hdr));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outstandingPoReportDTOs;
	}

	private POOutstandingSummaryDTO prepareOutstandingSummaryDTO(POHeader hdr) {
		POOutstandingSummaryDTO dto = new POOutstandingSummaryDTO();
		SupplierMaster supplier = supplierDao.findSupplierMasterById(hdr.getSupplierId());
		List<POLineItem> lineitems = polineitemDao.getPOLineItemByPoNo(hdr.getId());
		ScmSrHdr srhdr = srhdrDao.getScmSrHdrByPoNo(hdr.getId());
		String finYear = hdr.getFinnacialYear();

		List<ScmSrLineItem> srlineitems = new ArrayList<>();
		if (srhdr != null) {
			srlineitems = srlineitemDao.getScmSrLineItemByReceiveNo(srhdr.getStoreReceiveNo());
		}

		Float cancelqnt = 0.0f;
		for(int j = 0; j < srlineitems.size() ; j++) {
			cancelqnt = cancelqnt + srlineitems.get(j).getOrderedPrice();
		}
		dto.setCancelQnt(cancelqnt);
		if (hdr.getStatus().equalsIgnoreCase("6")) {
			dto.setCancelDate(hdr.getPoDate());
			dto.setCancelNo(hdr.getId());
			
		}

		dto.setDate(hdr.getPoDate());
		dto.setPoNo(hdr.getId());
		dto.setSupplier(supplier.getsuppName());

		List<POOutstandingSummaryLineDTO> pOOutstandingSummaryLineDTO = new ArrayList<>();
		for (int i = 0; i < lineitems.size(); i++) {
			POOutstandingSummaryLineDTO linedto = new POOutstandingSummaryLineDTO();
			ItemMaster item = itemDao.getItemMasterById(lineitems.get(i).getItemId());
			linedto.setDescription(item.getitemDsc());
			linedto.setItemCode(item.getId());
			linedto.setGrossRate(lineitems.get(i).getRate());
			linedto.setIndentNoFinYear(lineitems.get(i).getIndentId() +"/"+ finYear);
			linedto.setUnit(lineitems.get(i).getUnitId());
			linedto.setOrderQnt(lineitems.get(i).getQuantity());
			linedto.setSlNO(String.valueOf(lineitems.get(i).getId()));
//			linedto.setLastSuppDate(lastSuppDate);
//			linedto.setSupplyQnt(supplyQnt);
//			linedto.setBalanceQnt(balanceQnt);
			pOOutstandingSummaryLineDTO.add(linedto);
		}
		dto.setOOutstandingSummaryLineDTO(pOOutstandingSummaryLineDTO);
//		dto.setAmmendNo(ammendNo);
		
		return dto;
	}

	@Override
	public List<POOutstandingSummaryDTO> getAllOutStandingOrderSummaryItemWise(Date startDate, Date endDate,
			String item) {
		List<POOutstandingSummaryDTO> outstandingPoReportDTOs = new ArrayList<>();
		try {
			List<POHeader> poheaders = pohdrDao.getAllPOHeaderByPODate(startDate, endDate);
			poheaders.forEach(hdr -> {
				outstandingPoReportDTOs.add(prepareOutstandingSummaryItemWiseDTO(hdr, item));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outstandingPoReportDTOs;
	}

	private POOutstandingSummaryDTO prepareOutstandingSummaryItemWiseDTO(POHeader hdr, String item) {
		POOutstandingSummaryDTO oustandingDTO = new POOutstandingSummaryDTO();
		List<POLineItem> lineitems = polineitemDao.getPOLineItemByPoNo(hdr.getId());
		SupplierMaster supplier = supplierDao.findSupplierMasterById(hdr.getSupplierId());
		ItemMaster itemm = itemDao.getItemMasterByDesc(item);
		List<POLineItem> itemcodes = lineitems.stream().filter(line -> line.getItemId().equals(itemm.getId()))
				.collect(Collectors.toList());

		if (!itemcodes.isEmpty()) {
			ScmSrHdr srhdr = srhdrDao.getScmSrHdrByPoNo(hdr.getId());
			String finYear = hdr.getFinnacialYear();

			List<ScmSrLineItem> srlineitems = new ArrayList<>();
			if (srhdr != null) {
				srlineitems = srlineitemDao.getScmSrLineItemByReceiveNo(srhdr.getStoreReceiveNo());
			}
			
			Float cancelqnt = 0.0f;
			for(int j = 0; j < srlineitems.size() ; j++) {
				cancelqnt = cancelqnt + srlineitems.get(j).getOrderedPrice();
			}
			oustandingDTO.setCancelQnt(cancelqnt);
			if (hdr.getStatus().equalsIgnoreCase("6")) {
				oustandingDTO.setCancelDate(hdr.getPoDate());
				oustandingDTO.setCancelNo(hdr.getId());
				
			}

			oustandingDTO.setDate(hdr.getPoDate());
			oustandingDTO.setPoNo(hdr.getId());
			oustandingDTO.setSupplier(supplier.getsuppName());

			List<POOutstandingSummaryLineDTO> pOOutstandingSummaryLineDTO = new ArrayList<>();
			for (int i = 0; i < lineitems.size(); i++) {
				POOutstandingSummaryLineDTO linedto = new POOutstandingSummaryLineDTO();
				ItemMaster itemEntity = itemDao.getItemMasterById(lineitems.get(i).getItemId());
				linedto.setDescription(itemEntity.getitemDsc());
				linedto.setItemCode(itemEntity.getId());
				linedto.setGrossRate(lineitems.get(i).getRate());
				linedto.setIndentNoFinYear(lineitems.get(i).getIndentId() +"/"+ finYear);
				linedto.setUnit(lineitems.get(i).getUnitId());
				linedto.setOrderQnt(lineitems.get(i).getQuantity());
				linedto.setSlNO(String.valueOf(lineitems.get(i).getId()));
//				linedto.setLastSuppDate(lastSuppDate);
//				linedto.setSupplyQnt(supplyQnt);
//				linedto.setBalanceQnt(balanceQnt);
				pOOutstandingSummaryLineDTO.add(linedto);
			}
			oustandingDTO.setOOutstandingSummaryLineDTO(pOOutstandingSummaryLineDTO);
//			oustandingDTO.setAmmendNo(ammendNo);
		}
		return oustandingDTO;
	}

	@Override
	public List<POOutstandingSummaryDTO> getAllOutStandingOrderSummaryPartyWise(Date startDate, Date endDate,
			String party) {
		List<POOutstandingSummaryDTO> outstandingPoReportDTOs = new ArrayList<>();
		try {
			List<POHeader> poheaders = pohdrDao.getAllPOHeaderByPODate(startDate, endDate);
			SupplierMaster supplier = supplierDao.findBySuppName(party);
			poheaders.forEach(hdr -> {
				if (supplier.getsuppName().equalsIgnoreCase(party)) {
					outstandingPoReportDTOs.add(prepareOutstandingSummaryDTO(hdr));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outstandingPoReportDTOs;
	}

}
