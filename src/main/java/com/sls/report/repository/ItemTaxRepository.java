package com.sls.report.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.report.entity.ItemTax;

public interface ItemTaxRepository extends JpaRepository<ItemTax, String> {

//	ItemTax findByItemInTax(ItemMaster item);
//	List<ItemTax> findByHsnCode(String hsnCode);
	List<ItemTax> findByGst(Integer gst);
	ItemTax findByHsnCode(String hsnCode);
	

}
