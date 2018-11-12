package com.sls.report.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity()
@Table(name="PHYSICALSTOCK")

public class PhysicalStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PHYSICAL_STOCK_SEQ")
    @SequenceGenerator(sequenceName = "SCM_PHYSICAL_STOCK_SEQ", allocationSize = 1, name = "PHYSICAL_STOCK_SEQ")
	@Column(name="TRANS_ID")
	private  long id;
	
	@Column(name="STORE_ID", nullable = true)
	private  long storeId;
	
	@Column(name="GROUP_CODE")
	private  String itemGroupId;
	
	@Column(name="ITEM_CODE")
	private  String itemId;
	
	
	@Column(name="NEW_STOCK_INDENT_NUM", nullable = true)
	private  long newStockIndentId;
	
	@Column(name="EXISTING_STOCK_INDENT_NUM", nullable = true)
	private  long existingStockIndentId;
	
	
	@Column(name="NEW_STOCK", nullable = true)
	private  float newStock;
	
	@Column(name="EXISTING_STOCK", nullable = true)
	private  float existingStock;
	
	@Column(name="TOTAL_STOCK", nullable = true)
	private  float totalStock;
	
	@Column(name="STOCK_IN_HAND", nullable = true)
	private  float stockInHand;
	
	@Column(name="MOD_BY")
	private  String lastModifiedUser ;
	

	@Column(name="MOD_ON")
	private  Date lastModifiedDate ;
	
	
	@Column(name="NEW_STOCK_RCV_DATE")
	private  Date newStockReceivedDate ;
	
	@Column(name="EXT_STOCK_RCV_DATE")
	private  Date existingStockReceivedDate ;
	
	@Column(name="NEW_STOCK_EXPIRY_DATE")
	private  Date newStockExpirydDate ;
	
	@Column(name="EXT_STOCK_EXPIRY_DATE")
	private  Date existinStockExpirydDate ;
	
	@Column(name="WAREHOUSE_NO")	
	private  String wareHouseNo ;
	
	@Column(name="QUALITY_CODE")	
	private  String qualityCode ;
	
	
	
	@Column(name="GOOD_RECEIVE_NO", nullable = true)
	private  long receiveNo;
	
	@Column(name="GOOD_TYPE")	
	private  String goodType ;
	
	@Column(name="GOOD_ITEM_SRL_NO", nullable = true)	
	private  long goodItemSerialNo;
	
	
	@Column(name="NEW_BALE_STOCK", nullable = true)
	private long newBaleStock;
	
	@Column(name="EXISTING_BALE_STOCK", nullable = true)
	private long existingBaleStock;
	
	@Column(name="TOTAL_BALE_STOCK", nullable = true)
	private long totalBaleStock;
	
	@Column(name="BALE_STOCK_IN_HAND", nullable = true)
	private long baleStockInHand;
	
	@Column(name="CONVERSION_UNIT")
	private String conversionUnit;
	
	
	
	

	
	public long getNewBaleStock() {
		return newBaleStock;
	}

	public void setNewBaleStock(long newBaleStock) {
		this.newBaleStock = newBaleStock;
	}

	public long getExistingBaleStock() {
		return existingBaleStock;
	}

	public void setExistingBaleStock(long existingBaleStock) {
		this.existingBaleStock = existingBaleStock;
	}

	public long getTotalBaleStock() {
		return totalBaleStock;
	}

	public void setTotalBaleStock(long totalBaleStock) {
		this.totalBaleStock = totalBaleStock;
	}

	public long getBaleStockInHand() {
		return baleStockInHand;
	}

	public void setBaleStockInHand(long baleStockInHand) {
		this.baleStockInHand = baleStockInHand;
	}

	public String getConversionUnit() {
		return conversionUnit;
	}

	public void setConversionUnit(String conversionUnit) {
		this.conversionUnit = conversionUnit;
	}

	public long getGoodItemSerialNo() {
		return goodItemSerialNo;
	}

	public void setGoodItemSerialNo(long goodItemSerialNo) {
		this.goodItemSerialNo = goodItemSerialNo;
	}

	public String getGoodType() {
		return goodType;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}

	public long getReceiveNo() {
		return receiveNo;
	}

	public void setReceiveNo(long receiveNo) {
		this.receiveNo = receiveNo;
	}

	public String getQualityCode() {
		return qualityCode;
	}

	public void setQualityCode(String qualityCode) {
		this.qualityCode = qualityCode;
	}

	public String getWareHouseNo() {
		return wareHouseNo;
	}

	public void setWareHouseNo(String wareHouseNo) {
		this.wareHouseNo = wareHouseNo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getItemGroupId() {
		return itemGroupId;
	}

	public void setItemGroupId(String itemGroupId) {
		this.itemGroupId = itemGroupId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public long getNewStockIndentId() {
		return newStockIndentId;
	}

	public void setNewStockIndentId(long newStockIndentId) {
		this.newStockIndentId = newStockIndentId;
	}

	public long getExistingStockIndentId() {
		return existingStockIndentId;
	}

	public void setExistingStockIndentId(long existingStockIndentId) {
		this.existingStockIndentId = existingStockIndentId;
	}

	public float getNewStock() {
		return newStock;
	}

	public void setNewStock(float newStock) {
		this.newStock = newStock;
	}

	public float getExistingStock() {
		return existingStock;
	}

	public void setExistingStock(float existingStock) {
		this.existingStock = existingStock;
	}

	public float getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(float totalStock) {
		this.totalStock = totalStock;
	}

	public float getStockInHand() {
		return stockInHand;
	}

	public void setStockInHand(float stockInHand) {
		this.stockInHand = stockInHand;
	}

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Date getNewStockReceivedDate() {
		return newStockReceivedDate;
	}

	public void setNewStockReceivedDate(Date newStockReceivedDate) {
		this.newStockReceivedDate = newStockReceivedDate;
	}

	public Date getExistingStockReceivedDate() {
		return existingStockReceivedDate;
	}

	public void setExistingStockReceivedDate(Date existingStockReceivedDate) {
		this.existingStockReceivedDate = existingStockReceivedDate;
	}

	public Date getNewStockExpirydDate() {
		return newStockExpirydDate;
	}

	public void setNewStockExpirydDate(Date newStockExpirydDate) {
		this.newStockExpirydDate = newStockExpirydDate;
	}

	public Date getExistinStockExpirydDate() {
		return existinStockExpirydDate;
	}

	public void setExistinStockExpirydDate(Date existinStockExpirydDate) {
		this.existinStockExpirydDate = existinStockExpirydDate;
	}
	
	
	

}
