package eRSPG.Repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eRSPG.model.SourceType;

@Repository
public class SourceTypeImpl implements SourceTypeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SourceTypeImpl(){
		
	}
	
	public SourceTypeImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional
	public List<SourceType> findAllSourceType(){
		@SuppressWarnings("unchecked")
		List<SourceType> raList = (List<SourceType>) sessionFactory.getCurrentSession()
                .createCriteria(SourceType.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return raList;
	}
	
	@Transactional
	public SourceType findSourceTypeById(int raid){
		SourceType ra = sessionFactory.getCurrentSession().get(SourceType.class, raid);
		return ra;
	}
	
	@Transactional
	public SourceType findSourceTypeByDesc(String desc){
		SourceType ra = new SourceType();
		//TODO: query for a proposal using the desc
		return ra;
	}
	
	@Transactional
	public void addNewOrUpdateSourceType(SourceType ra){
		sessionFactory.getCurrentSession().saveOrUpdate(ra);
	}
	
	@Transactional
	public void deleteSourceType(SourceType ra){
		sessionFactory.getCurrentSession().delete(ra);
	}
}
