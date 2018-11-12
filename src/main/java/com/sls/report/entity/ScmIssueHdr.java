package com.sls.report.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * Entity for ScmIssueHdr
 */

@Entity
@Table(name = "SCM_ISSUE_HDR")
public class ScmIssueHdr {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISSUE_HDR_SEQ")
	@SequenceGenerator(sequenceName = "SCM_ISSUE_HEADER_SEQ", allocationSize = 1, name = "ISSUE_HDR_SEQ")
	@Column(name = "ISSUE_NO", nullable = true)
	private String id;

	@Column(name = "ISSUE_TYPE")
	private String issueType;

	@Column(name = "ISSUE_STATUS")
	private String issueStatus;

	@Column(name = "USER_1")
	private String submitter;

	@Column(name = "FIN_YEAR")
	private String finnacialYear;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "ISSUE_DATE")
	private Date issueDate;

	@Column(name = "UNIT_ID")
	private String unitId;

	@Column(name = "DEPT_ID")
	private String deptId;

	@Column(name = "MOD_BY")
	private String lastModifiedUser;

	@Column(name = "MOD_ON")
	private Date lastModifiedDate;

	@Column(name = "GOOD_TYPE")
	private String goodType;

	@Column(name = "ISSUED_TO")
	private String issuedTo;

	@Column(name = "EXPCODE")
	private String expCode;

	@Column(name = "DEPTCOST")
	private String deptCost;

	@Column(name = "LOT_NO")
	private Long lotNo;

	public String getExpCode() {
		return expCode;
	}

	public void setExpCode(String expCode) {
		this.expCode = expCode;
	}

	public String getDeptCost() {
		return deptCost;
	}

	public void setDeptCost(String deptCost) {
		this.deptCost = deptCost;
	}

	public Long getLotNo() {
		return lotNo;
	}

	public void setLotNo(Long lotNo) {
		this.lotNo = lotNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public String getFinnacialYear() {
		return finnacialYear;
	}

	public void setFinnacialYear(String finnacialYear) {
		this.finnacialYear = finnacialYear;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
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

	public String getGoodType() {
		return goodType;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}

	public String getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(String issuedTo) {
		this.issuedTo = issuedTo;
	}

	@Override
	public String toString() {
		return "ScmIssueHdr [id=" + id + ", issueType=" + issueType + ", issueStatus=" + issueStatus + ", submitter="
				+ submitter + ", finnacialYear=" + finnacialYear + ", createDate=" + createDate + ", issueDate="
				+ issueDate + ", unitId=" + unitId + ", deptId=" + deptId + ", lastModifiedUser=" + lastModifiedUser
				+ ", lastModifiedDate=" + lastModifiedDate + ", goodType=" + goodType + ", issuedTo=" + issuedTo + "]";
	}

	public ScmIssueHdr(String id, String issueType, String issueStatus, String submitter, String finnacialYear,
			Date createDate, Date issueDate, String unitId, String deptId, String lastModifiedUser,
			Date lastModifiedDate, String goodType, String issuedTo) {
		super();
		this.id = id;
		this.issueType = issueType;
		this.issueStatus = issueStatus;
		this.submitter = submitter;
		this.finnacialYear = finnacialYear;
		this.createDate = createDate;
		this.issueDate = issueDate;
		this.unitId = unitId;
		this.deptId = deptId;
		this.lastModifiedUser = lastModifiedUser;
		this.lastModifiedDate = lastModifiedDate;
		this.goodType = goodType;
		this.issuedTo = issuedTo;
	}

	public ScmIssueHdr() {
		super();
		// TODO Auto-generated constructor stub
	}

}
