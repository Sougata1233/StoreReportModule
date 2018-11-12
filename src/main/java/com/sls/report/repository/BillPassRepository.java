package com.sls.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.report.entity.BillPass;

public interface BillPassRepository extends JpaRepository<BillPass, Long> {

	BillPass findByPoNo(String pono);
	BillPass findBySrMrNum(String srno);
	
}
