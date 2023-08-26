package com.poscodx.economy.serviceImpl;

import com.poscodx.economy.dto.CategoryDto;
import com.poscodx.economy.dto.IncomeSpendingDto;
import com.poscodx.economy.mapper.CategoryMapper;
import com.poscodx.economy.mapper.IncomeSpendingMapper;
import com.poscodx.economy.repository.jpa.CategoryRepository;
import com.poscodx.economy.repository.jpa.IncomeSpendingRepository;
import com.poscodx.economy.repository.jpa.UserRepository;
import com.poscodx.economy.service.CategoryService;
import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getCategoryList(String userId) {
        List<Tuple> categoryList = categoryRepository.findAllCategory(userId);
        List<CategoryDto> categoryDtoList = categoryList.stream()
                .map(m -> CategoryMapper.toDto(m))
                .collect(Collectors.toList());
        return categoryDtoList;
    }
}
