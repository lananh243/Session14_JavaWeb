package com.data.controller;

import com.data.model.Order;
import com.data.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String showOrders(){
        return "order";
    }

    @GetMapping("/list-order")
    public String listOrder(HttpSession session, Model model){
        List<Order> orderList = orderService.getOrders(session);
        model.addAttribute("orderList",orderList);
        return "list_order";
    }

    @PostMapping("/add-order")
    public String addOrder(Order order, HttpSession session){
        orderService.createOrder(session, order);
        return "redirect:/list-order";
    }

    @GetMapping("/edit-order/{orderId}")
    public String editOrder(@PathVariable int orderId, HttpSession session, Model model){
        List<Order> orderList = orderService.getOrders(session);
        for (Order order : orderList) {
            if (order.getOrderId() == orderId) {
                model.addAttribute("order", order);
                break;
            }
        }
        return "order";
    }

    @PostMapping("/update-order")
    public String updateOrder(Order order, HttpSession session){
        orderService.updateOrder(session, order);
        return "redirect:/list-order";
    }

    @GetMapping("/delete-order/{orderId}")
    public String deleteOrder(@PathVariable int orderId, HttpSession session){
        orderService.deleteOrder(session, orderId);
        return "redirect:/list-order";
    }
}
