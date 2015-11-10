package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import eRSPG.model.EssayQuestion;

public class ProjectType {
	public List<ProjectType> findAllProjectType(){
		//TODO: query and return a list of Proposal
		List<ProjectType> ptList = new ArrayList();
		return ptList;
	}
	
	public ProjectType findProjectType(int ptid){
		ProjectType pt = new ProjectType();
		//TODO: query for a proposal using the pid
		return pt;
	}
	
	public int addNewProjectType(ProjectType pt){
		//TODO: 
		return 0;
	}
	
	public boolean updateProjectType(ProjectType a){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteProjectType(ProjectType p){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
