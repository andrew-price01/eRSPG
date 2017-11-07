package eRSPG.model;

import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="announcement")
public class Announcement {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="announcementID")
    private int announcementID;

    @Column(name="title")
    private String title;

    @Column(name="message")
    private String message;

    @Column(name="date")
    private String date;

    public Announcement(){ }

    public int getAnnouncementID() {
        return announcementID;
    }

    public void setAnnouncementID(int announcementID) {
        this.announcementID = announcementID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
