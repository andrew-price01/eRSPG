package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eRSPG.model.RoleType;

@Repository
public class RoleTypeImpl implements RoleTypeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public RoleTypeImpl(){
		
	}
	
	public RoleTypeImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public List<RoleType> findAllRoleType(){
		//TODO: query and return a list of Proposal
		List<RoleType> raList = new ArrayList();
		return raList;
	}
	
	public RoleType findRoleTypeById(int raid){
		RoleType ra = new RoleType();
		//TODO: query for a proposal using the pid
		return ra;
	}
	
	public RoleType findRoleTypeByUserId(int pid){
		RoleType ra = new RoleType();
		//TODO: find RoleType by proposal id
		
		return ra;
	}
	
	public int addRoleType(RoleType ra){
		//TODO: 
		return 0;
	}
	
	public boolean updateRoleType(RoleType ra){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteRoleType(RoleType ra){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
