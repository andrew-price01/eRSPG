package eRSPG.Repository;

import java.util.List;

import eRSPG.model.Department;

public interface DepartmentDAO {

	List<Department> findAllDepartment();

	Department findDepartment(int dId);

	void addNewOrUpdateDepartment(Department d);

	void deleteDepartment(Department d);

}