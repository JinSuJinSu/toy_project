package com.poscodx.economy.domain;

import com.poscodx.economy.enumration.DataCode;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(of = {"id", "dataCode","content","amount","transactionDate"})
@Table(name = "income_spending_info")
@SequenceGenerator(
        name = "INCOME_SPENDING_SEQ_GENERATOR",
        sequenceName = "INCOME_SPENDING_SEQ",
        initialValue = 1, allocationSize = 20)
public class IncomeSpending extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INCOME_SPENDING_SEQ_GENERATOR")
    @Column(name = "income_spending_id")
    private long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DataCode dataCode;

    @NotNull
    private String content;

    @NotNull
    private Long amount;

    @NotNull
    private LocalDateTime transactionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_pk")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    public void setUserAndCategory(User user, Category category){
        this.user = user;
        this.category = category;
    }


}