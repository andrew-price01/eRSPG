package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eRSPG.model.Proposal;
import eRSPG.model.User;

@Repository
public class ProposalImpl implements ProposalDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProposalImpl(){
		
	}
	
	public ProposalImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Transactional
	public List<Proposal> findAllProposals(){
		@SuppressWarnings("unchecked")
		List<Proposal> pList = (List<Proposal>) sessionFactory.getCurrentSession()
                .createCriteria(Proposal.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return pList;
	}
	
	@Transactional
	public Proposal findProposal(int pid){
		Proposal p = sessionFactory.getCurrentSession().get(Proposal.class, pid);
		return p;
	}
	
	@Transactional
	public List<Proposal> findProposalsByUser(User user){
		//TODO: query for proposal that relates to the user
		List<Proposal> pList = new ArrayList();
		return pList;
	}
	
	@Transactional
	public void addNewOrUpdateProposal(Proposal p){
		sessionFactory.getCurrentSession().saveOrUpdate(p);
	}
	
	@Transactional
	public void deleteProposal(Proposal p){
		sessionFactory.getCurrentSession().delete(p);
	}
	
}
