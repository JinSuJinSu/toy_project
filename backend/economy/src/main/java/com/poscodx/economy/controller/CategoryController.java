package com.poscodx.economy.controller;

import com.poscodx.economy.dto.CategoryDto;
import com.poscodx.economy.dto.IncomeSpendingDto;
import com.poscodx.economy.serviceImpl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @GetMapping("/{userId}")
    public List<CategoryDto> getCategoryList(@PathVariable("userId") String userId) {
        List<CategoryDto> resultList = categoryService.getCategoryList(userId);
        return resultList;
    }
}
