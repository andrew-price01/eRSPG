package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import eRSPG.model.RequestAward;

public class RequestAwardImpl implements RequestAwardDAO {
	public List<RequestAward> findAllRequestAward(){
		//TODO: query and return a list of Proposal
		List<RequestAward> raList = new ArrayList();
		return raList;
	}
	
	public RequestAward findRequestRewardById(int raid){
		RequestAward ra = new RequestAward();
		//TODO: query for a proposal using the pid
		return ra;
	}
	
	public RequestAward findRequestRewardByProposalId(int pid){
		RequestAward ra = new RequestAward();
		//TODO: find RequestAward by proposal id
		
		return ra;
	}
	
	public int addRequestAward(RequestAward ra){
		//TODO: 
		return 0;
	}
	
	public boolean updateRequestAward(RequestAward ra){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteRequestAward(RequestAward ra){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
