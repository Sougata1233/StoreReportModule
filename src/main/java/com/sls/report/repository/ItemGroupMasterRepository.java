package com.sls.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sls.report.entity.ItemGroupMaster;

public interface ItemGroupMasterRepository extends CrudRepository<ItemGroupMaster, String> {

    ItemGroupMaster findByGrpDsc(String grpDsc);

}
