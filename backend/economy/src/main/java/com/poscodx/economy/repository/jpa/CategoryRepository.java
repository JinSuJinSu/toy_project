package com.poscodx.economy.repository.jpa;

import com.poscodx.economy.domain.Category;
import com.poscodx.economy.repository.CategoryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryCustom{
    Category findByCategoryCom_Name(String categoryName);

    List<Category> findAll();
}
