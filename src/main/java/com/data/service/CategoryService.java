package com.data.service;

import com.data.model.Categories_en;
import com.data.model.Categories_vi;

public interface CategoryService {
    boolean addCategoryVI(Categories_vi categoriesVi);
    boolean addCategoryEN(Categories_en categoriesEn);
}
