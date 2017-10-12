package eRSPG.model.form;

import org.hibernate.validator.constraints.NotEmpty;

public class DetailForm {

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


	
}
