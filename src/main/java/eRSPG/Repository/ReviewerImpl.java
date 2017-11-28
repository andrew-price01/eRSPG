package eRSPG.Repository;

import eRSPG.model.Reviewer;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ReviewerImpl implements ReviewerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public ReviewerImpl() {
    }

    public ReviewerImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void addReviewer(Reviewer reviewer) {
        sessionFactory.getCurrentSession().saveOrUpdate(reviewer);
    }

    @Transactional
    public List<Reviewer> findAllReviewers() {
        List<Reviewer> reviewerList = sessionFactory.getCurrentSession()
                .createCriteria(Reviewer.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        return reviewerList;
    }

    @Transactional
    public Reviewer findReviewerById(int id) {
        Reviewer reviewer = sessionFactory.getCurrentSession()
                .get(Reviewer.class, id);

        return reviewer;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Reviewer> findAllReviewByUserId(int userId) {
        List<Reviewer> userReviewList = sessionFactory.getCurrentSession()
                .createCriteria(Reviewer.class)
                .add(Restrictions.eq("userId", userId))
                .list();

        return userReviewList;
    }

    @Transactional
    public void deleteReviewer(Reviewer reviewer) {
        sessionFactory.getCurrentSession().delete(reviewer);
    }
}
