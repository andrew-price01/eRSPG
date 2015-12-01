package eRSPG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Awarded")
public class Awarded {
	@Id
	@Column(name="awardedID")
	private int awardedId;
	
	@Column(name="proposalID")
	private int proposalId;
	
	@Column(name="awardedAmount")
	private double awardedAmount;
	
	@Column(name="awardedTypeID")
	private int awardedTypeId;
	
	public Awarded(){
		
	}

	public int getAwardedId() {
		return awardedId;
	}

	public void setAwardedId(int awardedId) {
		this.awardedId = awardedId;
	}

	public int getProposalId() {
		return proposalId;
	}

	public void setProposalId(int proposalId) {
		this.proposalId = proposalId;
	}

	public double getAwardedAmount() {
		return awardedAmount;
	}

	public void setAwardedAmount(double awardedAmount) {
		this.awardedAmount = awardedAmount;
	}

	public int getAwardedTypeId() {
		return awardedTypeId;
	}

	public void setAwardedTypeId(int awardedTypeId) {
		this.awardedTypeId = awardedTypeId;
	}
}
