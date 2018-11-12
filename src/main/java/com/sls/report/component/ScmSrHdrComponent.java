package com.sls.report.component;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.ScmSrHdr;
import com.sls.report.repository.ScmSrHdrRepository;

@Component
public class ScmSrHdrComponent {
	
	@Autowired
	ScmSrHdrRepository srhdrRepository;
	
	@Transactional
	public List<ScmSrHdr> getAllScmSrHdr(){
		return srhdrRepository.findAll();
	}
	
	@Transactional
	public ScmSrHdr getScmSrHdrById(long id) {
		return srhdrRepository.findOne(id);
	}
	
	@Transactional
	public ScmSrHdr getScmSrHdrByPoNo(String pono) {
		return srhdrRepository.findByPoNum(pono);
	}
	
	@Transactional
	public List<ScmSrHdr> getAllSrHdrBySuppCode(String suppCode){
		return srhdrRepository.findBySuppCode(suppCode);
	}
	
	@Transactional
	public ScmSrHdr getAllSrHdrBySrNoAndReceiptDate(long srno, Date startDate, Date endDate){
		return srhdrRepository.findByStoreReceiveNoAndStoreReceiveDtBetween(srno,startDate,endDate);
	}
	
	@Transactional
	public List<ScmSrHdr> getAllSrHdrByReceiptDate(Date startDate, Date endDate){
		return srhdrRepository.findByStoreReceiveDtBetween(startDate,endDate);
	}
	
	@Transactional
	public List<ScmSrHdr> getAllApprovedSrBySrDate(Date srDate){
		return srhdrRepository.findByStoreReceiveDtAndSrGoodReceptStatus(srDate, "3");
	}
	
	@Transactional
	public List<ScmSrHdr> getAllApprovedSrBySrDateBetween(Date startDate, Date endDate){
		return srhdrRepository.findByStoreReceiveDtBetweenAndSrGoodReceptStatus(startDate, endDate, "3");
	}
	
	@Transactional
	public List<ScmSrHdr> getAllSrBySrDate(Date srDate){
		return srhdrRepository.findByStoreReceiveDt(srDate);
	}

}
