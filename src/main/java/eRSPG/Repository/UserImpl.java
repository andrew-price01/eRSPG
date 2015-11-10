package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eRSPG.model.User;

@Repository
public class UserImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserImpl(){
		
	}
	
	public UserImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public List<User> findAllUser(){
		//TODO: query and return a list of Proposal
		List<User> raList = new ArrayList();
		return raList;
	}
	
	public User findUserById(int raid){
		User ra = new User();
		//TODO: query for a proposal using the pid
		return ra;
	}
	
	public User findUserByEmail(String email){
		User ra = new User();
		//TODO: query for a proposal using the pid
		return ra;
	}
	
	public List<User> findAllUserByFirstName(String fn){
		List<User> ra = new ArrayList();
		//TODO: query for a proposal using the firstName
		return ra;
	}
	
	public List<User> findAllUserByLastName(String ln){
		List<User> ra = new ArrayList();
		//TODO: query for a proposal using the lastName
		return ra;
	}
	
	public List<User> findAllUserByFullName(String fullName){
		List<User> ra = new ArrayList();
		//TODO: query for a proposal using the fullName
		return ra;
	}
	
	public int addUser(User ra){
		//TODO: 
		return 0;
	}
	
	public boolean updateUser(User ra){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteUser(User ra){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
