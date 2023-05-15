package com.poscodx.economy.repository.jpa;

import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.User;
import com.poscodx.economy.repository.CustomCategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>, CustomCategoryRepository {
    Category findByCategoryCom_Name(String categoryName);
}
