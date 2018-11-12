package com.sls.report.component;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.ScmIndentCancel;
import com.sls.report.repository.ScmIndentCancelRepository;

@Component
public class ScmIndentCancelComponent {
	
	@Autowired
	ScmIndentCancelRepository indentcancelDao;
	
	@Transactional
	public List<ScmIndentCancel> getAllScmIndentCancel(){
		return indentcancelDao.findAll();
	}

	@Transactional
	public List<ScmIndentCancel> getScmIndentCancelByIndentNo(String indentNo){
		return indentcancelDao.findByIndentNO(indentNo);
	}
	
	@Transactional
	public List<ScmIndentCancel> getIndentCancelByDate(Date startDate, Date endDate){
		return indentcancelDao.findByCancelDateBetween(startDate, endDate);
	}

	
	
	
}
