package com.sls.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="SCM_HSN_GST_MAP")
public class ItemTax {
	
	@Id
	@Column(name="ID")
	private  String id;
	
	@Column(name="HSN_CODE", insertable = false, updatable = false)
	private  String hsnCode ;
	
		
	@Column(name="GST")
	private  Integer gst;
	
//	@OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "HSN_CODE")
//	@JsonIgnore
//	private ItemMaster itemInTax;
	
	
	 public ItemTax()
	    {
	        super();
	    }

	    public ItemTax(String id,Integer gst,String hsnCode)
	    {
	        super();
	        this.id = id;
	        this.gst=gst;
	        this.hsnCode=hsnCode;
//	        this.itemInTax=itemInTax;
	        
	    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	

	public Integer getGst() {
		return gst;
	}

	public void setGst(Integer gst) {
		this.gst = gst;
	}

	@Override
	public String toString() {
		return "ItemTax [id=" + id + ", hsnCode=" + hsnCode + ", gst=" + gst + "]";
	}

	/*public ItemMaster getItemInTax() {
		return itemInTax;
	}

	public void setItemInTax(ItemMaster itemInTax) {
		this.itemInTax = itemInTax;
	}*/
	
}
