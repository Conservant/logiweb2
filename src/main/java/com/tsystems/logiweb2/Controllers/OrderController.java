package com.tsystems.logiweb2.Controllers;

import com.tsystems.logiweb2.DAO.OrderDAO;
import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by StarKiller on 20.11.2014.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping("/orders")
    public String listTrucks(ModelMap model) {
        model.addAttribute("trucks", orderDAO.findAll());
        return "WEB-INF/jsp/Manager/orders.jsp";
    }

    @RequestMapping(value = "/newOrder", method = RequestMethod.GET)
    public String newTruck() {
        return "WEB-INF/jsp/Manager/newOrder.jsp";
    }

    @RequestMapping(value = "/newOrder", method = RequestMethod.POST)
    public String newTruck(HttpServletRequest req, ModelMap model) {
        Order order = new Order();
        orderDAO.save(order);
        return listTrucks(model);
    }

}
