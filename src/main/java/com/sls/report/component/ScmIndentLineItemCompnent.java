package com.sls.report.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.ScmIndentLineItem;
import com.sls.report.repository.ScmIndentLineItemRepository;

@Component
public class ScmIndentLineItemCompnent {
	
	@Autowired
	ScmIndentLineItemRepository indentlineitemRepository;
	
	@Transactional
	public List<ScmIndentLineItem> getAllScmIndentLineItem(){
		return indentlineitemRepository.findAll();
	}
	
	@Transactional
	public ScmIndentLineItem getScmIndentLineItemById(long id) {
		return indentlineitemRepository.getOne(id);
	}
	
	@Transactional
	public List<ScmIndentLineItem> getScmIndentLineItemByIndentNo(String indentNo) {
		return indentlineitemRepository.findByIndentNo(indentNo);
	}
	
	@Transactional
	public List<ScmIndentLineItem> getIndentLineItemByItemCode(String itemCode){
		return indentlineitemRepository.findByItemCode(itemCode);
	}

}
