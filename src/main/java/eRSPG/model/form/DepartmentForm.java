package eRSPG.model.form;

import javax.validation.constraints.NotNull;

public class DepartmentForm {

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
	
	
	
}
