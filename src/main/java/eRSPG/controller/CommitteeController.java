package eRSPG.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommitteeController {

    @RequestMapping("committee/home")
    public String committeeHome(){
        return "committeeHome";
    }
}
