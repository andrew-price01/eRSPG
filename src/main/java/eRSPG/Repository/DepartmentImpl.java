package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eRSPG.model.Department;

@Repository
public class DepartmentImpl implements DepartmentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public DepartmentImpl(){
		
	}
	
	public List<Department> findAllDepartment(){
		//TODO: query and return a list of Proposal
		List<Department> dList = new ArrayList();
		return dList;
	}
	
	public Department findDepartment(int dId){
		Department d = new Department();
		//TODO: query for a proposal using the pid
		return d;
	}
	
	
	public int addNewDepartment(Department d){
		//TODO:
		return 0;
	}
	
	public boolean updateDepartment(Department d){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteDepartment(Department d){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
