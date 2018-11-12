package com.sls.report.entity;


import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")
public class Department implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "DEPT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "DEPARTMENT_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "ORG_ID")
    private Long orgId;

    /*@OneToOne(cascade = {  }, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORG_ID",insertable = false, updatable = false)
    private Organization organization;*/
    
    /*@OneToMany(cascade = {  },fetch= FetchType.EAGER)
    @JoinColumn(name = "DEPT_ID")
    private List<Employee> employees;*/
    
    @Column(name = "DEPT_NAME")
    private String departmentName;
    
    @Column(name = "MOD_BY")
    private String modby;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
    
    
    public Department() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }
    
    
    /*public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }*/
	
    
    /*public List<Employee> getEmployee() {
    	return employees;
        }

        public void setId(List<Employee> employees) {
    	this.employees = employees;
        }
	*/
	
	public Long getorgId() {
	return orgId;
    }

    public void setorgId(Long orgId) {
	this.orgId = orgId;
    }

    public String getdepartmentName() {
	return departmentName;
    }

    public void setdepartmentName(String departmentName) {
	this.departmentName = departmentName;
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
	return "Department [id=" + id + ",orgId="+orgId+" departmentName=" + departmentName + ",  modby=" + modby + ", modifiedOn=" + modifiedOn + "]";
    }

    

   

}

