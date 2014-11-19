package com.tsystems.logiweb2.Controllers;

import com.tsystems.logiweb2.Services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by StarKiller on 17.11.2014.
 */
@Controller
public class DriverController {

    @Autowired
    private DriverService serviceDriver;

    @RequestMapping("/drivers.html")
    public ModelAndView listTrucks() {

        return new ModelAndView("WEB-INF/jsp/Manager/drivers.jsp", "drivers", serviceDriver.getAll());
    }

}
