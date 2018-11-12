package com.sls.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.report.entity.IssueLineItem;

public interface IssueLineItemRepository extends JpaRepository<IssueLineItem, Long> {

	List<IssueLineItem> findByItemId(String itemId);
	
}
