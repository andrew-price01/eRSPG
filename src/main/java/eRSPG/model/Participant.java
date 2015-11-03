package eRSPG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Participant")
public class Participant {
	@Id
	@Column(name="participantID")
	private int participantId;
	
	@Column(name="projectID")
	private int projectId;
	
	@Column(name="participantFirstName")
	private String firstName;
	
	@Column(name="participantLastName")
	private String lastName;
	
	@Column(name="proposalID")
	private int proposalId;
	
	public Participant(){
		
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getProposalId() {
		return proposalId;
	}

	public void setProposalId(int proposalId) {
		this.proposalId = proposalId;
	}
	
}
