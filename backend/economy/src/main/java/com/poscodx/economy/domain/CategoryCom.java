package com.poscodx.economy.domain;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryCom {

    @NotNull
    private String name;

    @NotNull
    private LocalDateTime creationDate;

    @NotNull
    private LocalDateTime updateDate;

    private String content;
    private String categoryData;
}
