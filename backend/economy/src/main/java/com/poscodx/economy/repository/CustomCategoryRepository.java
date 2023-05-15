package com.poscodx.economy.repository;

import com.poscodx.economy.domain.Category;

public interface CustomCategoryRepository {

    Category findByCategoryName(String categoryName);

}
