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
        name = "STAR_REVIEW_SEQ_GENERATOR",
        sequenceName = "STAR_REVIEW_SEQ",
        initialValue = 1, allocationSize = 10)
public class StarReview {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_BOARD_SEQ_GENERATOR")
    @Column(name = "star_review_id")
    private long id;

    @Embedded
    private BoardCom boardCom;

    @NotNull
    private double StarGrade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_pk")
    private User user;
}
