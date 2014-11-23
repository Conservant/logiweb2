package com.tsystems.logiweb2.Controllers;

import com.tsystems.logiweb2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by StarKiller on 23.11.2014.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping("/register")


}
