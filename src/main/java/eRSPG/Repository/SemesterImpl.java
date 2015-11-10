package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eRSPG.model.Semester;

@Repository	
public class SemesterImpl implements SemesterDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SemesterImpl(){
		
	}
	
	public SemesterImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public List<Semester> findAllSemester(){
		//TODO: query and return a list of Proposal
		List<Semester> raList = new ArrayList();
		return raList;
	}
	
	public Semester findSemesterById(int raid){
		Semester ra = new Semester();
		//TODO: query for a proposal using the pid
		return ra;
	}
	
	public int addSemester(Semester ra){
		//TODO: 
		return 0;
	}
	
	public boolean updateSemester(Semester ra){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteSemester(Semester ra){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
