package com.poscodx.economy.dto;

import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.User;
import com.poscodx.economy.enumration.DataCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncomeSpendingDto {

    private String createdDate;
    private String dataCode;
    private String content;
    private Long amount;
    private String categoryName;
}
