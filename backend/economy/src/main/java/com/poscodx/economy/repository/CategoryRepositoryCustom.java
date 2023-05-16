package com.poscodx.economy.repository;

import com.poscodx.economy.domain.Category;

public interface CategoryRepositoryCustom {

    Category findCategoryName(String categoryName);

}
