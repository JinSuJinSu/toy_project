package com.poscodx.economy.service;

import com.poscodx.economy.dto.CategoryDto;
import com.poscodx.economy.dto.IncomeSpendingDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getCategoryList(String userId);
}
