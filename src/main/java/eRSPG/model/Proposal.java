package eRSPG.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import eRSPG.util.LocalDateTimeDeserializer;
import eRSPG.util.LocalDateTimeSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="proposal")
public class Proposal implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="proposalID")
	private int proposalId;

	@Column(name="proposalTitle")
	private String proposalTitle;

	@Column(name="semesterID")
	private int semesterId;

	@Column(name="proposalYear")
	private int proposalYear ;

	@Column(name="projectTypeID")
	private int projectTypeId;
	
	@Column(name="proposalSubmissionDate")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime submissionDate;
	
	@Column(name="projectDirector")
	private String projectDirector;
	
	@Column(name="departmentId")
	private int departmentId;

	@Column(name="proposalEmail")
	private String proposalEmail;
	
	@Column(name="proposalMailCode")
	private String proposalMailCode;
	
	@Column(name="proposalExtension")
	private String proposalExtension;
	
	@Column(name="proposalReqStudentAssistance")
	private boolean proposalReqStdAsst;
	
	@Column(name="proposalComplete")
	private boolean proposalComplete;
	
	@Column(name="updatedDate")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime updatedDate;
	
	@Column(name="proposalParticipants")
	private String proposalParticipants;

	@Column(name="userID")
	private Integer userId;

	public Proposal() {
		
	}

	@JsonProperty("id")
	public int getProposalId() {
		return proposalId;
	}

	public void setProposalId(int proposalId) {
		this.proposalId = proposalId;
	}

	@JsonProperty("title")
	public String getProposalTitle() {
		return proposalTitle;
	}

	public void setProposalTitle(String proposalTitle) {
		this.proposalTitle = proposalTitle;
	}

	@JsonProperty("semesterId")
	public int getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}

	@JsonProperty("year")
	public int getProposalYear() {
		return proposalYear;
	}

	public void setProposalYear(int proposalYear) {
		this.proposalYear = proposalYear;
	}

	@JsonProperty("typeId")
	public int getProjectTypeId() {
		return projectTypeId;
	}

	public void setProjectTypeId(int projectTypeId) {
		this.projectTypeId = projectTypeId;
	}

	@JsonProperty("submissionDate")
	public LocalDateTime getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(LocalDateTime submissionDate) {
		this.submissionDate = submissionDate;
	}

	@JsonProperty("director")
	public String getProjectDirector() {
		return projectDirector;
	}

	public void setProjectDirector(String projectDirector) {
		this.projectDirector = projectDirector;
	}

	@JsonProperty("department")
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	@JsonProperty("email")
	public String getProposalEmail() {
		return proposalEmail;
	}

	public void setProposalEmail(String proposalEmail) {
		this.proposalEmail = proposalEmail;
	}

	@JsonProperty("mailCode")
	public String getProposalMailCode() {
		return proposalMailCode;
	}

	public void setProposalMailCode(String proposalMailCode) {
		this.proposalMailCode = proposalMailCode;
	}

	@JsonProperty("extension")
	public String getProposalExtension() {
		return proposalExtension;
	}

	public void setProposalExtension(String proposalExtension) {
		this.proposalExtension = proposalExtension;
	}

	@JsonProperty("isRequireStudentAssistance")
	public boolean isProposalReqStdAsst() {
		return proposalReqStdAsst;
	}

	public void setProposalReqStdAsst(boolean proposalReqStdAsst) {
		this.proposalReqStdAsst = proposalReqStdAsst;
	}

	@JsonProperty("isComplete")
	public boolean isProposalComplete() {
		return proposalComplete;
	}

	public void setProposalComplete(boolean proposalComplete) {
		this.proposalComplete = proposalComplete;
	}

	@JsonProperty("updateDate")
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@JsonProperty("proposalParticipants")
	public String getProposalParticipants() {
		return proposalParticipants;
	}

	public void setProposalParticipants(String proposalParticipants) {
		this.proposalParticipants = proposalParticipants;
	}

	@JsonProperty("userId")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}

