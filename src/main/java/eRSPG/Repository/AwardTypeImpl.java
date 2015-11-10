package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AwardTypeImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public AwardTypeImpl(){
		
	}
	
	public List<AwardTypeImpl> findAllAwardTyps(){
		//TODO: query and return a list of Proposal
		List<AwardTypeImpl> aList = new ArrayList();
		return aList;
	}
	
	public AwardTypeImpl findAwardType(int aid){
		AwardTypeImpl a = new AwardTypeImpl();
		//TODO: query for a proposal using the pid
		return a;
	}
	
	public int addNewAwardType(AwardTypeImpl a){
		//TODO: query insert new AwardType and return new awardTypeID
		return 0;
	}
	
	public boolean updateAwardType(AwardTypeImpl a){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteAwardType(AwardTypeImpl a){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
