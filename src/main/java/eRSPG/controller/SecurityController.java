package eRSPG.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    @RequestMapping(value="/security/test")
    public String showConditionalRendering()
    {
        return "securityTest";
    }
}
