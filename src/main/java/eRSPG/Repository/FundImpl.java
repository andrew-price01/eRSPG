package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import eRSPG.model.Fund;

public class FundImpl implements FundDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public FundImpl(){
		
	}
	
	public FundImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional
	public List<Fund> findAllFund(){
		@SuppressWarnings("unchecked")
		List<Fund> fList = (List<Fund>) sessionFactory.getCurrentSession()
                .createCriteria(Fund.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return fList;
	}
	
	@Transactional
	public Fund findFund(int fid){
		Fund f = sessionFactory.getCurrentSession().get(Fund.class, fid);
		return f;
	}
	
	@Transactional
	public void addNewOrUpdateFund(Fund f){
		sessionFactory.getCurrentSession().saveOrUpdate(f);
	}
	
	@Transactional
	public void deleteFund(Fund f){
		sessionFactory.getCurrentSession().delete(f);
	}

	@Transactional
	public void addFundList(List<Fund> fundList){
		for (Fund f:
			 fundList) {
			sessionFactory.getCurrentSession().saveOrUpdate(f);

		}
	}

	@Override
	public ArrayList<Fund> findFundsByProposalId(int proposalID) {
		//ArrayList<Fund> result = (ArrayList<Fund>) sessionFactory.getCurrentSession()
		//		.createCriteria(Fund.class)
		//		.add(Restrictions.eq("proposalID",proposalID))
		//		.list();
		return null;
	}
}
