package com.sls.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sls.report.entity.POLineItemHist;


@Repository
public interface POLineItemHistRepository extends JpaRepository<POLineItemHist, Long> {

	POLineItemHist findByPoNumAndLineItemNum(String poNum, long lineitemnum);
	
}
