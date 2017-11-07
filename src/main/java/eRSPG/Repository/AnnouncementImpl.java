package eRSPG.Repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import eRSPG.model.Announcement;

@Repository
public class AnnouncementImpl implements AnnouncementDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public AnnouncementImpl() {
    }

    public AnnouncementImpl(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Transactional
    public void addNewOrUpdateAnnouncement(Announcement a) {
        sessionFactory.getCurrentSession().saveOrUpdate(a);
    }

    @Transactional
    public Announcement findAnnouncement(int announcementID) {
        Announcement a = sessionFactory.getCurrentSession().get(Announcement.class, announcementID);
        return a;
    }
}
