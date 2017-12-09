package eRSPG.Repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eRSPG.model.ProjectType;

@Repository
public class ProjectTypeImpl implements ProjectTypeDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProjectTypeImpl(){
		
	}
	
	public ProjectTypeImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional 
	public List<ProjectType> findAllProjectType(){
		@SuppressWarnings("unchecked")
		List<ProjectType> ptList = (List<ProjectType>) sessionFactory.getCurrentSession()
                .createCriteria(ProjectType.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return ptList;
	}
	
	@Transactional
	public ProjectType findProjectType(int ptid){
		ProjectType pt = sessionFactory.getCurrentSession().get(ProjectType.class, ptid);
		return pt;
	}
	
	@Transactional
	public void addNewOrUpdateProjectType(ProjectType pt){
		sessionFactory.getCurrentSession().saveOrUpdate(pt);
	}
	
	@Transactional
	public void deleteProjectType(ProjectType p){
		sessionFactory.getCurrentSession().delete(p);
	}

}
