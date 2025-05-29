package com.data.repository;

import com.data.model.Categories_en;
import com.data.model.Categories_vi;

import java.util.List;
import java.util.Map;

public interface CategoryRepository {
    boolean addCategoryVI(Categories_vi categoriesVi);
    boolean addCategoryEN(Categories_en categoriesEn);
    List<Map<String, Object>> getAllCategories();

}
