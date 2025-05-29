package com.data.controller;

import com.data.model.ProductB4;
import com.data.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductB4Controller {
    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String cartForm() {
        return "cart";
    }

    @GetMapping("/list-cart")
    public String listCart(HttpServletRequest request, Model model) {
        List<ProductB4> cartList = cartService.getCart(request);
        model.addAttribute("cartList", cartList);
        return "list_cart";
    }

    @PostMapping("/add-product-cart")
    public String addProduct(HttpServletRequest request, ProductB4 product,
                             HttpServletResponse response) {
        cartService.addProduct(request, product);
        Cookie cookie = new Cookie(product.getName(), String.valueOf(product.getQuantity()));
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        return "redirect:/list-cart";
    }

    @GetMapping("/delete-cart/{productName}")
    public String deleteProduct(@PathVariable String productName, HttpServletRequest request) {
        cartService.removeCart(request, productName);
        return "redirect:/list-cart";
    }

}
