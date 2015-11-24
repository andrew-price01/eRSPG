package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eRSPG.model.Awarded;
import eRSPG.model.User;

@Repository
public class AwardedImpl implements AwardedDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public AwardedImpl(){
		
	}
	
	public AwardedImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional
	public List<Awarded> findAllAwardeds(){
		List<Awarded> aList = (List<Awarded>) sessionFactory.getCurrentSession().createCriteria(Awarded.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return aList;
	}
	
	@Transactional
	public Awarded findAwarded(int aid){
		Awarded a = sessionFactory.getCurrentSession().get(Awarded.class, aid);
		return a;
	}
	
	@Transactional
	public List<Awarded> findAwardedByUser(User user){
		//TODO: query for proposal that relates to the user
		List<Awarded> aList = new ArrayList();
		return aList;
	}
	
	@Transactional
	public int addNewOrUpdateAwarded(Awarded a){
		sessionFactory.getCurrentSession().saveOrUpdate(a);
		return 0;
	}
	
	@Transactional
	public boolean deleteAwarded(Awarded a){
		sessionFactory.getCurrentSession().delete(a);
		boolean success = false;
		return success;
	}

}
