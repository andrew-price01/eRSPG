package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public List<User> findAllUser(){
		@SuppressWarnings("unchecked")
		List<User> raList = (List<User>) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return raList;
	}
	
	@Transactional
	public User findUserById(int raid){
		User ra = sessionFactory.getCurrentSession().get(User.class, raid);
		return ra;
	}
	
	@Transactional
	public User findUserByEmail(String email){
		User ra = (User)sessionFactory.getCurrentSession().createQuery("from User u where u.email = :email").setParameter("email", email).uniqueResult();
		return ra;
	}
	
	@Transactional
	public List<User> findAllUserByFirstName(String fn){
		@SuppressWarnings("unchecked")
		List<User> ra = (List<User>)sessionFactory.getCurrentSession().createQuery("from User u where u.firstName = :firstName").setParameter("firstName", fn).list();
		return ra;
	}
	
	@Transactional
	public List<User> findAllUserByLastName(String ln){
		@SuppressWarnings("unchecked")
		List<User> ra = (List<User>)sessionFactory.getCurrentSession().createQuery("from User u where u.lastName = :lastName").setParameter("lastName", ln).list();
		
		return ra;
	}
	
	@Transactional
	public void addNewOrUpdateUser(User u){
		sessionFactory.getCurrentSession().saveOrUpdate(u);
	}
	
	@Transactional
	public void deleteUser(User ra){
		sessionFactory.getCurrentSession().delete(ra);
	}
}
