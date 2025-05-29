package com.data.service;

import com.data.model.Categories_en;
import com.data.model.Categories_vi;
import com.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private  CategoryRepository categoryRepo;

    @Override
    public boolean addCategoryVI(Categories_vi categoriesVi) {
        return categoryRepo.addCategoryVI(categoriesVi);
    }

    @Override
    public boolean addCategoryEN(Categories_en categoriesEn) {
        return categoryRepo.addCategoryEN(categoriesEn);
    }
}
