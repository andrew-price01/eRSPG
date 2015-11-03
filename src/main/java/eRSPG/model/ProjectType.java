package eRSPG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProjectType")
public class ProjectType {
	
	@Id
	@Column(name="projectTypeID")
	private int projectTypeID;
	
	@Column(name="projectTypeName")
	private String projectTypeName;

	public ProjectType(){
		
	}
	
	public int getProjectTypeID() {
		return projectTypeID;
	}

	public void setProjectTypeID(int projectTypeID) {
		this.projectTypeID = projectTypeID;
	}

	public String getProjectTypeName() {
		return projectTypeName;
	}

	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}
}