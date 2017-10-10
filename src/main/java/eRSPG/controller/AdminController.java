package eRSPG.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("admin/home")
    public String adminHome(){
        return "adminHome";
    }

    @RequestMapping("admin/manage")
    public String manageCommittee()
    {
        return "managementDashboard";
    }

}
