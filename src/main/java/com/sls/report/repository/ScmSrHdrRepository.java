package com.sls.report.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sls.report.entity.ScmSrHdr;

@Repository
public interface ScmSrHdrRepository extends JpaRepository<ScmSrHdr, Long>{

	ScmSrHdr findByStoreReceiveNo(long receiveNo);
	ScmSrHdr findByPoNum(String ponum);
	List<ScmSrHdr> findBySuppCode(String suppCode);
	ScmSrHdr findByStoreReceiveNoAndStoreReceiveDtBetween(long srno, Date startDate, Date endDate);
	List<ScmSrHdr> findByStoreReceiveDtBetween(Date startDate, Date endDate);
	List<ScmSrHdr> findByStoreReceiveDtAndSrGoodReceptStatus(Date srDate, String status);
	List<ScmSrHdr> findByStoreReceiveDt(Date date);
	List<ScmSrHdr> findByStoreReceiveDtBetweenAndSrGoodReceptStatus(Date startDate, Date endDate, String status);
}
