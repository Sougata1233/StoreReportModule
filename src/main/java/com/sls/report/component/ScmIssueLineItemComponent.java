package com.sls.report.component;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.ScmIssueLineItem;
import com.sls.report.repository.ScmIssueLineItemRepository;

/*
 * Component Class for ScmIssueLineItem
 */

@Component
public class ScmIssueLineItemComponent {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	ScmIssueLineItemRepository issueLineItemRepository;
	
	@Transactional
	public List<ScmIssueLineItem> getAllScmIssueLineItem(){
		return issueLineItemRepository.findAll();
	}
	
	@Transactional
	public ScmIssueLineItem getIssueLineItem(String id) {
		return issueLineItemRepository.findOne(id);
	}
	
	@Transactional
	public List<ScmIssueLineItem> getIssueLineItemByIssueNo(String id) {
		return issueLineItemRepository.findByIssueNo(id);
	}
	
	@Transactional
	public List<ScmIssueLineItem> getIssueLineItemByGroupCode(String grpCode) {
		return issueLineItemRepository.findByGroupCode(grpCode);
	}
	
	@Transactional
	public List<ScmIssueLineItem> getLineItemsByItem(String itemCode){
		return issueLineItemRepository.findByItemCode(itemCode);
	}
	
	@Transactional
	public List<ScmIssueLineItem> getIssueLineItemByQuality(String quality){
		return issueLineItemRepository.findByQuality(quality);
	}
	
	@Transactional
	public List<ScmIssueLineItem> getIssueLineitemOrderByIssueQty(String issueNo){
		return issueLineItemRepository.findTop2ByIssueNoOrderByIssueQtyDesc(issueNo);
	}
	
	/*@Transactional
	public List<ScmIssueLineItem> getAllIssueLineitemOrderByIssueQty(String itemCode){
		return issueLineItemRepository.findAllOrderByIssueQty(itemCode);
	}*/
	
	@Transactional
	public List<ScmIssueLineItem> getTop100LineItemsByIssueQnt(){
		TypedQuery<ScmIssueLineItem> query = 
				entityManager.createQuery("select i from ScmIssueLineItem i order by i.issueQty desc",
						ScmIssueLineItem.class);
		query.setFirstResult(0);
		query.setMaxResults(100);
		return query.getResultList();
	}

}
