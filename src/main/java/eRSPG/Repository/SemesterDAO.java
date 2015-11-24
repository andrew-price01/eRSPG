package eRSPG.Repository;

import java.util.List;

import eRSPG.model.Semester;

public interface SemesterDAO {

	List<Semester> findAllSemester();

	Semester findSemesterById(int raid);

	void addNewOrUpdateSemester(Semester ra);

	void deleteSemester(Semester ra);

}