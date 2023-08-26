package com.poscodx.economy.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
public class DetailCategory extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DETAIL_CATEGORY_SEQ_GENERATOR")
    @Column(name = "detail_category_id")
    private long id;

    @NotNull
    private String name;
    private String content;
    private String categoryData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

}
