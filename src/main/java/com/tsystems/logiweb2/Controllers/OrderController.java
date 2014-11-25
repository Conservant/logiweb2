package com.tsystems.logiweb2.Controllers;

import com.tsystems.logiweb2.Services.OrderItemService;
import com.tsystems.logiweb2.Services.OrderService;
import com.tsystems.logiweb2.model.Driver;
import com.tsystems.logiweb2.model.OrderItem;
import com.tsystems.logiweb2.model.Truck;
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
@RequestMapping("/Manager")
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
        model.addAttribute("driversFromOrder", orderService.findDriversByOrder(id));
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

    @RequestMapping("/orders/{id}/confirm")
    public String confirmOrder(@PathVariable Long id) {
        String status = "?isConfirmed=false";
        if (orderService.confirmOrder(id)) {
            status = "?isConfirmed=true";
        }
        return "redirect:/orders/"+id+".html"+status;
    }

    @ModelAttribute("attachedTruck")
    public Truck attachedTruck() {
        Truck truck = new Truck();
        return truck;
    }

    @RequestMapping("/orders/{id}/attachTruck")
    public String attachTruck(@PathVariable Long id) {
        return "attachTruck";
    }

    @RequestMapping(value = "/orders/{id}/attachTruck", method = RequestMethod.POST)
    public String attachTruck(@ModelAttribute Truck attachedTruck, @PathVariable Long id) {
        String status = orderService.attachTruck(id, attachedTruck.getRegNumber());
        return "redirect:/orders/" + status;
    }

    @ModelAttribute("attachedDriver")
    public Driver attachedDriver() {
        return new Driver();
    }

    @RequestMapping("/orders/{id}/attachDriver")
    public String attachDriver(@PathVariable Long id) {
        return "attachDriver";
    }

    @RequestMapping(value = "/orders/{id}/attachDriver", method = RequestMethod.POST)
    public String attachDriver(@ModelAttribute Driver attachedDriver, @PathVariable Long id) {
        String status = orderService.attachDriver(id, attachedDriver.getLicenseNumber());
        return "redirect:/orders/" + status;
    }


    @RequestMapping("orders/{id}/close")
    public String close(@PathVariable Long id) {
        orderService.closeOrder(id);
        return "redirect:/orders.html";
    }
}
