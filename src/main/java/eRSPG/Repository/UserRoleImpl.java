package eRSPG.Repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public List<UserRole> findAllUserRole(){
		@SuppressWarnings("unchecked")
		List<UserRole> raList = (List<UserRole>) sessionFactory.getCurrentSession()
                .createCriteria(UserRole.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();;
		return raList;
	}
	
	@Transactional
	public UserRole findUserRoleById(int raid){
		UserRole ra = sessionFactory.getCurrentSession().get(UserRole.class, raid);
		return ra;
	}

	@Transactional
	public UserRole findUserRoleByUserId(int userId){
		UserRole ur = (UserRole)sessionFactory.getCurrentSession().createQuery("from UserRole ur where ur.userId = :userId").setParameter("userId", userId).uniqueResult();
		return ur;
	}
	
	@Transactional
	public void addNewOrUpdateUserRole(UserRole ra){
		sessionFactory.getCurrentSession().saveOrUpdate(ra);
	}
	
	@Transactional
	public void deleteUserRole(UserRole ra){
		sessionFactory.getCurrentSession().delete(ra);
	}
}
