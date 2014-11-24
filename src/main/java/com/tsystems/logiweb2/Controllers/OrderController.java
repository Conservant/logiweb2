package com.tsystems.logiweb2.Controllers;

import com.tsystems.logiweb2.Services.OrderItemService;
import com.tsystems.logiweb2.Services.OrderService;
import com.tsystems.logiweb2.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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

    @RequestMapping("/newOrder")
    public String addDriver() {
        orderService.save();
        return "redirect:/orders.html";
    }

    @RequestMapping("/order/confirm/{id}")
    public String confirmOrder(@PathVariable Long id) {
        orderService.confirmOrder(id);
        return "redirect:/orders.html";
    }

    @RequestMapping("order/close/{id}")
    public String close(@PathVariable Long id) {
        orderService.closeOrder(id);
        return "redirect:/orders.html";
    }
}
