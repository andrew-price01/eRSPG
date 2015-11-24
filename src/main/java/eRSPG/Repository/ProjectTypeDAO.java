package eRSPG.Repository;

import java.util.List;

import eRSPG.model.ProjectType;

public interface ProjectTypeDAO {

	List<ProjectType> findAllProjectType();

	ProjectType findProjectType(int ptid);

	void addNewOrUpdateProjectType(ProjectType pt);

	void deleteProjectType(ProjectType p);

}