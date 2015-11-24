package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eRSPG.model.AwardType;
import eRSPG.model.Department;

@Repository
public class DepartmentImpl implements DepartmentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public DepartmentImpl(){
		
	}
	
	public DepartmentImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional
	public List<Department> findAllDepartment(){
		@SuppressWarnings("unchecked")
		List<Department> dList = (List<Department>) sessionFactory.getCurrentSession()
                .createCriteria(Department.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return dList;
	}
	
	@Transactional
	public Department findDepartment(int dId){
		Department d = sessionFactory.getCurrentSession().get(Department.class, dId);
		return d;
	}
	
	@Transactional
	public void addNewOrUpdateDepartment(Department d){
		sessionFactory.getCurrentSession().saveOrUpdate(d);
	}
	
	@Transactional
	public void deleteDepartment(Department d){
		sessionFactory.getCurrentSession().delete(d);
	}
}
