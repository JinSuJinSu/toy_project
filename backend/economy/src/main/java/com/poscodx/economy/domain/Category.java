package com.poscodx.economy.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(of = {"id", "name","content","categoryData"})
@SequenceGenerator(
        name = "CATEGORY_SEQ_GENERATOR",
        sequenceName = "CATEGORY_SEQ",
        initialValue = 1, allocationSize = 10)
public class Category extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQ_GENERATOR")
    @Column(name = "category_id")
    private long id;

    @NotNull
    private String name;
    private String content;
    private String categoryData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_pk")
    private User user;

}
