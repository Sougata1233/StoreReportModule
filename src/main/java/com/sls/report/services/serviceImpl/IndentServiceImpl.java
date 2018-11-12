package com.sls.report.services.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sls.report.component.DepartmentComponent;
import com.sls.report.component.ItemMasterComponent;
import com.sls.report.component.POHdrComponent;
import com.sls.report.component.POLineItemComponent;
import com.sls.report.component.ScmIndentCancelComponent;
import com.sls.report.component.ScmIndentHeaderComponent;
import com.sls.report.component.ScmIndentLineItemCompnent;
import com.sls.report.component.ScmSrHdrComponent;
import com.sls.report.component.ScmSrLineItemComponent;
import com.sls.report.component.UomMasterComponent;
import com.sls.report.dto.CancelledIndentDTO;
import com.sls.report.dto.IndentCancelRegisterDTO;
import com.sls.report.dto.IndentDetailsReportNumberWiseDTO;
import com.sls.report.dto.IndentDetailsReportNumberWiseLineItemDTO;
import com.sls.report.dto.IndentReport10LineDTO;
import com.sls.report.dto.IndentSummaryReportWaitingForPODTO;
import com.sls.report.dto.OutstandingIndentReportDTO;
import com.sls.report.dto.OutstandingReportLineItemDTO;
import com.sls.report.dto.SrHdrDTO;
import com.sls.report.entity.Department;
import com.sls.report.entity.ItemMaster;
import com.sls.report.entity.POLineItem;
import com.sls.report.entity.ScmIndentHeader;
import com.sls.report.entity.ScmIndentLineItem;
import com.sls.report.entity.ScmSrHdr;
import com.sls.report.entity.ScmSrLineItem;
import com.sls.report.services.IndentService;


@Service
public class IndentServiceImpl implements IndentService {

	@Autowired
	ScmIndentHeaderComponent indenthdrDao;
	
	@Autowired
	ScmIndentLineItemCompnent indentlineitemDao;
	
	@Autowired
	UomMasterComponent uomDao;
	
	@Autowired
	ItemMasterComponent itemDao;
	
	@Autowired
	ScmSrHdrComponent srhdrDao;
	
	@Autowired
	ScmSrLineItemComponent srlineitemDao;
	
	@Autowired
	POHdrComponent pohdrDao;
	
	@Autowired
	POLineItemComponent polineitemDao;
	
	@Autowired
	ScmIndentCancelComponent indentcancelDao;
	
	@Autowired
	DepartmentComponent deptDao;

