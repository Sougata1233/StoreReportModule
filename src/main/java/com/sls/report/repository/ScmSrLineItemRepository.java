package com.sls.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sls.report.entity.ScmSrLineItem;

@Repository
public interface ScmSrLineItemRepository extends JpaRepository<ScmSrLineItem, Long> {

	List<ScmSrLineItem> findByStoreReceiveNo(long receiveNo);
	List<ScmSrLineItem> findByLineitemdetails(String itemCode);
	
}
