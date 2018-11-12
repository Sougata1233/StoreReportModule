package com.sls.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sls.report.entity.ScmIssueLineItem;

public interface ScmIssueLineItemRepository extends JpaRepository<ScmIssueLineItem, String>{

	List<ScmIssueLineItem> findByItemCode(String itemCode);
//	ScmIssueLineItem findByAdditionalRequirement
	List<ScmIssueLineItem> findByQuality(String quality);
	List<ScmIssueLineItem> findByIssueNo(String issueNO);
	List<ScmIssueLineItem> findByGroupCode(String grpCode);
	List<ScmIssueLineItem> findTop2ByIssueNoOrderByIssueQtyDesc(String issueNo);
	
	/*@Query("select i from ScmIssueLineItem i order by i.issueQty desc where i.itemCode = :itemCode and rownum <=100")
	List<ScmIssueLineItem> findAllOrderByIssueQty(@Param("itemCode") String itemCode);*/
}
