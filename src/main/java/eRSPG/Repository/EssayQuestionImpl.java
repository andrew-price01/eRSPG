package eRSPG.Repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import eRSPG.model.EssayQuestion;

public class EssayQuestionImpl implements EssayQuestionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public EssayQuestionImpl() {
	}
	
	public EssayQuestionImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional
	public List<EssayQuestion> findAllEssayQuestion(){
		@SuppressWarnings("unchecked")
		List<EssayQuestion> eqList = (List<EssayQuestion>) sessionFactory.getCurrentSession()
                .createCriteria(EssayQuestion.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return eqList;
	}
	
	@Transactional
	public EssayQuestion findEssayQuestion(int aid){
		EssayQuestion eq = sessionFactory.getCurrentSession().get(EssayQuestion.class, aid);
		return eq;
	}
	
	@Transactional
	public void addNewOrUpdateEssayQuestion(EssayQuestion q){
		sessionFactory.getCurrentSession().saveOrUpdate(q);
	}
	
	@Transactional
	public void deleteEssayQuestion(EssayQuestion a){
		sessionFactory.getCurrentSession().delete(a);
	}
}
