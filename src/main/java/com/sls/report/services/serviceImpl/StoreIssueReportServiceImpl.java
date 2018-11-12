package com.sls.report.services.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sls.report.component.ItemMasterComponent;
import com.sls.report.component.ScmIssueHdrComponent;
import com.sls.report.component.ScmIssueLineItemComponent;
import com.sls.report.component.ScmSrHdrComponent;
import com.sls.report.component.ScmSrLineItemComponent;
import com.sls.report.dto.StoreIssueReportIS19DTO;
import com.sls.report.entity.ItemMaster;
import com.sls.report.entity.ScmIssueHdr;
import com.sls.report.entity.ScmIssueLineItem;
import com.sls.report.entity.ScmSrLineItem;

@Service
public class StoreIssueReportServiceImpl {

	@Autowired
	ItemMasterComponent itemDao;
	
	@Autowired
	ScmSrLineItemComponent srlineitemDao;
	
	@Autowired
	ScmSrHdrComponent srhdrDao;
	
	@Autowired
	ScmIssueHdrComponent issuehdrDao;
	
	@Autowired
	ScmIssueLineItemComponent issuelineitemDao;
	
	public List<StoreIssueReportIS19DTO> getAllStoreIssueReportIS19(String startDate, String endDate) {
		List<StoreIssueReportIS19DTO> storeissueDTOs = new ArrayList<>();
		try {
			Date sd = Date.valueOf(startDate+"-01");
			Date ed = Date.valueOf(endDate+"-31");
			List<ScmIssueHdr> issuehdrs = issuehdrDao.getAllIssueHdrByModDate(sd, ed);
//			List<ItemMaster> items = itemDao.getAllItemMaster();
			List<ScmIssueLineItem> issues = issuelineitemDao.getAllScmIssueLineItem();
			issuehdrs.forEach(issue->{
				List<ScmIssueLineItem> issuelineitems = issuelineitemDao.getIssueLineItemByIssueNo(issue.getId());
				if(!issuelineitems.isEmpty()) {
					storeissueDTOs.add(prepareStoreIssueDTO(issuelineitems,sd,ed, issues));
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return storeissueDTOs;
	}

	private StoreIssueReportIS19DTO prepareStoreIssueDTO(
			List<ScmIssueLineItem> issuelineitems, Date sd, Date ed, List<ScmIssueLineItem> issues) {
		StoreIssueReportIS19DTO storeissuereportDTO = new StoreIssueReportIS19DTO();
		
		
		
		String majorItemCode = null;
		String majorDescription = null;
		String majorUnit = null;
		float majorQuantity = 0.0f;
		float majorAmount = 0.0f;
		float majorAvgConsumption = 0.0f;
		
		String minorItemCode = null;
		String minorDescription = null;
		String minorUnit = null;
		float minorQuantity = 0.0f;
		float minorAmount = 0.0f;
		float minorAvgConsumption = 0.0f;
		
		String totalItemCode = null;
		String totalDescription = null;
		String totalUnit = null;
		float totalQantity = 0.0f;
		float totalAmount = 0.0f;
		float totalAvgConsumption = 0.0f;
		
		
		List<ScmIssueLineItem> issueqtys = issuelineitemDao.getTop100LineItemsByIssueQnt();
		float totqnt = 0.0f;
		for(int j = 0 ; j < issues.size() ; j++) {
			totqnt = totqnt + issues.get(j).getIssueQty();
		}
		float issueqt = 0.0f;
		for(int x = 0 ; x < issueqtys.size() ; x++) {
			issueqt = issueqt + issueqtys.get(x).getIssueQty();
		}
		float per = (issueqt/totqnt)*100;
		if(per>=47) {
			for(int k = 0 ; k < issuelineitems.size() ; k++) {
				/*ScmIssueHdr issuehdr = issuehdrDao.getScmIssuHdrBySrHdr(issuelineitems.get(k).getIssueNo());
				List<ScmIssueHdr> issuehdr1 = 
						issuehdrDao.getAllIssueHdrByIssueDate(sd, ed);*/
				ItemMaster item = itemDao.getItemMasterById(issuelineitems.get(k).getItemCode());
				majorQuantity = majorQuantity + issuelineitems.get(k).getIssueQty();
				majorAvgConsumption = majorQuantity /12;
				
				List<ScmSrLineItem> srlines = srlineitemDao.getScmSrLineItemByItemCode(item.getId());
				float rate = 0.0f;
				for(int l = 0 ; l < srlines.size() ; l++) {
					rate = srlines.get(k).getReceivedPrice();
				}
				majorAmount = majorQuantity * rate;
				
				storeissuereportDTO.setMajorAmount(majorAmount);
				storeissuereportDTO.setMajorAvgConsumption(majorAvgConsumption);
				storeissuereportDTO.setMajorDescription(item.getitemDsc());
				storeissuereportDTO.setMajorItemCode(item.getgrpCode()+item.getlegacyItemCode());
				storeissuereportDTO.setMajorQuantity(majorQuantity);
				storeissuereportDTO.setMajorUnit(item.getuomCode());
				
				
			}
			
		}else if(per<47){
			for(int k = 0 ; k < issuelineitems.size() ; k++) {
				/*ScmIssueHdr issuehdr = issuehdrDao.getScmIssuHdrBySrHdr(issuelineitems.get(k).getIssueNo());
				List<ScmIssueHdr> issuehdr1 = 
						issuehdrDao.getAllIssueHdrByIssueDate(sd, ed);*/
				ItemMaster item = itemDao.getItemMasterById(issuelineitems.get(k).getItemCode());
				minorQuantity = minorQuantity + issuelineitems.get(k).getIssueQty();
				minorAvgConsumption = minorQuantity /12;
				
				List<ScmSrLineItem> srlines = srlineitemDao.getScmSrLineItemByItemCode(item.getId());
				float rate = 0.0f;
				for(int l = 0 ; l < srlines.size() ; l++) {
					rate = srlines.get(k).getReceivedPrice();
				}
				minorAmount = majorQuantity * rate;
				
				storeissuereportDTO.setMinorAmount(minorAmount);
				storeissuereportDTO.setMinorAvgConsumption(minorAvgConsumption);
				storeissuereportDTO.setMinorDescription(item.getitemDsc());
				storeissuereportDTO.setMinorItemCode(item.getgrpCode()+item.getlegacyItemCode());
				storeissuereportDTO.setMinorQuantity(minorQuantity);
				storeissuereportDTO.setMinorUnit(item.getuomCode());
				
			}
		}
		storeissuereportDTO.setTotalAmount(majorAmount+minorAmount);
		storeissuereportDTO.setTotalAvgConsumption(majorAvgConsumption+minorAvgConsumption);
		storeissuereportDTO.setTotalQuantity(majorQuantity+minorQuantity);
		
		
		System.out.println("per "+((issueqt/totqnt)*100));
		System.out.println("quantity "+totqnt);
		System.out.println("top two "+issueqt);
		System.out.println("top two size "+issueqtys);
		System.out.println(issues.size());
		
		return storeissuereportDTO;
	}
	
}
