package com.sls.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sls.report.entity.ItemMaster;

public interface ItemMasterRepository extends JpaRepository<ItemMaster, Long>{

    ItemMaster findById(String id);

    @Query("select i from ItemMaster i where i.grpCode = :grpCode")
    List<ItemMaster> findByGroupCode(@Param("grpCode") String grpCode);
    
    @Query("select i from ItemMaster i where i.grpCode != '999'")
    List<ItemMaster> findByGroupCodeStore();
    
    List<ItemMaster> findByGrpCode(String grpCode);
    
    @Query(value = "SELECT ITEMMASTER_SEQ.nextval FROM dual", nativeQuery = true)
    Long getNextSeriesId();
    
    @Query("delete  from ItemMaster i where i.id = :id")
    void deletes(@Param("id") String id);

	ItemMaster findByItemDsc(String itemDesc);
    
	List<ItemMaster> findByHsnCode(String hsncode);
    

}
