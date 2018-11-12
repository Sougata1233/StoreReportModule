package com.sls.report.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.report.entity.ScmIndentCancel;

public interface ScmIndentCancelRepository extends JpaRepository<ScmIndentCancel, Long> {

	List<ScmIndentCancel> findByIndentNO(String indentNo);
	List<ScmIndentCancel> findByCancelDateBetween(Date startDate, Date endDate);
	
}
