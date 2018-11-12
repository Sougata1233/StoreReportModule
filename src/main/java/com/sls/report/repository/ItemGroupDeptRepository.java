package com.sls.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sls.report.entity.ItemGroupDept;


public interface ItemGroupDeptRepository extends CrudRepository<ItemGroupDept, Long> {
	
	List<ItemGroupDept> findByDeptId(long deptId);
	
	
	List<ItemGroupDept> findByItemGrp(String itemGrp);
	
	@Query("select i from ItemGroupDept i where i.itemGrp = :itemGrp")
	ItemGroupDept findByItemGrpEntity(@Param("itemGrp") String itemGrp);
	ItemGroupDept findByItemGrpAndDeptId(String itemGrp , long deptId);
	
	@Query("select i from ItemGroupDept i where i.itemGrp = :itemGrp and i.isMapped = :isMapped")
	List<ItemGroupDept> findByItemGrpAndIsMapped(@Param("itemGrp") String itemGrp , @Param("isMapped") String isMapped);
	
	@Query(value = "SELECT ITEM_GRP_DEPT_MAP_SEQ.nextval FROM dual", nativeQuery =true)
	long seqVal();

}
