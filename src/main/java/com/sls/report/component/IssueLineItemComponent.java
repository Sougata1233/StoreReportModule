package com.sls.report.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.IssueLineItem;
import com.sls.report.repository.IssueLineItemRepository;

@Component
public class IssueLineItemComponent {
	
	@Autowired
	IssueLineItemRepository lineitemRepository;
	
	@Transactional
	public List<IssueLineItem> getIssueLineItemByItemId(String itemId){
		return lineitemRepository.findByItemId(itemId);
	}

}
