package com.sls.report.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.report.entity.POLineItem;

public interface POLineItemRepository extends JpaRepository<POLineItem, Long> {

   List<POLineItem> findByPoId(String poId);
   List<POLineItem> findByIndentId(String string);
   List<POLineItem> findByItemId(String itemCode);
//   POLineItem findByPoId(String poid);
   POLineItem findByIndentIdAndItemId(String indentNo, String itemCode);

}
