package com.tsystems.logiweb2.Controllers;

import com.tsystems.logiweb2.Services.DriverService;
import com.tsystems.logiweb2.model.Driver;
import com.tsystems.logiweb2.model.enums.DriverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

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
        return "drivers";
    }

    @ModelAttribute("driver")
    public Driver create() {
        return new Driver();
    }

    @RequestMapping("/newDriver")
    public String newDriver(ModelMap model) {
        return "newDriver";
    }

    @RequestMapping(value = "/newDriver", method = RequestMethod.POST)
    public String addDriver(ModelMap model, @Valid @ModelAttribute("driver") Driver driver, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return newDriver(model);
        }
        driverService.save(driver);
        return "redirect:/newDriver.html?success=true";
    }
}
