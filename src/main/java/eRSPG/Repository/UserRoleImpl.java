package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eRSPG.model.UserRole;

@Repository
public class UserRoleImpl implements UserRoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserRoleImpl(){
		
	}
	
	public UserRoleImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public List<UserRole> findAllUserRole(){
		//TODO: query and return a list of Proposal
		List<UserRole> raList = new ArrayList();
		return raList;
	}
	
	public UserRole findUserRoleById(int raid){
		UserRole ra = new UserRole();
		//TODO: query for a proposal using the pid
		return ra;
	}
	
	public int addUserRole(UserRole ra){
		//TODO: 
		return 0;
	}
	
	public boolean updateUserRole(UserRole ra){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteUserRole(UserRole ra){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
