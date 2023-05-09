package com.poscodx.economy.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@SequenceGenerator(
        name = "USER_BOARD_SEQ_GENERATOR",
        sequenceName = "USER_BOARD_SEQ",
        initialValue = 1, allocationSize = 10)
public class UserBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_BOARD_SEQ_GENERATOR")
    @Column(name = "user_board_id")
    private long id;

    @Embedded
    private BoardCom boardCom;

    private long goodCount;
    private long failCount;

    @NotNull
    private long groupNo;

    @NotNull
    private long groupSeq;

    @NotNull
    private long groupDepth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_pk")
    private User user;
}
