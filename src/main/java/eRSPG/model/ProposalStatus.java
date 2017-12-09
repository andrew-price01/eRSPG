package eRSPG.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="proposalstatus")
public class ProposalStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="proposalStatusID")
    @JsonProperty(value = "id")
    private Integer proposalStatusId;

    @Column(name = "proposalDescription")
    @JsonProperty(value = "name")
    private String proposalStatusDescription;

    public ProposalStatus() {}

    public ProposalStatus(Integer proposalStatusId, String proposalStatusDescription) {
        this.proposalStatusId = proposalStatusId;
        this.proposalStatusDescription = proposalStatusDescription;
    }

    public ProposalStatus(String proposalStatusDescription) {
        this.proposalStatusDescription = proposalStatusDescription;
    }

    public Integer getProposalStatusId() {
        return proposalStatusId;
    }

    public void setProposalStatusId(Integer proposalStatusId) {
        this.proposalStatusId = proposalStatusId;
    }

    public String getProposalStatusDescription() {
        return proposalStatusDescription;
    }

    public void setProposalStatusDescription(String proposalStatusDescription) {
        this.proposalStatusDescription = proposalStatusDescription;
    }
}
