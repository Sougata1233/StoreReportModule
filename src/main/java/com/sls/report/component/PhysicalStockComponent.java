package com.sls.report.component;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.PhysicalStock;
import com.sls.report.repository.PhysicalstockRepository;

/*
 * Component Class for PhysicalStock
 */

@Component
public class PhysicalStockComponent {
	
	@Autowired
	PhysicalstockRepository physicalstockRepository;
	
	@Transactional
	public List<PhysicalStock> getAllPhysicalStock(){
		return physicalstockRepository.findAll();
	}
	
	@Transactional
	public List<PhysicalStock> getByModifiedDate(Date modon){
		return physicalstockRepository.findByLastModifiedDate(modon);
	}
	
	@Transactional
	public PhysicalStock getPhysicalStockById(long id) {
		return physicalstockRepository.findOne(id);
	}
	
	@Transactional
	public List<PhysicalStock> getPhysicalStockByItem(String itemCode){
		return physicalstockRepository.findByitemId(itemCode);
	}
	
	@Transactional
	public List<PhysicalStock> getPhysicalStockByQuality(String qualityCode){
		return physicalstockRepository.findByQualityCode(qualityCode);
	}
	
	@Transactional
	public List<PhysicalStock> getPhysicalStockByItemAndQuality(String itemCode, String qualityCode) {
		return physicalstockRepository.findByItemIdAndQualityCode(itemCode, qualityCode);
	}
	
	@Transactional
	public List<PhysicalStock> getPhysicalStockBySrNo(long srNo) {
		return physicalstockRepository.findByReceiveNo(srNo);
	}

}
