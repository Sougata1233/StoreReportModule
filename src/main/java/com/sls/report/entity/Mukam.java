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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MUKAM")
public class Mukam implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id()
    @Column(name = "MUKAM_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "MUKAM_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "MUKAM_NAME")
    private String mukamName;

   
    public Mukam() {
	super();
    }
    
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getmukamName() {
	return mukamName;
    }

    public void setmukamName(String mukamName) {
    	this.mukamName = mukamName;
    }

    
    @Override
    public String toString() {
	return "Mukam [id=" + id + ", mukamName=" + mukamName + "]";
    }

    

   

}

