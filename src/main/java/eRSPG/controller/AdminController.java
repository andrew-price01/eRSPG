package eRSPG.controller;

import eRSPG.model.Announcement;
import eRSPG.model.form.AnnouncementForm;
import eRSPG.model.form.AwardTypeForm;
import eRSPG.model.form.BodyDetailsForm;
import eRSPG.model.form.BodyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import eRSPG.Repository.AnnouncementDAO;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
    @SessionAttributes("AnnouncementForm")
    public class AdminController {

        @Autowired
        private AnnouncementDAO announcementDao;

        @RequestMapping("/eRSPG/admin/home")
        public String adminHome(){
        return "adminHome";
    }

        @RequestMapping("/eRSPG/admin/makeAnnouncement")
        public String makeAnnouncement()
        {
            return "makeAnnouncement";
        }

    @RequestMapping(value = "/eRSPG/admin/makeAnnouncement", method = RequestMethod.GET)
    public ModelAndView announcementForm() {
        return new ModelAndView("makeAnnouncement", "announcement", new AnnouncementForm());
    }

    @RequestMapping(value = "/eRSPG/admin/makeAnnouncement", method = RequestMethod.POST)
    public String saveAnnouncement(@Valid @ModelAttribute Announcement announcement,
                         BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "error";
        }

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        announcement.setDate(df.format(date));

        model.addAttribute("title", announcement.getTitle());
        model.addAttribute("message", announcement.getMessage());
        model.addAttribute("date", announcement.getDate());
        announcementDao.addNewOrUpdateAnnouncement(announcement);
        return "announcementSuccess";
    }
}