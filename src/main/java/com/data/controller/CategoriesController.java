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

@Controller
public class CategoriesController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String listCategoriesForm() {
        return "categories";
    }

    @PostMapping("/categories-save")
    public String saveCategory(@ModelAttribute("category_vi") Categories_vi categoryVi,
                               @ModelAttribute("category_en")Categories_en categoryEn,
                               Model model) {
        categoryService.addCategoryVI(categoryVi);
        categoryService.addCategoryEN(categoryEn);
        return "redirect:/categories";
    }
}
