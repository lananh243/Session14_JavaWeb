package com.data.service;

import com.data.model.ProductB4;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    public void addProduct(HttpServletRequest request, ProductB4 product) {
        HttpSession session = request.getSession();
        List<ProductB4> cart =  (List<ProductB4>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.add(product);
        session.setAttribute("cart", cart);
    }

    public List<ProductB4> getCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<ProductB4> cart =  (List<ProductB4>) session.getAttribute("cart");
        return (cart != null) ? cart : new ArrayList<>();
    }

    public void removeCart(HttpServletRequest request, String productName) {
        HttpSession session = request.getSession();
        List<ProductB4> cart =  (List<ProductB4>) session.getAttribute("cart");
        if (cart != null) {
            cart.removeIf(product -> product.getName().equals(productName));
            session.setAttribute("cart", cart);
        }
    }
}
