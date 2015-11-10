package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	public List<EssayAnswer> findAllEssayAnswer(){
		//TODO: query and return a list of Proposal
		List<EssayAnswer> eaList = new ArrayList();
		return eaList;
	}
	
	public EssayAnswer findEssayAnswer(int aid){
		EssayAnswer ea = new EssayAnswer();
		//TODO: query for a proposal using the pid
		return ea;
	}
	
	public EssayAnswer findEssayAnswerByQuestion(EssayQuestion eq){
		//TODO: quesry an essay answer matching essayQuestion
		EssayAnswer ea = new EssayAnswer();
		return ea;
	}
	
	public int addNewEssayAnswer(EssayAnswer a){
		//TODO: 
		return 0;
	}
	
	public boolean updateEssayAnswer(EssayAnswer a){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteEssayAnswer(EssayAnswer a){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
