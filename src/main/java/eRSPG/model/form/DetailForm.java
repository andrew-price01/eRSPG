package eRSPG.model.form;

import eRSPG.model.Proposal;
import org.hibernate.validator.constraints.NotEmpty;

public class DetailForm extends BaseForm {

	@NotEmpty(message="Please enter a proposal title")
	private String proposalTitle;
	
	@NotEmpty(message="Please enter a proposal email")
	private String proposalEmail;
	private String proposalMailCode;
	private String proposalExtension;
	
	@NotEmpty(message="Please enter a project director")
	private String projectDirector; 
	
	public String getProposalTitle() {
		return proposalTitle;
	}

	public void setProposalTitle(String proposalTitle) {
		this.proposalTitle = proposalTitle;
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

	public String getProjectDirector() {
		return projectDirector;
	}

	public void setProjectDirector(String projectDirector) {
		this.projectDirector = projectDirector;
	}


	@Override
	public void LoadFormIntoProposal(Proposal proposal){
		proposal.setProposalEmail(proposalEmail);
		proposal.setProjectDirector(projectDirector);
		proposal.setProposalMailCode(proposalMailCode);
		proposal.setProposalExtension(proposalExtension);
		proposal.setProposalTitle(proposalTitle);
	}

	@Override
	public void LoadProposalIntoForm(Proposal proposal){
		this.proposalTitle = proposal.getProposalTitle();
		this.proposalEmail = proposal.getProposalEmail();
		this.proposalMailCode = proposal.getProposalMailCode();
		this.proposalExtension = proposal.getProposalExtension();
	}
	
}
