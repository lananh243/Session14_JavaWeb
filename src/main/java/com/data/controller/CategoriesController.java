package com.data.controller;

import com.data.model.Categories_en;
import com.data.model.Categories_vi;
import com.data.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class CategoriesController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String listCategoriesForm() {
        return "categories";
    }

    @GetMapping("/list-category")
    public String listCategories(@RequestParam(defaultValue = "vi") String lang, Model model) {
        List<Map<String, Object>> categories = categoryService.getAllCategories(lang);
        model.addAttribute("categories", categories);
        model.addAttribute("lang", lang);
        return "list_category";
    }
    @PostMapping("/categories-save")
    public String saveCategory(@ModelAttribute("category_vi") Categories_vi categoryVi,
                               @ModelAttribute("category_en")Categories_en categoryEn) {
        categoryService.addCategoryVI(categoryVi);
        categoryService.addCategoryEN(categoryEn);
        return "redirect:/list-category";
    }
}
