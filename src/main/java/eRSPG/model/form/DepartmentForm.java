package eRSPG.model.form;

import eRSPG.model.Proposal;

import javax.validation.constraints.NotNull;

public class DepartmentForm extends BaseForm{

	@NotNull
	private int departmentID;
	
	@NotNull
	private int year;
	
	@NotNull
	private int semesterID;

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public int getYear() {
		if (year == 0)
			year = new java.util.Date().getYear() + 1900;
		
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemesterID() {
		return semesterID;
	}

	public void setSemesterID(int semesterID) {
		this.semesterID = semesterID;
	}
	
	@Override
	public void LoadFormIntoProposal(Proposal proposal){
		proposal.setDepartmentId(departmentID);
		proposal.setSemesterId(semesterID);
		proposal.setProposalYear(year);
	}
	
}
