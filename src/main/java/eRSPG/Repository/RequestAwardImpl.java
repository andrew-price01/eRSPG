package eRSPG.Repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import eRSPG.model.RequestAward;

public class RequestAwardImpl implements RequestAwardDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public RequestAwardImpl(){
		
	}
	
	public RequestAwardImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional
	public List<RequestAward> findAllRequestAward(){
		@SuppressWarnings("unchecked")
		List<RequestAward> raList = (List<RequestAward>) sessionFactory.getCurrentSession()
                .createCriteria(RequestAward.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return raList;
	}
	
	@Transactional
	public RequestAward findRequestRewardById(int raid){
		RequestAward ra = sessionFactory.getCurrentSession().get(RequestAward.class, raid);
		return ra;
	}
	
	@Transactional
	public void addNewOrUpdateRequestAward(RequestAward ra){
		sessionFactory.getCurrentSession().saveOrUpdate(ra);
	}
	
	public void deleteRequestAward(RequestAward ra){
		sessionFactory.getCurrentSession().delete(ra);
	}
}
