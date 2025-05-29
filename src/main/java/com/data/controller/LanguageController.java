package com.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class LanguageController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/language")
    public String index(HttpServletRequest request, Model model) {
        String lang = getLanguageFromCookies(request);
        Locale locale = new Locale(lang);
        model.addAttribute("title", messageSource.getMessage("title", null, locale));
        model.addAttribute("message", messageSource.getMessage("message", null, locale));
        return "index";
    }

    @PostMapping("/set-language")
    public String setLanguage(@RequestParam("lang") String lang, HttpServletResponse response) {
        Cookie cookie = new Cookie("lang", lang);
        cookie.setMaxAge(60 * 60 * 24); // 1 day
        response.addCookie(cookie);
        return "redirect:/language";
    }

    private String getLanguageFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("lang".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return "en"; // Ngôn ngữ mặc định
    }
}
