package com.tsystems.logiweb2.Controllers;

import com.tsystems.logiweb2.Services.TruckService;
import com.tsystems.logiweb2.model.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by StarKiller on 15.11.2014.
 */
@Controller
public class TruckController {

    @Autowired
    private TruckService truckService;

    @RequestMapping("/trucks")
    public String listTrucks(ModelMap model) {
        model.addAttribute("trucks", truckService.getAll());
        return "trucks";
    }

    @ModelAttribute("truck")
    public Truck create() {
        return new Truck();
    }

    @RequestMapping("/newTruck")
    public String newDriver() {
        return "newDriver";
    }

    @RequestMapping(value = "/newTruck", method = RequestMethod.POST)
    public String addDriver(@ModelAttribute("truck") Truck truck) {
        truckService.save(truck);
        return "redirect:/newTruck.html?success=true";
    }
}
