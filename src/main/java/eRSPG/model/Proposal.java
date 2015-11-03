package eRSPG.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proposal")
public class Proposal {
	@Id
	@Column(name="proposalID")
	private int proposalId;
	
	@Column(name="proposalTitle")
	private String proposalTitle;
	
	@Column(name="semesterID")
	private int semesterId;
	
	@Column(name="proposalYear")
	private int proposalYear ;

	@Column(name="proposalTypeID")
	private int projectTypeId;
	
	@Column(name="proposalSubmissionDate")
	private Date submissionDate;
	
	@Column(name="projectDirectot")
	private String projectDirector;
	
	@Column(name="departmentID")
	private String departmentId;

	@Column(name="proposalEmail")
	private String proposalEmail;
	
	@Column(name="proposalMailCode")
	private String proposalMailCode;
	
	@Column(name="proposalExtension")
	private String proposalExtension;
	
	@Column(name="proposalReqStudentAssistance")
	private String proposalReqStdAsst;
	
	@Column(name="proposalComplete")
	private String proposalComplete;
	
	@Column(name="updatedDate")
	private String updatedDate;
	
	public Proposal() {
		
	}

	public int getProposalId() {
		return proposalId;
	}

	public void setProposalId(int proposalId) {
		this.proposalId = proposalId;
	}

	public String getProposalTitle() {
		return proposalTitle;
	}

	public void setProposalTitle(String proposalTitle) {
		this.proposalTitle = proposalTitle;
	}

	public int getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}

	public int getProposalYear() {
		return proposalYear;
	}

	public void setProposalYear(int proposalYear) {
		this.proposalYear = proposalYear;
	}

	public int getProjectTypeId() {
		return projectTypeId;
	}

	public void setProjectTypeId(int projectTypeId) {
		this.projectTypeId = projectTypeId;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getProjectDirector() {
		return projectDirector;
	}

	public void setProjectDirector(String projectDirector) {
		this.projectDirector = projectDirector;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getProposalEmail() {
		return proposalEmail;
	}

	public void setProposalEmail(String proposalEmail) {
		this.proposalEmail = proposalEmail;
	}

	public String getProposalMailCode() {
		return proposalMailCode;
	}

	public void setProposalMailCode(String proposalMailCode) {
		this.proposalMailCode = proposalMailCode;
	}

	public String getProposalExtension() {
		return proposalExtension;
	}

	public void setProposalExtension(String proposalExtension) {
		this.proposalExtension = proposalExtension;
	}

	public String getProposalReqStdAsst() {
		return proposalReqStdAsst;
	}

	public void setProposalReqStdAsst(String proposalReqStdAsst) {
		this.proposalReqStdAsst = proposalReqStdAsst;
	}

	public String getProposalComplete() {
		return proposalComplete;
	}

	public void setProposalComplete(String proposalComplete) {
		this.proposalComplete = proposalComplete;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
}

