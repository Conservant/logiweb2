package com.tsystems.logiweb2.Controllers;

import com.tsystems.logiweb2.Services.TruckService;
import com.tsystems.logiweb2.model.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by StarKiller on 15.11.2014.
 */
@Controller
public class TruckController {

    @Autowired
    private TruckService truckService;

    @RequestMapping("/trucks.html")
    public ModelAndView listTrucks() {
        return new ModelAndView("WEB-INF/jsp/Manager/trucks.jsp", "trucks", truckService.allTrucks());
    }

    @RequestMapping(name = "/newTruck.html", method = RequestMethod.GET)
    public ModelAndView newTruck() {
        ModelAndView modelAndView = new ModelAndView("newTruck");
        modelAndView.addObject("truck", new Truck());//????
        return modelAndView;
    }

    @RequestMapping(name = "/newTruck", method = RequestMethod.POST)
    public ModelAndView newTruck(HttpServletRequest req, ModelAndView model) {
        Truck truck = new Truck(
            req.getParameter("regNumber"), Integer.parseInt(req.getParameter("reqDrivers")), Double.parseDouble(req.getParameter("capacity"))
        );

        truckService.newTruck(truck);
        return model;
    }


}
