package com.sls.report.entity;


import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ITEMMASTER")
public class ItemMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id()
    @Column(name = "ITEM_CODE")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEMMASTER_SEQ")
//    @SequenceGenerator(name = "ITEMMASTER_SEQ", sequenceName = "ITEMMASTER_SEQ")
    private String id;
    
  
    @Column(name = "GROUP_CODE")
    private String grpCode;
   
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "GROUP_CODE",insertable = false, updatable = false)
//    private ItemGroupMaster itemgroupmaster;

    @Column(name = "ITEM_DESC")
    private String itemDsc;
    
    @Column(name = "LOCATION")
    private String location;
    
    @Column(name = "UOM_CODE")
    private String uomCode;
    
    @Column(name = "UOM_PUR")
    private String uomPur;
    
    @Column(name = "MULTI_FACT", nullable = true)
    private Long multiFact;
    
    @Column(name = "SR_RATE", nullable = true)
    private Long srRate;
    
    
    @Column(name = "CENTRAL_STOCK")
    private double centralStock;
    
    
    @Column(name = "DIRECT_INDIRECT_TAG")
    private String directIndirectTag;
    
    @Column(name = "SPL_ITEM_TAG")
    private String splItemTag;
    
    
    @Column(name = "ISSUABLE_TAG")
    private String issuableTag;
    
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
    
    
    @Column(name = "DTL_ITEM_DESC1")
    private String dtlItemDsc1;
    
    
    @Column(name = "DTL_ITEM_DESC2")
    private String dtlItemDsc2;
    
    
    @Column(name = "MAKE")
    private String make;
    
    
    
    @Column(name = "ITEM_PHOTO")
    private Blob itemPhoto;
    
    
    @Column(name = "HSN_CODE")
    private String hsnCode;
    
    
    @Column(name = "MOD_BY")
    private String modBy;
    
    @Column(name = "MOD_ON")
    private Date modOn;
    
    @Column(name = "THRESHOLD", nullable = true)
    private double threshold;
    
    @Column(name = "DEPT_ID", nullable = true)
    private Long deptId;
    
    @Column(name = "LEGACY_ITEM_CODE")
    private String legacyItemCode;
    
    @Column(name="MAX_VALUE", nullable = true)
    private double max;
    
    @Column(name="MAX_ORDER_VALUE", nullable = true)
    private double maxOrderValue;
    
    @Column(name="CENTRAL_STOCK_VALUE", nullable = true)
    private double centralStockValue;
    
    
    
    
    
    public double getMaxOrderValue() {
		return maxOrderValue;
	}

	public void setMaxOrderValue(double maxOrderValue) {
		this.maxOrderValue = maxOrderValue;
	}

	public double getCentralStockValue() {
		return centralStockValue;
	}

	public void setCentralStockValue(double centralStockValue) {
		this.centralStockValue = centralStockValue;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public ItemMaster() {
	super();
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }
	
    
    
//    public ItemGroupMaster getItemGroupMaster() {
//        return itemgroupmaster;
//    }
//
//    public void setItemGroupMaster(ItemGroupMaster itemgroupmaster) {
//        this.itemgroupmaster = itemgroupmaster;
//    }
     
   
    

    public String getgrpCode() {
    	return grpCode;
    }

    public void setgrpCode(String grpCode) {
    	this.grpCode = grpCode;
    }
        


    public String getitemDsc() {
	return itemDsc;
    }

    public void setitemDsc(String itemDsc) {
	this.itemDsc = itemDsc;
    }
    
    
    public String getlocation() {
    	return location;
        }

        public void setlocation(String location) {
    	this.location = location;
        }
    
    

        public String getuomCode() {
        	return uomCode;
        }

        public void setuomCode(String uomCode) {
        	this.uomCode = uomCode;
        } 
        
        
        public String getuomPur() {
        	return uomPur;
        }

        public void setuomPur(String uomPur) {
        	this.uomPur = uomPur;
        }
            
     
            
        public Long getmultiFact() {
        	return multiFact;
        }

        public void setmultiFact(Long multiFact) {
        	this.multiFact = multiFact;
        } 
        
       
        
        public Long getsrRate() {
        	return srRate;
        }

        public void setsrRate(Long srRate) {
        	this.srRate = srRate;
        } 
        
       
        public double getcentralStock() {
        	return centralStock;
        }

        public void setcentralStock(double centralStock) {
        	this.centralStock =centralStock;
        }
        
        
        
        
        public String getdirectIndirectTag() {
        	return directIndirectTag;
        }

        public void setdirectIndirectTag(String directIndirectTag) {
        	this.directIndirectTag =directIndirectTag;
        }
        
        
        
        
        public String getsplItemTag() {
        	return splItemTag;
        }

        public void setsplItemTag(String splItemTag) {
        	this.splItemTag =splItemTag;
        }
        
        
       
        
        public String getissuableTag() {
        	return issuableTag;
        }

        public void setissuableTag(String issuableTag) {
        	this.issuableTag =issuableTag;
        }
        
        
        public String getuser1() {
        	return user1;
        }

        public void setuser1(String user1) {
        	this.user1 =user1;
        }
        
        
        public Date getdate1() {
        	return date1;
        }

        public void setdate1(Date date1) {
        	this.date1 =date1;
        }
        
        
        public String getuser2() {
        	return user2;
        }

        public void setuser2(String user2) {
        	this.user2 =user2;
        }
        
        
        public Date getdate2() {
        	return date2;
        }

        public void setdate2(Date date2) {
        	this.date2 =date2;
        }
        
        
        public String getuser3() {
        	return user3;
        }

        public void setuser3(String user3) {
        	this.user3 =user3;
        }
        
        
        public Date getdate3() {
        	return date3;
        }

        public void setdate3(Date date3) {
        	this.date3 =date3;
        }
        
        
        public String getuser4() {
        	return user4;
        }

        public void setuser4(String user4) {
        	this.user4 =user4;
        }
        
        
        public Date getdate4() {
        	return date4;
        }

        public void setdate4(Date date4) {
        	this.date4 =date4;
        }
        
       
        
        public String getactiveFlag() {
        	return activeFlag;
        }

        public void setactiveFlag(String activeFlag) {
        	this.activeFlag =activeFlag;
        }
        
        
       
        
        public String getdtlItemDsc1() {
        	return dtlItemDsc1;
        }

        public void setdtlItemDsc1(String dtlItemDsc1) {
        	this.dtlItemDsc1 =dtlItemDsc1;
        }
        
        
      
        
        
        public String getdtlItemDsc2() {
        	return dtlItemDsc2;
        }

        public void setdtlItemDsc2(String dtlItemDsc2) {
        	this.dtlItemDsc2 =dtlItemDsc2;
        }
        
        
       
        
        
        public String getmake() {
        	return make;
        }

        public void setmake(String make) {
        	this.make =make;
        }
        
        
       
        
        public Blob getitemPhoto() {
        	return itemPhoto;
        }

        public void setitemPhoto(Blob itemPhoto) {
        	this.itemPhoto =itemPhoto;
        }
        
        
        
       
        public String gethsnCode() {
        	return hsnCode;
        }

        public void sethsnCode(String hsnCode) {
        	this.hsnCode =hsnCode;
        }
        
        
        
      
        
        public String getmodBy() {
        	return modBy;
        }

        public void setmodBy(String modBy) {
        	this.modBy =modBy;
        }
        
        
        
        public Date getmodOn() {
        	return modOn;
        }

        public void setmodOn(Date modOn) {
        	this.modOn =modOn;
        }
        
        
       
        
        public double getthreshold() {
        	return threshold;
        }

        public void setthreshold(double threshold) {
        	this.threshold =threshold;
        }
        
        
        
        public Long getdeptId() {
        	return deptId;
        }

        public void setdeptId(Long deptId) {
        	this.deptId =deptId;
        }
        
       
        
        public String getlegacyItemCode() {
        	return legacyItemCode;
        }

        public void setlegacyItemCode(String legacyItemCode) {
        	this.legacyItemCode =legacyItemCode;
        }
        
    
    @Override
    public String toString() {
	return "State [id=" + id + ", itemDsc=" + itemDsc +  ",location="+location+"]";
    }

    

   

}

