package eRSPG.model.form;

import org.hibernate.validator.constraints.NotEmpty;

public class AnnouncementForm {

    private String announcement;
    private String date;
    private String title;
    private String message;

    public String getAnnouncement()
    {
        return announcement;
    }

    public void setAnnouncement()
    {
        this.announcement = announcement;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
