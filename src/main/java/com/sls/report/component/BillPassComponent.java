package com.sls.report.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.BillPass;
import com.sls.report.repository.BillPassRepository;

@Component
public class BillPassComponent {
	
	@Autowired
	BillPassRepository billRepository;
	
	@Transactional
	public List<BillPass> getAllBillPass(){
		return billRepository.findAll();
	}
	
	@Transactional
	public BillPass getAllBillPassByPO(String pono){
		return billRepository.findByPoNo(pono);
	}
	
	@Transactional
	public BillPass getBillPassBySrNo(String srno) {
		return billRepository.findBySrMrNum(srno);
	}

}
