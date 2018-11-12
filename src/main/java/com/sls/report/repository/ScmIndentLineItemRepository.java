package com.sls.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.report.entity.ScmIndentLineItem;

public interface ScmIndentLineItemRepository extends JpaRepository<ScmIndentLineItem, Long> {

	List<ScmIndentLineItem> findByIndentNo(String indentNo);
	List<ScmIndentLineItem> findByItemCode(String itemCode);
	
}
