package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import eRSPG.model.Awarded;
import eRSPG.model.Proposal;
import eRSPG.model.User;

@Repository
public class AwardedImpl implements AwardedDAO {

	public List<Awarded> findAllAwardeds(){
		//TODO: query and return a list of Proposal
		List<Awarded> aList = new ArrayList();
		return aList;
	}
	
	public Awarded findAwarded(int aid){
		Awarded a = new Awarded();
		//TODO: query for a proposal using the pid
		return a;
	}
	
	public List<Awarded> findAwardedByUser(User user){
		//TODO: query for proposal that relates to the user
		List<Awarded> aList = new ArrayList();
		return aList;
	}
	
	public void createAwarded(Awarded a){
		//TODO: 
	}
	
	public boolean updateAwarded(Awarded a){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteAwarded(Awarded a){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
