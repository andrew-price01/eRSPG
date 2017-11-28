package eRSPG.Repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public List<RoleType> findAllRoleType(){
		@SuppressWarnings("unchecked")
		List<RoleType> raList = (List<RoleType>) sessionFactory.getCurrentSession()
                .createCriteria(RoleType.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return raList;
	}
	
	@Transactional
	public RoleType findRoleTypeById(int raid){
		RoleType ra = sessionFactory.getCurrentSession().get(RoleType.class, raid);
		return ra;
	}
	
	@Transactional
	public RoleType findRoleTypeByUserId(int pid){
		RoleType ra = new RoleType();
		//TODO: find RoleType by proposal id
		
		return ra;
	}

	@Transactional
	public RoleType findRoleTypeByRoleTypeId(int roleTypeId){
        RoleType rt = (RoleType)sessionFactory.getCurrentSession().createQuery("from RoleType rt where rt.roleTypeId = :roleTypeId").setParameter("roleTypeId", roleTypeId).uniqueResult();
        return rt;
	}
	
	@Transactional
	public void addNewOrUpdateRoleType(RoleType ra){
		sessionFactory.getCurrentSession().saveOrUpdate(ra);
	}
	
	@Transactional
	public void deleteRoleType(RoleType ra){
		sessionFactory.getCurrentSession().delete(ra);
	}
}
