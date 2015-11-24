package eRSPG.Repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import eRSPG.model.FundCategory;

public class FundCategoryImpl implements FundCategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public FundCategoryImpl(){
		
	}
	
	public FundCategoryImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional
	public List<FundCategory> findAllFundCategory(){
		@SuppressWarnings("unchecked")
		List<FundCategory> fcList = (List<FundCategory>) sessionFactory.getCurrentSession()
                .createCriteria(FundCategory.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return fcList;
	}

	@Transactional
	public FundCategory findFundCategory(int fid){
		FundCategory fc = sessionFactory.getCurrentSession().get(FundCategory.class, fid);
		return fc;
	}
	
	@Transactional
	public void addNewOrUpdateFundCategory(FundCategory f){
		sessionFactory.getCurrentSession().saveOrUpdate(f);
	}
	
	@Transactional
	public void deleteFundCategory(FundCategory fc){
		sessionFactory.getCurrentSession().delete(fc);
	}
}
