package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

public class AwardType {
	public List<AwardType> findAllAwardTyps(){
		//TODO: query and return a list of Proposal
		List<AwardType> aList = new ArrayList();
		return aList;
	}
	
	public AwardType findAwardType(int aid){
		AwardType a = new AwardType();
		//TODO: query for a proposal using the pid
		return a;
	}
	
	public int createAwardType(AwardType a){
		//TODO: query insert new AwardType and return new awardTypeID
		return 0;
	}
	
	public boolean updateAwardType(AwardType a){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteAwardType(AwardType a){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
