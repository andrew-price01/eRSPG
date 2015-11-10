package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import eRSPG.model.EssayQuestion;
import eRSPG.model.Fund;

public class FundImpl implements FundDAO {
	public List<Fund> findAllFund(){
		//TODO: query and return a list of Proposal
		List<Fund> fList = new ArrayList();
		return fList;
	}
	
	public Fund findFund(int fid){
		Fund f = new Fund();
		//TODO: query for a proposal using the pid
		return f;
	}
	
	public int addNewFund(Fund f){
		//TODO: 
		return 0;
	}
	
	public boolean updateFund(Fund f){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteFund(Fund f){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
