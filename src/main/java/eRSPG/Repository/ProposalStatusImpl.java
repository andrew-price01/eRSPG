package eRSPG.Repository;

import eRSPG.model.ProposalStatus;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProposalStatusImpl implements ProposalStatusDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ProposalStatusImpl(){

	}

	public ProposalStatusImpl(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<ProposalStatus> findAllProposalStatuses(){
		return (List<ProposalStatus>) sessionFactory.getCurrentSession()
                .createCriteria(ProposalStatus.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}
	
	@Transactional
	public ProposalStatus findProposalStatus(Integer id){
		ProposalStatus ps = sessionFactory.getCurrentSession().get(ProposalStatus.class, id);
		return ps;
	}
	
	@Transactional
	public void addNewOrUpdateProposalStatus(ProposalStatus ps){
		sessionFactory.getCurrentSession().saveOrUpdate(ps);
	}

	@Transactional
	public void deleteProposalStatus(ProposalStatus ps){
		sessionFactory.getCurrentSession().delete(ps);
	}

    @Transactional
    public ProposalStatus findProposalStatusByName(String name) {
        return (ProposalStatus) sessionFactory.getCurrentSession()
                    .createCriteria(ProposalStatus.class)
                    .add(Restrictions.eq("proposalStatusDescription",name))
                    .uniqueResult();
    }
}
