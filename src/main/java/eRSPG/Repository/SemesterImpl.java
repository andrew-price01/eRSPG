package eRSPG.Repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eRSPG.model.Semester;

@Repository	
public class SemesterImpl implements SemesterDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SemesterImpl(){
		
	}
	
	public SemesterImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional
	public List<Semester> findAllSemester(){
		@SuppressWarnings("unchecked")
		List<Semester> raList = (List<Semester>) sessionFactory.getCurrentSession()
                .createCriteria(Semester.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return raList;
	}
	
	@Transactional
	public Semester findSemesterById(int raid){
		Semester ra = sessionFactory.getCurrentSession().get(Semester.class, raid);
		return ra;
	}
	
	public void addNewOrUpdateSemester(Semester ra){
		sessionFactory.getCurrentSession().saveOrUpdate(ra);
	}
	
	@Transactional
	public void deleteSemester(Semester ra){
		sessionFactory.getCurrentSession().delete(ra);
	}
}
