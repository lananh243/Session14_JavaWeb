package com.data.service;

import com.data.model.Order;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {
    public void createOrder(HttpSession session, Order order) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
        session.setAttribute("orders", orders);
    }

    public List<Order> getOrders(HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        return orders;
    }

    public void deleteOrder(HttpSession session, int orderId) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders != null) {
            orders.remove(orderId);
            session.setAttribute("orders", orders);
        }
    }

    public void updateOrder(HttpSession session, Order order) {
        List<Order> orders = getOrders(session);
        if (orders != null) {
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getOrderId() == order.getOrderId()) {
                    orders.set(i, order);
                    break;
                }
            }
            session.setAttribute("orders", orders);
        }
    }
}
