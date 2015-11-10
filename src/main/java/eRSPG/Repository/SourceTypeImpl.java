package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eRSPG.model.SourceType;

@Repository
public class SourceTypeImpl implements SourceTypeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SourceTypeImpl(){
		
	}
	
	public SourceTypeImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public List<SourceType> findAllSourceType(){
		//TODO: query and return a list of Proposal
		List<SourceType> raList = new ArrayList();
		return raList;
	}
	
	public SourceType findSourceTypeById(int raid){
		SourceType ra = new SourceType();
		//TODO: query for a proposal using the pid
		return ra;
	}
	
	public SourceType findSourceTypeByDesc(String desc){
		SourceType ra = new SourceType();
		//TODO: query for a proposal using the desc
		return ra;
	}
	
	public int addSourceType(SourceType ra){
		//TODO: 
		return 0;
	}
	
	public boolean updateSourceType(SourceType ra){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteSourceType(SourceType ra){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
