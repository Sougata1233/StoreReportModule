package com.sls.report.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.report.entity.PhysicalStock;

public interface PhysicalstockRepository extends JpaRepository<PhysicalStock, Long> {
	
	List<PhysicalStock> findByLastModifiedDate(Date modon);
	List<PhysicalStock> findByitemId(String itemCode);
	List<PhysicalStock> findByQualityCode(String qualityCode);
	List<PhysicalStock> findByItemIdAndQualityCode(String itemCode, String qualityCode);
	List<PhysicalStock> findByReceiveNo(long srNo);
	
}
