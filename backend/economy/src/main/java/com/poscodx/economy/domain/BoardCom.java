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
public class BoardCom {

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private LocalDateTime creationDate;

    @NotNull
    private LocalDateTime updateDate;

    @NotNull
    private long deleteCode;

}
