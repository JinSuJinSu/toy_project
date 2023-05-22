package com.poscodx.economy.repository.querydsl;

import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.domain.QIncomeSpending;
import com.poscodx.economy.repository.IncomeSpendingRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class IncomeSpendingRepositoryCustomImpl implements IncomeSpendingRepositoryCustom {

    private final JPAQueryFactory query;

    @Override
    public List<IncomeSpending> findDataByDateTime(String userId,
                                                     LocalDateTime startDateTime, LocalDateTime endDateTime) {
        QIncomeSpending incomeSpending = QIncomeSpending.incomeSpending;
        return query.selectFrom(incomeSpending)
                .where(incomeSpending.user.userId.eq(userId)
                        .and(incomeSpending.createdDate.between(startDateTime,endDateTime)))
                .fetch();
    }
}