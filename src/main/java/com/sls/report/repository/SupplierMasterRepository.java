package com.sls.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sls.report.entity.SupplierMaster;

public interface SupplierMasterRepository extends CrudRepository<SupplierMaster, String>{

    SupplierMaster findById(String i);
    
    @Query(value = "SELECT SUPPLIER_SEQ.nextval FROM dual", nativeQuery = true)
     Long getNextSeriesId();
    
    @Query(value = "SELECT SUPPLIER_SEQ FROM dual", nativeQuery = true)
    Long getPresentSeq();
    
    
    
    @Query("select s from SupplierMaster s where s.id = :id and s.suppTyp = :suppTyp")
    SupplierMaster findBySuppCodeAndSuppType(@Param("id") String id, @Param("suppTyp") String suppTyp);
    
    SupplierMaster findBySuppNameAndSuppTyp(String suppName, String suppType);
    
    List<SupplierMaster> findBySuppTyp(String suppType);
    
    SupplierMaster findBySuppName(String suppName);
    
    

   // List<Activity> findByUserName(String userName);

    // custom query example and return a stream
   // @Query("select u from User u where u.userName = :userName")
   // Stream<Activity> findByUserNameReturnStream(@Param("userName") String userName);

}
