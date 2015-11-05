package eRSPG.Repository;

import java.util.List;

import eRSPG.model.Department;

public interface DepartmentDAO {

	List<Department> findAllDepartment();

	Department findDepartment(int dId);

	int addDepartment(Department d);

	boolean updateDepartment(Department d);

	boolean deleteDepartment(Department d);

}