package com.sls.report.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.POLineItem;
import com.sls.report.repository.POLineItemRepository;

@Component
public class POLineItemComponent {
	
	@Autowired
	POLineItemRepository lineitemRepository;
	
	@Transactional
	public List<POLineItem> getAllPOLineItem(){
		return lineitemRepository.findAll();
	}
	
	@Transactional
	public POLineItem getPOLineItemById(long id) {
		return lineitemRepository.findOne(id);
	}
	
	@Transactional
	public List<POLineItem> getPOLineItemByPoNo(String pono) {
		return lineitemRepository.findByPoId(pono);
	}
	
	@Transactional
	public List<POLineItem> getPOLineItemByItemCode(String itemCode) {
		return lineitemRepository.findByItemId(itemCode);
	}
	
	@Transactional
	public List<POLineItem> getPOLineItemByIndentNo(String indentNo){
		return lineitemRepository.findByIndentId(indentNo);
	}
	
	@Transactional
	public POLineItem getPOLineItemByIndentNoAndItemCode(String indentNo, String itemCode){
		return lineitemRepository.findByIndentIdAndItemId(indentNo,itemCode);
	}

}
