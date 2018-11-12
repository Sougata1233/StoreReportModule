package com.sls.report.component;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.POLineItemHist;
import com.sls.report.repository.POLineItemHistRepository;

@Component
public class POLineItemHistComponent {
	
	@Autowired
	POLineItemHistRepository lineitemhistRepo;
	
	@Transactional
	public POLineItemHist getPOLineItemHistByPoNumAndLineItemNum(String poNum, long lineitemNum) {
		return lineitemhistRepo.findByPoNumAndLineItemNum(poNum, lineitemNum);
	}

}
