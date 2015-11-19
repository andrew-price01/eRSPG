package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eRSPG.model.AwardType;

@Repository
public class AwardTypeImpl implements AwardTypeDAO {
	
	private Session session;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public AwardTypeImpl(){
		
	}

	public AwardTypeImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional
	public List<AwardType> findAllAwardTyps(){
		@SuppressWarnings("unchecked")
		List<AwardType> aList = (List<AwardType>) sessionFactory.getCurrentSession()
                .createCriteria(AwardType.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return aList;
	}
	
	@Transactional
	public AwardType findAwardType(int aid){
		AwardType a = new AwardType();
		a = sessionFactory.getCurrentSession().get(AwardType.class, aid);
		return a;
	}
	
	@Transactional
	public int addNewAwardType(AwardType a){
		sessionFactory.getCurrentSession().saveOrUpdate(a);
		return 0;
	}
	
	@Transactional
	public boolean deleteAwardType(AwardType a){
		sessionFactory.getCurrentSession().delete(a);
		boolean success = false;
		return success;
	}
}
