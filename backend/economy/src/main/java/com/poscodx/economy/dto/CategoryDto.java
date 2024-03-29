package com.poscodx.economy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    private String categoryName;
    private String detailCategoryName;
    private String paymentData;
}
