package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eRSPG.model.Proposal;
import eRSPG.model.User;

@Repository
public class ProposalImpl implements ProposalDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProposalImpl(){
		
	}
	public List<Proposal> findAllProposals(){
		//TODO: query and return a list of Proposal
		List<Proposal> pList = new ArrayList();
		return pList;
	}
	
	public Proposal findProposal(int pid){
		Proposal p = new Proposal();
		//TODO: query for a proposal using the pid
		return p;
	}
	
	public List<Proposal> findProposalsByUser(User user){
		//TODO: query for proposal that relates to the user
		List<Proposal> pList = new ArrayList();
		return pList;
	}
	
	public int addNewProposal(Proposal p){
		//TODO: 
		return 0;
	}
	
	public boolean updateProposal(Proposal p){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteProposal(Proposal p){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
	
}
