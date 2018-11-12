package com.sls.report.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.GateStoreEntryRegDtl;
import com.sls.report.repository.GateStoreEntryDtlRepository;

@Component
public class GateStoreEntryDtlComponent {
	
	@Autowired
	GateStoreEntryDtlRepository storeentrydtlRepository;
	
	public long getSeq() {
		return storeentrydtlRepository.getNextSeriesId();
	}
	
	@Transactional
	public List<GateStoreEntryRegDtl> getAllGateStoreEntryRegDtl(){
		return storeentrydtlRepository.findAll();
	}
	
	@Transactional
	public GateStoreEntryRegDtl getGateStoreEntryRegDtlById(long id) {
		return storeentrydtlRepository.findOne(id);
	}
	
	@Transactional
	public GateStoreEntryRegDtl saveGateStoreEntryRegDtl(GateStoreEntryRegDtl storeentrydtlEntity) {
		return storeentrydtlRepository.save(storeentrydtlEntity);
	}
	
	@Transactional
	public void deleteGateStoreEntryRegDtl(long id) {
		storeentrydtlRepository.delete(id);
	}
	
	@Transactional
	public List<GateStoreEntryRegDtl> getEntryDtlByHdrId(long hdrId){
		return storeentrydtlRepository.findByHdrId(hdrId);
	}

}
