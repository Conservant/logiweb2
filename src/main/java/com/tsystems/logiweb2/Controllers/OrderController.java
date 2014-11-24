package com.tsystems.logiweb2.Controllers;

import com.tsystems.logiweb2.Services.OrderItemService;
import com.tsystems.logiweb2.Services.OrderService;
import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.OrderItem;
import com.tsystems.logiweb2.model.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("/orders")
    public String listOrders(ModelMap model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }

    @RequestMapping("/orders/{id}")
    public String orderDetail(ModelMap model, @PathVariable Long id) {
        model.addAttribute("order", orderService.findOrderWithItems(id));
        return "orderDetail";
    }

    @ModelAttribute("item")
    public OrderItem createItem() {
        OrderItem item = new OrderItem();
        return item;
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.POST)
    public String addOrderItem(@ModelAttribute("item") OrderItem item, @PathVariable Long id) {
        orderItemService.save(item, id);
        return "redirect:/orders/"+id+".html";
    }

    @ModelAttribute("order")
    public Order create() {
        return new Order();
    }
//
//    @RequestMapping("/newOrder")
//    public String addDriver(ModelMap model, @ModelAttribute("order") Order order) {
//        orderService.save(order);
//        return "redirect:/orders";
//    }

    @RequestMapping("/order/confirm/{id}")
    public String confirmOrder(@PathVariable Long id) {
        orderService.changeStatus(id, OrderStatus.CONFIRMED);
        return "redirect:/orders.html";
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
