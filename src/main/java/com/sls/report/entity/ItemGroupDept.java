package com.sls.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_GRP_DEPT_MAP")
public class ItemGroupDept {
	
	@Column(name="MAP_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ITEM_GRP_DEPT_MAP_SEQ")
	@SequenceGenerator(name="ITEM_GRP_DEPT_MAP_SEQ", sequenceName="ITEM_GRP_DEPT_MAP_SEQ")
	private long mapId;
	
	@Column(name="ITEM_GRP")
	private String itemGrp;
	
	@Column(name="DEPT_ID", nullable = true)
	private long deptId;
	
	@Column(name="IS_MAPPED")
	private String isMapped;

	public long getMapId() {
		return mapId;
	}

	public void setMapId(long mapId) {
		this.mapId = mapId;
	}

	public String getItemGrp() {
		return itemGrp;
	}

	public void setItemGrp(String itemGrp) {
		this.itemGrp = itemGrp;
	}

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public String getIsMapped() {
		return isMapped;
	}

	public void setIsMapped(String isMapped) {
		this.isMapped = isMapped;
	}

	public ItemGroupDept(long mapId, String itemGrp, long deptId, String isMapped) {
		super();
		this.mapId = mapId;
		this.itemGrp = itemGrp;
		this.deptId = deptId;
		this.isMapped = isMapped;
	}

	public ItemGroupDept() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ItemGroupDept [mapId=" + mapId + ", itemGrp=" + itemGrp + ", deptId=" + deptId + ", isMapped="
				+ isMapped + "]";
	}
	
	
	

}
