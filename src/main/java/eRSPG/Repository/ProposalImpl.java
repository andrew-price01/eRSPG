package eRSPG.Repository;

import eRSPG.model.Proposal;
import eRSPG.util.PersistProposal;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Proposal> findProposalByUserId(Integer userId) {
		return (List<Proposal>) sessionFactory.getCurrentSession()
				.createCriteria(Proposal.class)
				.add(Restrictions.eq("userId",userId))
				.list();
	}
	
	@Transactional
	public void addNewOrUpdateProposal(Proposal p){
		sessionFactory.getCurrentSession().saveOrUpdate(p);
	}
	
	@Transactional
	public void deleteProposal(Proposal p){
		sessionFactory.getCurrentSession().delete(p);
	}

	@Transactional
	public Proposal findIncompleteProposalByUserId(int userId){
		try {
			Proposal p = (Proposal) sessionFactory.getCurrentSession()
					.createCriteria(Proposal.class)
					.add(Restrictions.eq("userId", userId))
					.add(Restrictions.eq("proposalStatus", 1))
					.uniqueResult();
			return p;
		}
		catch(Exception e) //for testing
		{
			return PersistProposal.getDummyProposal(userId);

		}

	}
}
