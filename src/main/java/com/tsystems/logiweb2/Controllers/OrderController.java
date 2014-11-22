package com.tsystems.logiweb2.Controllers;

import com.tsystems.logiweb2.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by StarKiller on 20.11.2014.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/orders")
    public String listOrders(ModelMap model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }


    @RequestMapping("/orders/{id}")
    public String orderDetail(ModelMap model, @PathVariable Long id) {
        model.addAttribute("order", orderService.findById(id));
        return "orderDetail";
    }


    @RequestMapping(value = "/newOrder", method = RequestMethod.GET)
    public String newTruck() {
        orderService.createOrder();
        return "WEB-INF/jsp/Manager/newOrder.jsp";
    }
/*
    @RequestMapping(value = "/confirmOrder")
    public String createdOrders(ModelMap model) {
        model.addAttribute("createdOrders", orderService.getCreated());
        return "WEB-INF/jsp/Manager/createdOrders.jsp";
    }

    @RequestMapping(value = "/shipOrder")
    public String confirmedOrders(ModelMap model) {
        model.addAttribute("confirmedOrders", orderService.getConfirmed());
        return "WEB-INF/jsp/Manager/confirmedOrders.jsp";
    }

    @RequestMapping(value = "/closeOrder")
    public String performedOrders(ModelMap model) {
        model.addAttribute("performedOrders", orderService.getPerformed());
        return "WEB-INF/jsp/Manager/performedOrders.jsp";
    }

    @RequestMapping("/{id}/delete")
    public String closeOrder(@PathVariable Long id, ModelMap model) {
        orderService.closeOrder(id);
        return listOrders(model);
    }
*/
}
