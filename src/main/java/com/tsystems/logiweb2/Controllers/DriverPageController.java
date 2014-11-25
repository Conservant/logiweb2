package com.tsystems.logiweb2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Aleksei on 25.11.2014.
 */
@Controller("/Driver")
public class DriverPageController {
    //order, truck drivers
    @RequestMapping("/order")
    public String getOrder(ModelMap model) {
        
        return "myOrder";
    }

    @RequestMapping("/truck")
    public String getTruck(ModelMap model) {
        return "myTruck";
    }

    @RequestMapping("/drivers")
    public String getDrivers(ModelMap model) {
        return "myDrivers";
    }

}
