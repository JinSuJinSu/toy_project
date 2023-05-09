package com.poscodx.economy.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SequenceGenerator(
        name = "DETAIL_CATEGORY_SEQ_GENERATOR",
        sequenceName = "DETAIL_CATEGORY_SEQ",
        initialValue = 1, allocationSize = 30)
public class DetailCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DETAIL_CATEGORY_SEQ_GENERATOR")
    @Column(name = "detail_category_id")
    private long id;

    @Embedded
    private CategoryCom categoryCom;

}
