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
        name = "CATEGORY_SEQ_GENERATOR",
        sequenceName = "CATEGORY_SEQ",
        initialValue = 1, allocationSize = 10)
public class Category extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQ_GENERATOR")
    @Column(name = "category_id")
    private long id;

    @Embedded
    private CategoryCom categoryCom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="detail_category_id")
    private DetailCategory detailCategory;





}
