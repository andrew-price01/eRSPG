package eRSPG.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import eRSPG.util.LocalDateTimeDeserializer;
import eRSPG.util.LocalDateTimeSerializer;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProposalDTO implements Serializable {
    @JsonProperty(value = "id")
    private Integer proposalId;
    @JsonProperty(value = "name")
    private String proposalName;
    @JsonProperty(value = "submitDate")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime proposalSubmissionDate;
    @JsonProperty(value = "director")
    private String projectDirector;
    @JsonProperty(value = "department")
    private String departmentName;
    @JsonProperty(value = "year")
    private Integer proposalYear;
    @JsonProperty(value = "status")
    private Integer proposalStatus;
    @JsonProperty("user")
    private String user;

    public ProposalDTO() {}

    public ProposalDTO(Proposal proposal, Department department, User user) {
        this.proposalId = proposal.getProposalId();
        this.proposalName = proposal.getProposalTitle();
        this.proposalSubmissionDate = proposal.getSubmissionDate();
        this.projectDirector = proposal.getProjectDirector();
        this.departmentName = department.getDepartmentName();
        this.proposalYear = proposal.getProposalYear();
        this.proposalStatus = proposal.getProposalStatus();
        this.user = user.getFirstName() + ' ' + user.getLastName();
    }

    public Integer getProposalId() {
        return proposalId;
    }

    public void setProposalId(Integer proposalId) {
        this.proposalId = proposalId;
    }

    public String getProposalName() {
        return proposalName;
    }

    public void setProposalName(String proposalName) {
        this.proposalName = proposalName;
    }

    public LocalDateTime getProposalSubmissionDate() {
        return proposalSubmissionDate;
    }

    public void setProposalSubmissionDate(LocalDateTime proposalSubmissionDate) {
        this.proposalSubmissionDate = proposalSubmissionDate;
    }

    public String getProjectDirector() {
        return projectDirector;
    }

    public void setProjectDirector(String projectDirector) {
        this.projectDirector = projectDirector;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getProposalYear() {
        return proposalYear;
    }

    public void setProposalYear(Integer proposalYear) {
        this.proposalYear = proposalYear;
    }

    public Integer getProposalStatus() {
        return proposalStatus;
    }

    public void setProposalStatus(Integer proposalStatus) {
        this.proposalStatus = proposalStatus;
    }

    public String getUserId() {
        return user;
    }

    public void setUserId(String user) {
        this.user = user;
    }
}
