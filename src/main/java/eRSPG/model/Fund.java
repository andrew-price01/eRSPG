package eRSPG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fund")
public class Fund {
	@Id
	@Column(name="fundID")
	private int fundId;
	
	@Column(name="proposalID")
	private int proposalId;
	
	@Column(name="fundTypeID")
	private int fundTypeId;
	
	@Column(name="sourceTypeID")
	private int sourceTypeId;
	
	@Column(name="fundCategoryID")
	private int fundCategoryId;
	
	@Column(name="fundAmount")
	private double fundAmount;
	
	@Column(name="comments")
	private String comments;
	
	public Fund(){
		
	}

	public int getFundId() {
		return fundId;
	}

	public void setFundId(int fundId) {
		this.fundId = fundId;
	}

	public int getProposalId() {
		return proposalId;
	}

	public void setProposalId(int proposalId) {
		this.proposalId = proposalId;
	}

	public int getFundTypeId() {
		return fundTypeId;
	}

	public void setFundTypeId(int fundTypeId) {
		this.fundTypeId = fundTypeId;
	}

	public int getSourceTypeId() {
		return sourceTypeId;
	}

	public void setSourceTypeId(int sourceTypeId) {
		this.sourceTypeId = sourceTypeId;
	}

	public int getFundCategoryId() {
		return fundCategoryId;
	}

	public void setFundCategoryId(int fundCategoryId) {
		this.fundCategoryId = fundCategoryId;
	}

	public double getFundAmount() {
		return fundAmount;
	}

	public void setFundAmount(double fundAmount) {
		this.fundAmount = fundAmount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
