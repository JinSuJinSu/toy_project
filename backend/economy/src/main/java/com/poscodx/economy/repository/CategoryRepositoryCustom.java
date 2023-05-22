package com.poscodx.economy.repository;

import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.IncomeSpending;

import java.time.LocalDateTime;
import java.util.List;

public interface CategoryRepositoryCustom {

    Category findCategoryName(String categoryName);

}
