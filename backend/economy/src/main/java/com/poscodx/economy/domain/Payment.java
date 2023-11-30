package com.poscodx.economy.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "data"})
@SequenceGenerator(
        name = "PAYMENT_SEQ_GENERATOR",
        sequenceName = "PAYMENT_SEQ",
        initialValue = 1, allocationSize = 30)
public class Payment{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYMENT_SEQ_GENERATOR")
    @Column(name = "payment_id")
    private long id;

    private String data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="detail_category_id")
    private DetailCategory detailCategory;
}
