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
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("visitorCount", visitorCount++);
        return "index";
    }
}
