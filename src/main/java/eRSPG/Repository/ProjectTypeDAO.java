package eRSPG.Repository;

import java.util.List;

public interface ProjectTypeDAO {

	List<ProjectType> findAllProjectType();

	ProjectTypeDAO findProjectType(int ptid);

	int addNewProjectType(ProjectTypeDAO pt);

	boolean updateProjectType(ProjectTypeDAO a);

	boolean deleteProjectType(ProjectTypeDAO p);

}