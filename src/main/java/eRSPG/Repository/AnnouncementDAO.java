package eRSPG.Repository;

import eRSPG.model.Announcement;
import org.springframework.stereotype.Repository;

public interface AnnouncementDAO {

    void addNewOrUpdateAnnouncement(Announcement a);

    Announcement findAnnouncement(int announcementID);

}
