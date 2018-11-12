package com.sls.report.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.UomMaster;
import com.sls.report.repository.UomMasterRepository;

@Component
public class UomMasterComponent {
	
	@Autowired
	UomMasterRepository uomRepository;
	
	@Transactional
	public List<UomMaster> getAllUomMaster(){
		return uomRepository.findAll();
	}
	
	@Transactional
	public UomMaster getUomMasterById(String id) {
		return uomRepository.findOne(id);
	}

}
