package com.sls.report.entity;


import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UOMMASTER")
public class UomMaster implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "UOM_CODE")
    private String id;

    @Column(name = "UOM_DESC")
    private String uomDsc;


    @Column(name = "USER_1")
    private String user1;
    
    
    @Column(name = "DATE_1")
    private Date date1;
    
    @Column(name = "USER_2")
    private String user2;
    
    
    @Column(name = "DATE_2")
    private Date date2;
    
    @Column(name = "USER_3")
    private String user3;
    
    
    @Column(name = "DATE_3")
    private Date date3;
    
    @Column(name = "USER_4")
    private String user4;
    
    
    @Column(name = "DATE_4")
    private Date date4;

    @Column(name = "ACTIVE_FLAG ")
    private String activityFlag;
    
    
    @Column(name = "MOD_BY")
    private String modby;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
    
    
    public UomMaster() {
	super();
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getuomDsc() {
	return uomDsc;
    }

    public void setuomDsc(String uomDsc) {
	this.uomDsc = uomDsc;
    }

    public String getuser1() {
	return user1;
    }

    public void setuser1(String user1) {
	this.user1 = user1;
    }

    public Date getdate1() {
	return date1;
    }

    public void setdate1(Date date1) {
	this.date1 = date1;
    }
    
    public String getuser2() {
    	return user2;
    }

    public void setuser2(String user2) {
      this.user2 = user2;
    }

    public Date getdate2() {
      return date2;
    }

    public void setdate2(Date date2) {
     this.date2 = date2;
    }
    
    public String getuser3() {
    	return user3;
    }

    public void setuser3(String user3) {
      this.user3 = user3;
    }

    public Date getdate3() {
      return date3;
    }

    public void setdate3(Date date3) {
     this.date3 = date3;
    }
    
    public String getuser4() {
    	return user4;
    }

    public void setuser4(String user4) {
      this.user4 = user4;
    }

    public Date getdate4() {
      return date4;
    }

    public void setdate4(Date date4) {
     this.date4 = date4;
    }

    public String getactivityFlag() {
	return activityFlag;
    }

    public void setactivityFlag(String activityFlag) {
	this.activityFlag = activityFlag;
    }

    public String getmodby() {
	return modby;
    }

    public void setmodby(String modby) {
	this.modby = modby;
    }

    public Date getmodifiedOn() {
	return modifiedOn;
    }

    public void setmodifiedOn(Date modifiedOn) {
	this.modifiedOn = modifiedOn;
    }

    
    @Override
    public String toString() {
	return "UomMaster [id=" + id + ", uomDsc=" + uomDsc + ", user1=" + user1 + ", modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
    }

    

   

}

