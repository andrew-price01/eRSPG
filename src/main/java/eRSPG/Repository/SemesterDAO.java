package eRSPG.Repository;

import java.util.List;

import eRSPG.model.Semester;

public interface SemesterDAO {

	List<Semester> findAllSemester();

	Semester findSemesterById(int raid);

	int addSemester(Semester ra);

	boolean updateSemester(Semester ra);

	boolean deleteSemester(Semester ra);

}