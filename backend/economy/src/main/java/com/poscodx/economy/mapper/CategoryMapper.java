package com.poscodx.economy.mapper;

import com.poscodx.economy.dto.CategoryDto;
import com.querydsl.core.Tuple;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    public static CategoryDto toDto(Tuple element) {
        CategoryDto categoryDto =
                new CategoryDto().builder()
                        .categoryName(element.get(0, String.class))
                        .detailCategoryName(element.get(1, String.class))
                        .paymentData(element.get(2, String.class))
                        .build();
        return categoryDto;
    }
}
