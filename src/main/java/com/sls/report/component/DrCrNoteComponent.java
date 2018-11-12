package com.sls.report.component;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.DrCrNote;
import com.sls.report.repository.DrCrNoteRepository;

@Component
public class DrCrNoteComponent {
	
	@Autowired
	DrCrNoteRepository drcrRepository;
	
	@Transactional
	public List<DrCrNote> getAllDrCrNote(){
		return drcrRepository.findAll();
	}
	
	@Transactional
	public DrCrNote getDrCrNoteById(long id) {
		return drcrRepository.findOne(id);
	}
	
	@Transactional
	public List<DrCrNote> getDrCrNoteByAdjustmentDate(Date startDate, Date endDate) {
		return drcrRepository.findByAdjustmentDateBetween(startDate,endDate);
	}

}
