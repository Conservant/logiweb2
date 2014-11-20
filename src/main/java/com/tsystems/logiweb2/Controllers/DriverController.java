package com.tsystems.logiweb2.Controllers;

import com.tsystems.logiweb2.Services.DriverService;
import com.tsystems.logiweb2.model.Driver;
import com.tsystems.logiweb2.model.enums.DriverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by StarKiller on 17.11.2014.
 */
@Controller
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping("/drivers")
    public String listDrivers(ModelMap model) {
        model.addAttribute("drivers", driverService.getAll());
        return "WEB-INF/jsp/Manager/drivers.jsp";
    }

    @RequestMapping(value = "/newDriver", method = RequestMethod.GET)
    public String newTruck() {
        return "WEB-INF/jsp/Manager/newDriver.jsp";
    }

    @RequestMapping(value = "/newDriver", method = RequestMethod.POST)
    public String newTruck(HttpServletRequest req, ModelMap model) {
        Driver dr = new Driver();
        dr.setName(req.getParameter("name"));
        dr.setLicNumber(req.getParameter("licNumber"));
        dr.setDriverStatus(DriverStatus.FREE);

        System.out.println(dr);

        driverService.save(dr);

        return listDrivers(model);
    }

}
