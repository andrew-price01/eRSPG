package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eRSPG.model.AwardType;

@Repository
public class AwardTypeImpl implements AwardTypeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public AwardTypeImpl(){
		
	}

	public AwardTypeImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
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
	
	@Transactional
	public int addNewAwardType(AwardType a){
		//TODO: query insert new AwardType and return new awardTypeID
		sessionFactory.getCurrentSession().saveOrUpdate(a);
		return 0;
	}
	
	public boolean deleteAwardType(AwardType a){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
