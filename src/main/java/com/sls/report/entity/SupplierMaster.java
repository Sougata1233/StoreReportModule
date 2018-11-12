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
@Table(name = "SUPPLIERMASTER")
public class SupplierMaster implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "SUPP_CODE")
    private String id;

    @Column(name = "SUPP_NAME")
    private String suppName;

    @Column(name = "ADDRESS_1")
    private String address1;
    
    @Column(name = "ADDRESS_2")
    private String address2;
    
    @Column(name = "ADDRESS_3")
    private String address3;
    
    
    @Column(name = "SUPP_TYPE")
    private String suppTyp;
              
    
    @Column(name = "PHONE_1")
    private String phone1;
    
    @Column(name = "PHONE_2")
    private String phone2;
    
    @Column(name = "FAX")
    private String fax;
    
    @Column(name = "CELL_PHONE")
    private String cellPhone;
    
    @Column(name = "EMAIL")
    private String email;
    
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
    
    @Column(name = "ACTIVE_FLAG")
    private String activeFlag;
    
    
    @Column(name = "SALETAXNO")
    private String saleTaxNo;
    
    @Column(name = "BLACK_LISTED_TAG")
    private String blackListedTag;
    
    @Column(name = "BLACK_LISTED_DATE")
    private Date blackListedDate;
   
	@Column(name = "VATNO")
	 private String vatno;  
    
    @Column(name = "CONTACT_PERSON")
	 private String contactPerson;  
    
    @Column(name = "DESIGNATION")
	 private String designation; 
   
	@Column(name = "CST")
	 private String cst;  
    
    @Column(name = "CIN")
	 private String cin;
    
    @Column(name = "GSTNO")
	 private String gstNo;
    
    @Column(name = "PANNO")
	 private String panNo;
    
   
    @Column(name = "MOD_BY")
    private String modby;

    @Column(name = "MOD_ON")
    private Date modOn;
   
	@Column(name = "DISTRICT")
	 private String district;
    
    @Column(name = "STATE")
	 private String state;
    
    @Column(name = "COUNTRY")
	 private String country;
    
    @Column(name = "PINCODE")
	 private String pincode;
    
    public SupplierMaster() {
	super();
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }
    
    public String getsuppTyp() {
	  return suppTyp;
    }

    public void setsuppTyp(String suppTyp) {
	  this.suppTyp = suppTyp;
    }

    public String getsuppName() {
	return suppName;
    }

    public void setsuppName(String suppName) {
	this.suppName = suppName;
    }

    public String getaddress1() {
    	return address1;
    }

    public void setaddress1(String address1) {
    	this.address1 = address1;
    }
    
    public String getaddress2() {
    	return address2;
    }

    public void setaddress2(String address2) {
    	this.address2 = address2;
    }
    
    public String getaddress3() {
    	return address3;
    }

    public void setaddress3(String address3) {
    	this.address3 = address3;
    }
    
   
    
    public String getphone1() {
    	return phone1;
    }

    public void setphone1(String phone1) {
    	this.phone1 = phone1;
    }
    
    public String getphone2() {
    	return phone2;
    }

    public void setphone2(String phone2) {
    	this.phone2 = phone2;
    }
    
    
    public String getfax() {
    	return fax;
    }

    public void setfax(String fax) {
    	this.fax = fax;
    }
    
    
    public String getactiveFlag() {
    	return activeFlag;
    }

    public void setactiveFlag(String activeFlag) {
    	this.activeFlag = activeFlag;
    }
    
    
    public String getsaleTaxNo() {
    	return saleTaxNo;
    }

    public void setsaleTaxNo(String saleTaxNo) {
    	this.saleTaxNo = saleTaxNo;
    }
    
    public String getemail() {
    	return email;
    }

    public void setemail(String email) {
    	this.email = email;
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
    
    public String getcellPhone() {
    	return cellPhone;
    }

    public void setcellPhone(String cellPhone) {
    	this.cellPhone = cellPhone;
    }
    
    public String getblackListedTag() {
    	return blackListedTag;
    }

    public void setblackListedTag(String blackListedTag) {
    	this.blackListedTag = blackListedTag;
    }
    
    
    public Date getblackListedDate() {
    	return blackListedDate;
    }

    public void setblackListedDate(Date blackListedDate) {
    	this.blackListedDate = blackListedDate;
    }
    
    public String getvatno() {
    	return vatno;
    }

    public void setvatno(String vatno) {
    	this.vatno = vatno;
    }
    
    public String getcontactPerson() {
    	return contactPerson;
    }

    public void setcontactPerson(String contactPerson) {
    	this.contactPerson = contactPerson;
    }
    
    
    public String getdesignation() {
    	return designation;
    }

    public void setdesignation(String designation) {
    	this.designation = designation;
    }
    
   
   
   public String getcst() {
   	return cst;
   }

   public void setcst(String cst) {
   	this.cst = cst;
   }
   
   
   public String getcin() {
	   	return cin;
   }

   public void setcin(String cin) {
	   	this.cin = cin;
   }
   
   public String getgstNo() {
	   	return gstNo;
  }

  public void setgstNo(String gstNo) {
	   	this.gstNo = gstNo;
  }
  
  
  public String getpanNo() {
  	return panNo;
  }

  public void setpanNo(String panNo) {
  	this.panNo = panNo;
  }

    public String getmodby() {
	return modby;
    }

    public void setmodby(String modby) {
	this.modby = modby;
    }

    public Date getmodifiedOn() {
	return modOn;
    }

    public void setmodifiedOn(Date modifiedOn) {
	this.modOn = modifiedOn;
    }
    
   
   public String getdistrict() {
		return district;
   }

   public void setdistrict(String district) {
		this.district = district;
   }
   
   public String getstate() {
		return state;
  }

  public void setstate(String state) {
		this.state = state;
  }
  
  
  public String getcountry() {
		return country;
  }

  public void setcountry(String country) {
		this.country = country;
  }
  
  public String getpincode() {
		return pincode;
  }

 public void setpincode(String pincode) {
		this.pincode = pincode;
 }
  

    
    @Override
    public String toString() {
	return "SupplierMaster [id=" + id + ", suppName=" + suppName + "]";
    }

    

   

}

