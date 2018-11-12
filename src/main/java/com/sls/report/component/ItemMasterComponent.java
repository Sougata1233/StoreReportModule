package com.sls.report.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.ItemMaster;
import com.sls.report.repository.ItemMasterRepository;

@Component
public class ItemMasterComponent {
	
	@Autowired
	ItemMasterRepository itemRepository;
	
	@Transactional
	public List<ItemMaster> getAllItemMaster(){
		return itemRepository.findAll();
	}
	
	@Transactional
	public ItemMaster getItemMasterById(String id) {
		return itemRepository.findById(id);
	}
	
	@Transactional
	public ItemMaster getItemMasterByDesc(String itemDsc) {
		return itemRepository.findByItemDsc(itemDsc);
	}
	
	@Transactional
	public List<ItemMaster> getAllStoreItemMaster(){
		return itemRepository.findByGroupCodeStore();
	}
	
	@Transactional
	public List<ItemMaster> getItemMasterByGroupCode(String groupCode){
		return itemRepository.findByGrpCode(groupCode);
	}
	
	@Transactional
	public List<ItemMaster> getItemMasterByHsnCode(String hsncode){
		return itemRepository.findByHsnCode(hsncode);
	}

}
