package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import eRSPG.model.Participant;
import eRSPG.model.Proposal;

public class ParticipantImpl implements ParticipantDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ParticipantImpl(){
		
	}
	
	public ParticipantImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional
	public List<Participant> findAllParicipant(){
		@SuppressWarnings("unchecked")
		List<Participant> pList = (List<Participant>) sessionFactory.getCurrentSession()
                .createCriteria(Participant.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return pList;
	}

	@Transactional
	public List<Participant> findAllPariticipantByProposalId(int pid){
		//TODO: find all participants relate to the proposal
		@SuppressWarnings("unchecked")
		List<Participant> pList = new ArrayList();
		return pList;
	}
	
	@Transactional
	public Participant findParticipant(int pid){
		Participant p = sessionFactory.getCurrentSession().get(Participant.class, pid);
		return p;
	}
	
	@Transactional
	public void addNewOrUpdateParticipant(Participant p){
		sessionFactory.getCurrentSession().saveOrUpdate(p);
	}
	
	@Transactional
	public void deleteParticipant(Participant p){
		sessionFactory.getCurrentSession().delete(p);
	}
	
	@Transactional
	public void deleteAllParticipantByProposalId(int pid){
		// TODO: 
		//sessionFactory.getCurrentSession().createQuery(queryString)
	}

}
