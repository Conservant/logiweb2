package com.tsystems.logiweb2.Controllers;

import com.tsystems.logiweb2.Services.DriverService;
import com.tsystems.logiweb2.model.Driver;
import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.enums.DriverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by StarKiller on 17.11.2014.
 */
@Controller
@RequestMapping
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping("/Manager/drivers")
    public String listDrivers(ModelMap model) {
        model.addAttribute("drivers", driverService.getAll());
        return "drivers";
    }

    @ModelAttribute("driver")
    public Driver create() {
        return new Driver();
    }

    @RequestMapping("/Manager/newDriver")
    public String newDriver(ModelMap model) {
        return "newDriver";
    }

    @RequestMapping(value = "/Manager/newDriver", method = RequestMethod.POST)
    public String addDriver(ModelMap model, @Valid @ModelAttribute("driver") Driver driver, BindingResult result) {
        if (result.hasErrors()) {
            return newDriver(model);
        }
        driverService.save(driver);
        return "redirect:/Manager/newDriver.html?success=true";
    }

    @RequestMapping("/Driver/myOrder")
    public String orderDetail(ModelMap model, Principal principal) {
        String licenseNumber = principal.getName();
        Order order = driverService.findOrder(licenseNumber);
        model.addAttribute("myOrder", order);
        return "myOrder";
    }

    @RequestMapping("/Driver/myTruck")
    public String truckDetail(ModelMap model, Principal principal) {
        String licenseNumber = principal.getName();
        model.addAttribute("myTruck", driverService.findTruck(licenseNumber));
        return "myTruck";
    }

    @RequestMapping("/Driver/myDrivers")
    public String driverDetail(ModelMap model, Principal principal) {
        String licenseNumber = principal.getName();
        model.addAttribute("myDrivers", driverService.getDriversFromOrder(licenseNumber));
        return "myDrivers";
    }

    @RequestMapping("/Driver/drive")
    public String drive(ModelMap model, Principal principal) {
        String licenseNumber = principal.getName();
        return "redirect:/Driver/myDrivers.html"+driverService.changeStatus(licenseNumber, DriverStatus.DRIVING);
    }

    @RequestMapping("/Driver/route")
    public String route(ModelMap model, Principal principal) {
        String licenseNumber = principal.getName();
        return "redirect:/Driver/myDrivers.html"+driverService.changeStatus(licenseNumber, DriverStatus.ON_ROUTE);
    }
}
