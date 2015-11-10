package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import eRSPG.model.Participant;

public class ParticipantImpl implements ParticipantDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ParticipantImpl(){
		
	}
	
	public ParticipantImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public List<Participant> findAllParicipant(){
		//TODO: query and return a list of Proposal
		List<Participant> pList = new ArrayList();
		return pList;
	}

	public List<Participant> findAllPariticipantByProposalId(int pid){
		//TODO: find all participants relate to the proposal
		List<Participant> pList = new ArrayList();
		return pList;
	}
	
	public Participant findParticipant(int pid){
		Participant p = new Participant();
		//TODO: query for a proposal using the pid
		return p;
	}
	
	
	public int addNewParticipant(Participant p){
		//TODO: 
		return 0;
	}
	
	public boolean updateParticipant(Participant p){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteParticipant(Participant p){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteAllParticipantByProposalId(int pid){
		//TODO: delete all participant related to the proposal
		boolean success = false;
		return success;
	}
}
