package com.poscodx.economy.dto;

import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.User;
import com.poscodx.economy.enumration.DataCode;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class IncomeSpendingDto {

    private String id;
    private String createdDate;
    private String dataCode;
    private String content;
    private Long amount;
    private String categoryName;
}
