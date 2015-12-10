package eRSPG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RequestAward")
public class RequestAward {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="requestAwardID")
	private int requestAwardId;
	
	@Column(name="awardTypeID")
	private int awardTypeId;
	
	@Column(name="proposalID")
	private int proposalId;
	
	public RequestAward(){
		
	}

	public int getRequestAwardId() {
		return requestAwardId;
	}

	public void setRequestAwardId(int requestAwardId) {
		this.requestAwardId = requestAwardId;
	}

	public int getAwardTypeId() {
		return awardTypeId;
	}

	public void setAwardTypeId(int awardTypeId) {
		this.awardTypeId = awardTypeId;
	}

	public int getProposalId() {
		return proposalId;
	}

	public void setProposalId(int proposalId) {
		this.proposalId = proposalId;
	}
	
}
