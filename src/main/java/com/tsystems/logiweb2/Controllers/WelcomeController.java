package com.tsystems.logiweb2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by StarKiller on 14.11.2014.
 */
@Controller
public class WelcomeController {
    private int visitorCount = 0;
    @RequestMapping("/index.html")
    public String index(Model model) {
        model.addAttribute("visitorCount", visitorCount++);
        return "WEB-INF/jsp/index.jsp";
    }

    @RequestMapping("/addDriver")
    public String addDriver(Model model) {
        return "WEB-INF/jsp/addDriver.jsp";
    }
}
