package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import eRSPG.model.EssayQuestion;

public class EssayQuestionImpl implements EssayQuestionDAO {
	public List<EssayQuestion> findAllEssayQuestion(){
		//TODO: query and return a list of Proposal
		List<EssayQuestion> eqList = new ArrayList();
		return eqList;
	}
	
	public EssayQuestion findEssayQuestion(int aid){
		EssayQuestion eq = new EssayQuestion();
		//TODO: query for a proposal using the pid
		return eq;
	}
	
	public int addNewEssayQuestion(EssayQuestion q){
		//TODO: 
		return 0;
	}
	
	public boolean updateEssayQuestion(EssayQuestion a){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteEssayQuestion(EssayQuestion a){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
