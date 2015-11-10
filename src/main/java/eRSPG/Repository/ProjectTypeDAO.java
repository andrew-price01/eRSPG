package eRSPG.Repository;

import java.util.List;

import eRSPG.model.ProjectType;

public interface ProjectTypeDAO {

	List<ProjectType> findAllProjectType();

	ProjectType findProjectType(int ptid);

	int addNewProjectType(ProjectType pt);

	boolean updateProjectType(ProjectType a);

	boolean deleteProjectType(ProjectType p);

}