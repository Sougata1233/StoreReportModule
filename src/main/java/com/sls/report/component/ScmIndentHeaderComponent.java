package com.sls.report.component;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.ScmIndentHeader;
import com.sls.report.repository.ScmIndentHeaderRepository;

@Component
public class ScmIndentHeaderComponent {
	
	@Autowired
	ScmIndentHeaderRepository indenthdrRepository;
	
	@Transactional
	public List<ScmIndentHeader> getAllScmIndentHeader(){
		return indenthdrRepository.findAll();
	}
	
	@Transactional
	public ScmIndentHeader getScmIndentHeaderByIndentNo(String indentNo) {
		return indenthdrRepository.findOne(indentNo);
	}
	
	@Transactional
	public ScmIndentHeader getScmIndentHeaderByIndentNoAndIndentType(String indentNo, String indentType) {
		return indenthdrRepository.findByIndentNoAndIndentType(indentNo, indentType);
	}
	
	@Transactional
	public List<ScmIndentHeader> getScmIndentHeaderByDate(Date startDate, Date endDate){
		return indenthdrRepository.findByIndentDateBetween(startDate, endDate);
	}
	
	@Transactional
	public List<ScmIndentHeader> getScmIndentHeaderByIndentDate(Date indentDate){
		return indenthdrRepository.findByIndentDate(indentDate);
	}
	
	@Transactional
	public List<ScmIndentHeader> getScmIndentHeaderByModOn(Date modon){
		return indenthdrRepository.findByModOn(modon);
	}
	
	@Transactional
	public List<ScmIndentHeader> getScmIndentHeaderByModDate(Date startDate, Date endDate){
		return indenthdrRepository.findByModOnBetween(startDate, endDate);
	}

}
