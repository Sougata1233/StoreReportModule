package com.sls.report.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.ScmSrLineItem;
import com.sls.report.repository.ScmSrLineItemRepository;

@Component
public class ScmSrLineItemComponent {
	
	@Autowired
	ScmSrLineItemRepository lineitemRepository;
	
	@Transactional
	public List<ScmSrLineItem> getAllScmSrLineItem(){
		return lineitemRepository.findAll();
	}
	
	@Transactional
	public List<ScmSrLineItem> getScmSrLineItemByReceiveNo(long receiveNo) {
		return lineitemRepository.findByStoreReceiveNo(receiveNo);
	}
	
	@Transactional
	public List<ScmSrLineItem> getScmSrLineItemByItemCode(String itemCode) {
		return lineitemRepository.findByLineitemdetails(itemCode);
	}
	
	@Transactional
	public ScmSrLineItem getScmSrLineItemByLineItemNo(long id) {
		return lineitemRepository.findOne(id);
	}

}
