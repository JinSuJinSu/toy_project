package com.poscodx.economy.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@SequenceGenerator(
        name = "NOTICE_BOARD_SEQ_GENERATOR",
        sequenceName = "NOTICE_BOARD_SEQ",
        initialValue = 1, allocationSize = 10)
public class NoticeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTICE_BOARD_SEQ_GENERATOR")
    @Column(name = "notice_board_id")
    private long id;

    @Embedded
    private BoardCom boardCom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_pk")
    private User user;

}

