package com.sls.report.entity;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "ITEM_GROUP_MASTER")
public class ItemGroupMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "GROUP_CODE")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @OneToMany(fetch= FetchType.EAGER)
    @JoinColumn(name = "GROUP_CODE")
    private List<ItemMaster> itemmasteres;
   
    @Column(name = "GROUP_DESC")
    private String grpDsc;
    
    @Column(name = "ACTIVE_FLAG")
    private String activeFlag;
    
    @Column(name = "PURCHASE_CODE", nullable = true)
    private Long purchaseCode;
 
    @Column(name = "INACTIVE_TAG")
    private String inactiveTag;
    
    
    @Column(name = "MOD_BY")
    private String modBy;
    
    @Column(name = "MOD_ON")
    private Date modOn;
    
    /*@OneToMany(fetch= FetchType.EAGER)
    private List<Department> department;
    
    
    public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}*/

	public ItemGroupMaster() {
	super();
    }

    public String getId() {
	return id;
    }
    
    public List<ItemMaster> getItemMaster() {
    	return itemmasteres;
    }

    public void setItemMaster(List<ItemMaster> itemmasteres) {
    	this.itemmasteres = itemmasteres;
    }
	
	

    public void setId(String id) {
	this.id = id;
    }
	
    public String getgrpDsc() {
       	return grpDsc;
    }

    public void setgrpDsc(String grpDsc) {
      this.grpDsc = grpDsc;
    }



    public String getactiveFlag() {
	return activeFlag;
    }

    public void setactiveFlag(String activeFlag) {
	this.activeFlag = activeFlag;
    }
    
    
    public Long getpurchaseCode() {
    	return purchaseCode;
    }

    public void setpurchaseCode(Long purchaseCode) {
    	this.purchaseCode = purchaseCode;
    }
    
    public String getinactiveTag() {
    	return inactiveTag;
    }

    public void setinactiveTag(String inactiveTag) {
    	this.inactiveTag = inactiveTag;
    }
    
    public String getmodBy() {
    	return modBy;
    }

    public void setmodBy(String modBy) {
    	this.modBy = modBy;
    }
    
    
    public Date getmodOn() {
    	return modOn;
    }

    public void setmodOn(Date modOn) {
    	this.modOn = modOn;
    }

    
    @Override
    public String toString() {
	return "State [id=" + id + ",grpDsc=" + grpDsc + ", activeFlag=" + activeFlag +  "]";
    }

    

   

}

