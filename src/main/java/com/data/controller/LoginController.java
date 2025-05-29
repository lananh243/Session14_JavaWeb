package com.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginForm(){
        return "login_form";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, Model model){
        if ("user".equals(username) && "12345678".equals(password)){
            session.setAttribute("username", username);
            return "redirect:/welcome";
        }

        model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác");
        return "login_form";
    }

    @GetMapping("/welcome")
    public String loginSuccess(HttpSession session, Model model){
        String username = (String) session.getAttribute("username");
        if (username == null){
            return "redirect:/login";
        }
        model.addAttribute("username", username);
        return "login_success";
    }
}
