package com.sls.report.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sls.report.entity.DrCrNote;

@Repository
public interface DrCrNoteRepository extends JpaRepository<DrCrNote, Long> {
	List<DrCrNote> findByAdjustmentDateBetween(Date startDate, Date endDate);
}
