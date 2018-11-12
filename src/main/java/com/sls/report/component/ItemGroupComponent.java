package com.sls.report.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.ItemGroupMaster;
import com.sls.report.repository.ItemGroupMasterRepository;

@Component
public class ItemGroupComponent {
	
	@Autowired
	ItemGroupMasterRepository groupRepo;

	public ItemGroupMaster getItemGroupByGroupId(String groupId) {
		return groupRepo.findOne(groupId);
	}
	
	public ItemGroupMaster getItemGroupByGroupgrpdsc(String grpDsc) {
		return groupRepo.findByGrpDsc(grpDsc);
	}
	
}
