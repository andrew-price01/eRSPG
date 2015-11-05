package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import eRSPG.model.EssayAnswer;

public class EssayAnswerImpl implements EssayAnswerDAO {
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
	
	public int addEssayAnswer(EssayAnswer a){
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
