package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eRSPG.model.AwardType;
import eRSPG.model.EssayAnswer;
import eRSPG.model.EssayQuestion;

@Repository
public class EssayAnswerImpl implements EssayAnswerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public EssayAnswerImpl(){
		
	}
	
	public EssayAnswerImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional
	public List<EssayAnswer> findAllEssayAnswer(){
		@SuppressWarnings("unchecked")
		List<EssayAnswer> eaList = (List<EssayAnswer>) sessionFactory.getCurrentSession()
                .createCriteria(EssayAnswer.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return eaList;
	}
	
	@Transactional
	public EssayAnswer findEssayAnswer(int aid){
		EssayAnswer ea = sessionFactory.getCurrentSession().get(EssayAnswer.class, aid);
		return ea;
	}
	
	@Transactional
	public EssayAnswer findEssayAnswerByQuestion(EssayQuestion eq){
		//TODO: quesry an essay answer matching essayQuestion
		EssayAnswer ea = new EssayAnswer();
		return ea;
	}
	
	@Transactional
	public void addNewOrUpdateEssayAnswer(EssayAnswer a){
		sessionFactory.getCurrentSession().saveOrUpdate(a);
	}
	
	@Transactional
	public void deleteEssayAnswer(EssayAnswer a){
		sessionFactory.getCurrentSession().delete(a);
	}
}
