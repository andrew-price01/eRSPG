package eRSPG.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/eRSPG/admin/home")
    public String adminHome(){
        return "adminHome";
    }

    @RequestMapping("/eRSPG/admin/makeAnnouncement")
    public String makeAnnouncement()
    {
        return "makeAnnouncement";
    }

}