	@Override
	public List<CancelledIndentDTO> getAllCancelledIndentReport(String indentDate) {
		List<CancelledIndentDTO> cancelledindents = new ArrayList<>();
		try {
			Date date = Date.valueOf(indentDate);
			List<ScmIndentHeader> indenthdr = indenthdrDao.getScmIndentHeaderByModOn(date);
			int indenthdrsize = indenthdr.size();
			for(int i = 0 ; i < indenthdrsize ; i++) {
				List<ScmIndentLineItem> indentlineitems = 
						indentlineitemDao.getScmIndentLineItemByIndentNo(indenthdr.get(i).getIndentNo());
				indentlineitems.forEach(cancel->{
					ScmIndentHeader indenthdr2 = indenthdrDao.getScmIndentHeaderByIndentNo(cancel.getIndentNo());
					if(indenthdr2.getIndentStatus().equalsIgnoreCase("6")) {
						cancelledindents.add(prepareCancelDTO(cancel));
					}
				});
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cancelledindents;
	}

	private CancelledIndentDTO prepareCancelDTO(ScmIndentLineItem cancel) {
		CancelledIndentDTO cancelindentDTO = new CancelledIndentDTO();
		ItemMaster item = itemDao.getItemMasterById(cancel.getItemCode());
		ScmIndentHeader hdr = indenthdrDao.getScmIndentHeaderByIndentNo(cancel.getIndentNo());
		
		cancelindentDTO.setDate(hdr.getIndentDate());
		cancelindentDTO.setDescription(item.getitemDsc());
		cancelindentDTO.setIndentNO(cancel.getIndentNo());
		cancelindentDTO.setItemCode(item.getId());
		cancelindentDTO.setQuantity(cancel.getIndentQnt());
		cancelindentDTO.setReason(cancel.getRemark());
		cancelindentDTO.setUnit(item.getuomCode());
		cancelindentDTO.setCancelQnt(cancel.getIndentQnt());
		cancelindentDTO.setIndentQnt(cancel.getIndentQnt());
		
		return cancelindentDTO;
	}

	@Override
	public List<IndentCancelRegisterDTO> getAllIndentCancelRegister(Date startDate, Date endDate) {
		List<IndentCancelRegisterDTO> cancelledIndentDTOs = new ArrayList<>();
		try {
			List<ScmIndentHeader> indenthdrs = indenthdrDao.getScmIndentHeaderByModDate(startDate, endDate);
			indenthdrs.forEach(cancel->{
				if(cancel.getIndentStatus().equalsIgnoreCase("6")) {
					cancelledIndentDTOs.add(prepareCancelledIndentReportDTO(cancel));
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cancelledIndentDTOs;
	}

	private IndentCancelRegisterDTO prepareCancelledIndentReportDTO(ScmIndentHeader cancel) {
		IndentCancelRegisterDTO reportDTO = new IndentCancelRegisterDTO();
		List<ScmIndentLineItem> indentlineitems = indentlineitemDao.getScmIndentLineItemByIndentNo(cancel.getIndentNo());
		List<CancelledIndentDTO> cancels = new ArrayList<>();
		
		for(int i = 0 ; i < indentlineitems.size() ; i++) {
			CancelledIndentDTO cancelEmp = new CancelledIndentDTO();
			ItemMaster item = itemDao.getItemMasterById(indentlineitems.get(i).getItemCode());
			
			cancelEmp.setCancelQnt(indentlineitems.get(i).getIndentQnt());
			cancelEmp.setIndentQnt(indentlineitems.get(i).getIndentQnt());
			cancelEmp.setDescription(item.getitemDsc());
			cancelEmp.setItemCode(item.getId());
			cancelEmp.setUnit(item.getuomCode());
			cancelEmp.setReason(indentlineitems.get(i).getRemark());
			cancelEmp.setIndentNO(cancel.getIndentNo());
			cancelEmp.setDate(cancel.getIndentDate());
			
			cancels.add(cancelEmp);
		}
		
		reportDTO.setCancelDTO(cancels);
		
		reportDTO.setCancelNO(cancel.getIndentNo());
		reportDTO.setDate(cancel.getIndentDate());
		reportDTO.setFinYear(cancel.getFinYear());
		reportDTO.setIndentNO(cancel.getIndentNo());
		
		return reportDTO;
	}

	@Override
	public List<IndentDetailsReportNumberWiseDTO> getAllIndentDetailsReport(Date startDate, Date endDate) {
		List<IndentDetailsReportNumberWiseDTO> indentItemWiseDTOs = new ArrayList<>();
		try {
			List<ScmIndentHeader> indenthdrs = indenthdrDao.getScmIndentHeaderByModDate(startDate, endDate);
			indenthdrs.forEach(hdr->{
				if(!hdr.getIndentNo().startsWith("J")) {
					indentItemWiseDTOs.add(prepareIndentDetailsReportDTO(hdr));
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return indentItemWiseDTOs;
	}
	
	private IndentDetailsReportNumberWiseDTO prepareIndentDetailsReportDTO(ScmIndentHeader hdr) {
		IndentDetailsReportNumberWiseDTO indentdetailsreportDTO = new IndentDetailsReportNumberWiseDTO();
		List<ScmIndentLineItem> indentlineitems = 
				indentlineitemDao.getScmIndentLineItemByIndentNo(hdr.getIndentNo()).stream()
				.sorted(Comparator.comparing(ScmIndentLineItem::getItemCode)).collect(Collectors.toList());
		List<IndentDetailsReportNumberWiseLineItemDTO> lineitemDTOs = new ArrayList<>();
		List<POLineItem> polineitems = polineitemDao.getPOLineItemByIndentNo(hdr.getIndentNo());
		
		long outstQnt = 0;
		for(int i = 0 ; i < indentlineitems.size() ; i++) {
			IndentDetailsReportNumberWiseLineItemDTO lineitemDTO = new IndentDetailsReportNumberWiseLineItemDTO();
			ItemMaster item = itemDao.getItemMasterById(indentlineitems.get(i).getItemCode());
			
			lineitemDTO.setDescription(item.getitemDsc());
			lineitemDTO.setIndentQnt(indentlineitems.get(i).getIndentQnt());
			lineitemDTO.setItemCode(item.getId());
			lineitemDTO.setOrederQnt(indentlineitems.get(i).getPoQnt());
			lineitemDTO.setSrl(indentlineitems.get(i).getIndentSrlNo());
			lineitemDTO.setUom(indentlineitems.get(i).getUomCode());
			
			if(indentlineitems.get(i).getIndentStatus().equalsIgnoreCase("4")) {
				lineitemDTO.setCancelNo(indentlineitems.get(i).getIndentSrlNo());
				lineitemDTO.setCancellationDate(hdr.getIndentDate());
				lineitemDTO.setCancelQnt(indentlineitems.get(i).getIndentQnt());
			}
			
			outstQnt = (indentlineitems.get(i).getIndentQnt() - (indentlineitems.get(i).getPoQnt() +
					indentlineitems.get(i).getCancelQnt()));
			
			
			
			
			lineitemDTOs.add(lineitemDTO);
		}
		
		List<SrHdrDTO> srhdrDTOs = new ArrayList<>();
		
		polineitems.forEach(poli->{
			SrHdrDTO srhdr = new SrHdrDTO();
			if(!poli.getPoId().startsWith("J")) {
				ScmSrHdr hdrsr = srhdrDao.getScmSrHdrByPoNo(poli.getPoId());
				List<ScmSrLineItem> srlineitems = srlineitemDao.getScmSrLineItemByReceiveNo(hdrsr.getStoreReceiveNo());
				long srqnt = 0;
				for(int x = 0 ; x < srlineitems.size() ; x++) {
					srqnt = srqnt + srlineitems.get(x).getActualQnt();
				}
				
				srhdr.setOrderNo(poli.getPoId());
				srhdr.setSrDate(hdrsr.getStoreReceiveDt());
				srhdr.setSrNo(hdrsr.getStoreReceiveNo());
				srhdr.setSrQnt(srqnt);
				srhdr.setLineitemsrl(poli.getId());
			}
			
			srhdrDTOs.add(srhdr);
		});
		indentdetailsreportDTO.setOutstQnt(outstQnt);
		indentdetailsreportDTO.setSrhdrs(srhdrDTOs);
		indentdetailsreportDTO.setIndentDetailsReportNumberWiseLineItems(lineitemDTOs);
		indentdetailsreportDTO.setIndentDate(hdr.getIndentDate());
		indentdetailsreportDTO.setIndentNo(hdr.getIndentNo());
		
		return indentdetailsreportDTO;
	}

	@Override
	public List<IndentDetailsReportNumberWiseDTO> getAllIndentDetailsReportItemWise(Date startDate, Date endDate) {
		List<IndentDetailsReportNumberWiseDTO> indentItemWiseDTOs = new ArrayList<>();
		try {
			List<ScmIndentHeader> indenthdrs = indenthdrDao.getScmIndentHeaderByModDate(startDate, endDate);
			indenthdrs.forEach(hdr->{
				List<ScmIndentLineItem> indentlineitems = indentlineitemDao.getScmIndentLineItemByIndentNo(hdr.getIndentNo());
				if(!hdr.getIndentNo().startsWith("J")) {
					for(int i = 0 ; i < indentlineitems.size() ; i++) {
						indentItemWiseDTOs.add(prepareIndentDetailsReportDTO(hdr));
					}
					
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return indentItemWiseDTOs;
	}

	@Override
	public List<IndentDetailsReportNumberWiseDTO> getAllIndentDetailsReportNumberWise(Date startDate, Date endDate) {
		List<IndentDetailsReportNumberWiseDTO> indentdetailsreportDTOs = new ArrayList<>();
		try {
			List<ScmIndentHeader> indenthdrs = indenthdrDao.getScmIndentHeaderByModDate(startDate, endDate);
			indenthdrs.forEach(hdr->{
				if(!hdr.getIndentNo().startsWith("J")) {
					indentdetailsreportDTOs.add(prepareIndentDetailsReportDTO2(hdr));
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return indentdetailsreportDTOs;
	}

	private IndentDetailsReportNumberWiseDTO prepareIndentDetailsReportDTO2(ScmIndentHeader hdr) {
		IndentDetailsReportNumberWiseDTO indentdetailsreportDTO = new IndentDetailsReportNumberWiseDTO();
		List<ScmIndentLineItem> indentlineitems = indentlineitemDao.getScmIndentLineItemByIndentNo(hdr.getIndentNo());
		List<IndentDetailsReportNumberWiseLineItemDTO> lineitemDTOs = new ArrayList<>();
		List<POLineItem> polineitems = polineitemDao.getPOLineItemByIndentNo(hdr.getIndentNo());
		
		long outstQnt = 0;
		for(int i = 0 ; i < indentlineitems.size() ; i++) {
			IndentDetailsReportNumberWiseLineItemDTO lineitemDTO = new IndentDetailsReportNumberWiseLineItemDTO();
			ItemMaster item = itemDao.getItemMasterById(indentlineitems.get(i).getItemCode());
			
			lineitemDTO.setDescription(item.getitemDsc());
			lineitemDTO.setIndentQnt(indentlineitems.get(i).getIndentQnt());
			lineitemDTO.setItemCode(item.getId());
			lineitemDTO.setOrederQnt(indentlineitems.get(i).getPoQnt());
			lineitemDTO.setSrl(indentlineitems.get(i).getIndentSrlNo());
			lineitemDTO.setUom(indentlineitems.get(i).getUomCode());
			
			if(indentlineitems.get(i).getIndentStatus().equalsIgnoreCase("4")) {
				lineitemDTO.setCancelNo(indentlineitems.get(i).getIndentSrlNo());
				lineitemDTO.setCancellationDate(hdr.getIndentDate());
				lineitemDTO.setCancelQnt(indentlineitems.get(i).getIndentQnt());
			}
			
			outstQnt = (indentlineitems.get(i).getIndentQnt() - (indentlineitems.get(i).getPoQnt() +
					indentlineitems.get(i).getCancelQnt()));
			
			
			
			
			lineitemDTOs.add(lineitemDTO);
		}
		
		List<SrHdrDTO> srhdrDTOs = new ArrayList<>();
		
		polineitems.forEach(poli->{
			SrHdrDTO srhdr = new SrHdrDTO();
			if(!poli.getPoId().startsWith("J")) {
				ScmSrHdr hdrsr = srhdrDao.getScmSrHdrByPoNo(poli.getPoId());
				List<ScmSrLineItem> srlineitems = srlineitemDao.getScmSrLineItemByReceiveNo(hdrsr.getStoreReceiveNo());
				long srqnt = 0;
				for(int x = 0 ; x < srlineitems.size() ; x++) {
					srqnt = srqnt + srlineitems.get(x).getActualQnt();
				}
				
				srhdr.setOrderNo(poli.getPoId());
				srhdr.setSrDate(hdrsr.getStoreReceiveDt());
				srhdr.setSrNo(hdrsr.getStoreReceiveNo());
				srhdr.setSrQnt(srqnt);
				srhdr.setLineitemsrl(poli.getId());
			}
			
			srhdrDTOs.add(srhdr);
		});
		indentdetailsreportDTO.setOutstQnt(outstQnt);
		indentdetailsreportDTO.setSrhdrs(srhdrDTOs);
		indentdetailsreportDTO.setIndentDetailsReportNumberWiseLineItems(lineitemDTOs);
		indentdetailsreportDTO.setIndentDate(hdr.getIndentDate());
		indentdetailsreportDTO.setIndentNo(hdr.getIndentNo());
		
		return indentdetailsreportDTO;
	}

	@Override
	public List<OutstandingIndentReportDTO> getAllOutstandingIndentReport(Date startDate, Date endDate) {
		List<OutstandingIndentReportDTO> outstandingindentreportDTO = new ArrayList<>();
		try {
			List<ScmIndentHeader> indentheaders = indenthdrDao.getScmIndentHeaderByModDate(startDate, endDate);
			indentheaders.forEach(indenthdr->{
				if(!indenthdr.getIndentNo().startsWith("J")) {
					outstandingindentreportDTO.add(prepareIndentHdrOutstandingReprotDTO(indenthdr));
				}
				
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return outstandingindentreportDTO;
	}

	private OutstandingIndentReportDTO prepareIndentHdrOutstandingReprotDTO(ScmIndentHeader indenthdr) {
		OutstandingIndentReportDTO outstandingindentreportDTO = new OutstandingIndentReportDTO();
		List<ScmIndentLineItem> indentlineitems = 
								indentlineitemDao.getScmIndentLineItemByIndentNo(indenthdr.getIndentNo());
		
		outstandingindentreportDTO.setDate(indenthdr.getIndentDate());
		outstandingindentreportDTO.setIndentNo(indenthdr.getIndentNo());
		
		List<OutstandingReportLineItemDTO> lineitemDTOs = new ArrayList<>();
		
		for(int i = 0 ; i < indentlineitems.size() ; i ++) {
			OutstandingReportLineItemDTO lineitemDTO = new OutstandingReportLineItemDTO();
			ItemMaster item = itemDao.getItemMasterById(indentlineitems.get(i).getItemCode());
			Department dept = deptDao.getDepartmentByDeptId(Long.parseLong(indentlineitems.get(i).getDeptCode().trim()));
			/*POLineItem poline = 
					polineitemDao.getPOLineItemByIndentNoAndItemCode(indentlineitems.get(i).getIndentNo(),
							indentlineitems.get(i).getItemCode());*/
			
			lineitemDTO.setCancelQnt(indentlineitems.get(i).getCancelQnt());
			lineitemDTO.setDept(dept.getdepartmentName());
			lineitemDTO.setDescription(item.getitemDsc());
			lineitemDTO.setIndentQnt(indentlineitems.get(i).getIndentQnt());
			lineitemDTO.setItemCode(item.getId());
//			lineitemDTO.setOrderQnt(indentlineitems.get(i).getPoQnt());
//			long poqnt = (long) poline.getActualQuantity();
			lineitemDTO.setOrderQnt(indentlineitems.get(i).getPoQnt());
			lineitemDTO.setSrlNo(indentlineitems.get(i).getIndentSrlNo());
			lineitemDTO.setUnit(item.getuomCode());
			
//			long balanceQnt = (indentlineitems.get(i).getIndentQnt() - indentlineitems.get(i).getPoQnt());
			long balanceQnt = (indentlineitems.get(i).getIndentQnt() - (indentlineitems.get(i).getPoQnt()+indentlineitems.get(i).getCancelQnt()));
			lineitemDTO.setBalanceQnt(balanceQnt);
			
			lineitemDTOs.add(lineitemDTO);
			
		}
		
		outstandingindentreportDTO.setOustandingreportDTO(lineitemDTOs);
		
		
//		outstandingindentreportDTO.setBalanceQntToSupp(balanceQntToSupp);
//		
//		outstandingindentreportDTO.setLastSuppDate(lastSuppDate);
//		outstandingindentreportDTO.setSupplyQnt(supplyQnt);
		
		return outstandingindentreportDTO;
	}

	@Override
	public List<OutstandingIndentReportDTO> getAllOutstandingIndentReportItemWise(Date startDate) {
		List<OutstandingIndentReportDTO> outstandingindentreportDTO = new ArrayList<>();
		try {
			List<ScmIndentHeader> indentheaders = indenthdrDao.getScmIndentHeaderByModOn(startDate);
			indentheaders.forEach(indenthdr->{
				List<ScmIndentLineItem> indentlines = 
						indentlineitemDao.getScmIndentLineItemByIndentNo(indenthdr.getIndentNo());
				if(!indenthdr.getIndentNo().startsWith("J")) {
					outstandingindentreportDTO.add(prepareIndentHdrOutstandingReprotItemWiseDTO(indenthdr));
				}
				
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return outstandingindentreportDTO;
	}

	private OutstandingIndentReportDTO prepareIndentHdrOutstandingReprotItemWiseDTO(ScmIndentHeader indenthdr) {
		OutstandingIndentReportDTO outstandingindentreportDTO = new OutstandingIndentReportDTO();
		List<ScmIndentLineItem> indentlineitems = 
								indentlineitemDao.getScmIndentLineItemByIndentNo(indenthdr.getIndentNo());
		
		outstandingindentreportDTO.setDate(indenthdr.getIndentDate());
		outstandingindentreportDTO.setIndentNo(indenthdr.getIndentNo());
		
		List<OutstandingReportLineItemDTO> lineitemDTOs = new ArrayList<>();
		
		for(int i = 0 ; i < indentlineitems.size() ; i ++) {
			OutstandingReportLineItemDTO lineitemDTO = new OutstandingReportLineItemDTO();
			ItemMaster items = itemDao.getItemMasterById(indentlineitems.get(i).getItemCode());
			
			lineitemDTO.setCancelQnt(indentlineitems.get(i).getCancelQnt());
			lineitemDTO.setDept(indentlineitems.get(i).getDeptCode());
			lineitemDTO.setDescription(items.getitemDsc());
			lineitemDTO.setIndentQnt(indentlineitems.get(i).getIndentQnt());
			lineitemDTO.setItemCode(items.getId());
			lineitemDTO.setOrderQnt(indentlineitems.get(i).getPoQnt());
			lineitemDTO.setSrlNo(indentlineitems.get(i).getIndentSrlNo());
			lineitemDTO.setUnit(items.getuomCode());
			
			long balanceQnt = (indentlineitems.get(i).getIndentQnt() - indentlineitems.get(i).getPoQnt());
			lineitemDTO.setBalanceQnt(balanceQnt);
			
			lineitemDTOs.add(lineitemDTO);
			
		}
		
		outstandingindentreportDTO.setOustandingreportDTO(lineitemDTOs);
		
		
//		outstandingindentreportDTO.setBalanceQntToSupp(balanceQntToSupp);
//		
//		outstandingindentreportDTO.setLastSuppDate(lastSuppDate);
//		outstandingindentreportDTO.setSupplyQnt(supplyQnt);
		
		return outstandingindentreportDTO;
	}

	@Override
	public List<OutstandingIndentReportDTO> getAllOutstandingIndentReportDeptWise(Date startDate) {
		List<OutstandingIndentReportDTO> outstandingindentreportDTO = new ArrayList<>();
		try {
			List<ScmIndentHeader> indentheaders = indenthdrDao.getScmIndentHeaderByModOn(startDate);
			indentheaders.forEach(indenthdr->{
				if(!indenthdr.getIndentNo().startsWith("J")) {
					outstandingindentreportDTO.add(prepareIndentHdrOutstandingReprotDeptWiseDTO(indenthdr));
				}
				
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return outstandingindentreportDTO;
	}

	private OutstandingIndentReportDTO prepareIndentHdrOutstandingReprotDeptWiseDTO(ScmIndentHeader indenthdr) {
		OutstandingIndentReportDTO outstandingindentreportDTO = new OutstandingIndentReportDTO();
		List<ScmIndentLineItem> indentlineitems = 
								indentlineitemDao.getScmIndentLineItemByIndentNo(indenthdr.getIndentNo());
		
		outstandingindentreportDTO.setDate(indenthdr.getIndentDate());
		outstandingindentreportDTO.setIndentNo(indenthdr.getIndentNo());
		
		List<OutstandingReportLineItemDTO> lineitemDTOs = new ArrayList<>();
		
		for(int i = 0 ; i < indentlineitems.size() ; i ++) {
			OutstandingReportLineItemDTO lineitemDTO = new OutstandingReportLineItemDTO();
			ItemMaster items = itemDao.getItemMasterById(indentlineitems.get(i).getItemCode());
			
			lineitemDTO.setCancelQnt(indentlineitems.get(i).getCancelQnt());
			lineitemDTO.setDept(indentlineitems.get(i).getDeptCode());
			lineitemDTO.setDescription(items.getitemDsc());
			lineitemDTO.setIndentQnt(indentlineitems.get(i).getIndentQnt());
			lineitemDTO.setItemCode(items.getId());
			lineitemDTO.setOrderQnt(indentlineitems.get(i).getPoQnt());
			lineitemDTO.setSrlNo(indentlineitems.get(i).getIndentSrlNo());
			lineitemDTO.setUnit(items.getuomCode());
			
			long balanceQnt = (indentlineitems.get(i).getIndentQnt() - indentlineitems.get(i).getPoQnt());
			lineitemDTO.setBalanceQnt(balanceQnt);
			
			lineitemDTOs.add(lineitemDTO);
			
		}
		
		outstandingindentreportDTO.setOustandingreportDTO(lineitemDTOs);
		
		
//		outstandingindentreportDTO.setBalanceQntToSupp(balanceQntToSupp);
//		
//		outstandingindentreportDTO.setLastSuppDate(lastSuppDate);
//		outstandingindentreportDTO.setSupplyQnt(supplyQnt);
		
		
//		System.out.println(depts);
		
		return outstandingindentreportDTO;
	}

	@Override
	public List<OutstandingIndentReportDTO> getAllOutstandingIndentReportGroupWise(Date startDate, Date endDate,
			String group) {
		List<OutstandingIndentReportDTO> outstandingindentreportDTO = new ArrayList<>();
		try {
			List<ScmIndentHeader> indentheaders = indenthdrDao.getScmIndentHeaderByModDate(startDate, endDate);
			indentheaders.forEach(indenthdr->{
				if(!indenthdr.getIndentNo().startsWith("J")) {
					outstandingindentreportDTO.add(prepareIndentHdrOutstandingReprotgroupWiseDTO(indenthdr,group));
				}
				
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return outstandingindentreportDTO;
	}

	private OutstandingIndentReportDTO prepareIndentHdrOutstandingReprotgroupWiseDTO(ScmIndentHeader indenthdr,
			String group) {
		OutstandingIndentReportDTO outstandingindentreportDTO = new OutstandingIndentReportDTO();
		List<ScmIndentLineItem> indentlineitems = 
								indentlineitemDao.getScmIndentLineItemByIndentNo(indenthdr.getIndentNo());
		
		boolean groups = indentlineitems.stream()
								.map(ScmIndentLineItem :: getGrpCode)
								.collect(Collectors.toList())
								.contains(group);
		
//		if(groups) {
			outstandingindentreportDTO.setDate(indenthdr.getIndentDate());
			outstandingindentreportDTO.setIndentNo(indenthdr.getIndentNo());
			
			List<OutstandingReportLineItemDTO> lineitemDTOs = new ArrayList<>();
			
			for(int i = 0 ; i < indentlineitems.size() ; i ++) {
				OutstandingReportLineItemDTO lineitemDTO = new OutstandingReportLineItemDTO();
				ItemMaster items = itemDao.getItemMasterById(indentlineitems.get(i).getItemCode());
				
				lineitemDTO.setCancelQnt(indentlineitems.get(i).getCancelQnt());
				lineitemDTO.setDept(indentlineitems.get(i).getDeptCode());
				lineitemDTO.setDescription(items.getitemDsc());
				lineitemDTO.setIndentQnt(indentlineitems.get(i).getIndentQnt());
				lineitemDTO.setItemCode(items.getId());
				lineitemDTO.setOrderQnt(indentlineitems.get(i).getPoQnt());
				lineitemDTO.setSrlNo(indentlineitems.get(i).getIndentSrlNo());
				lineitemDTO.setUnit(items.getuomCode());
				
				long balanceQnt = (indentlineitems.get(i).getIndentQnt() - indentlineitems.get(i).getPoQnt());
				lineitemDTO.setBalanceQnt(balanceQnt);
				System.out.println(lineitemDTO);
				lineitemDTOs.add(lineitemDTO);
				
			}
			
			outstandingindentreportDTO.setOustandingreportDTO(lineitemDTOs);
			
			
//			outstandingindentreportDTO.setBalanceQntToSupp(balanceQntToSupp);
//			
//			outstandingindentreportDTO.setLastSuppDate(lastSuppDate);
//			outstandingindentreportDTO.setSupplyQnt(supplyQnt);
//		}
		
		
		System.out.println(groups);
		System.out.println(group);
		return outstandingindentreportDTO;
	}

	@Override
	public List<IndentSummaryReportWaitingForPODTO> getAllIndentSummaryReportWaitingForPO(Date indentDate) {
		List<IndentSummaryReportWaitingForPODTO> reportDTOs = new ArrayList<>();
		try {
			List<ScmIndentHeader> indenthdrs = indenthdrDao.getScmIndentHeaderByModOn(indentDate);
			indenthdrs.forEach(indent->{
				List<POLineItem> lineitems = polineitemDao.getPOLineItemByIndentNo(indent.getIndentNo());
				if(lineitems.isEmpty()) {
					reportDTOs.add(prepareIndentReport10DTO(indent));
				}
//				reportDTOs.add(prepareIndentReport10DTO(indent));
			});
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return reportDTOs;
	}

	private IndentSummaryReportWaitingForPODTO prepareIndentReport10DTO(ScmIndentHeader indent) {
		IndentSummaryReportWaitingForPODTO reportDTO = new IndentSummaryReportWaitingForPODTO();
		List<ScmIndentLineItem> indentlines = indentlineitemDao.getScmIndentLineItemByIndentNo(indent.getIndentNo());
		
		List<IndentReport10LineDTO> lines = new ArrayList<>();
		for(int i = 0 ; i < indentlines.size() ; i++) {
			IndentReport10LineDTO linedto = new IndentReport10LineDTO();
			ItemMaster item = itemDao.getItemMasterById(indentlines.get(i).getItemCode());
			Department dept = deptDao.getDepartmentByDeptId(item.getdeptId());
			
			linedto.setDept(dept.getdepartmentName());
			linedto.setDescription(item.getitemDsc());
			linedto.setIndentQnt(indentlines.get(i).getIndentQnt());
			linedto.setItemCode(item.getId());
			linedto.setSrlNo(indentlines.get(i).getIndentSrlNo());
			linedto.setUnit(item.getuomCode());
			linedto.setBalanceQnt(indentlines.get(i).getIndentQnt());
			linedto.setCancelQnt(0);
			
			lines.add(linedto);
		}
		
		reportDTO.setDate(indent.getIndentDate());
		reportDTO.setIndentNo(indent.getIndentNo());
		reportDTO.setLines(lines);
		
		return reportDTO;
	}

}
