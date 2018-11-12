package com.sls.report.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.ItemGroupDept;
import com.sls.report.repository.ItemGroupDeptRepository;

@Component
public class ItemGroupDeptDao {

	@Autowired
	ItemGroupDeptRepository itemgroupdeptRepository;
	
	@Transactional
	public List<ItemGroupDept> getItemGroupDeptMappingByItemGroup(String itemGroup){
		return itemgroupdeptRepository.findByItemGrp(itemGroup);
	}
	
	@Transactional
	public List<ItemGroupDept> getItemGroupDeptMappingByDept(long deptCode){
		return itemgroupdeptRepository.findByDeptId(deptCode);
	}
	
}
