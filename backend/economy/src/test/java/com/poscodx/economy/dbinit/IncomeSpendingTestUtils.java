package com.poscodx.economy.dbinit;

import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.domain.User;
import com.poscodx.economy.enumration.DataCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Transactional
@RequiredArgsConstructor
@Slf4j
public class IncomeSpendingTestUtils {

    public static void addIncomeSpending(TestEntityManager em, DataCode dataCode,
                                         String content, Long amount, Optional<User> user, Category category) {
        IncomeSpending incomeSpending = createIncomeSpending(dataCode, content, amount, user, category);
        em.persist(incomeSpending);
    }

    private static IncomeSpending createIncomeSpending(DataCode dataCode, String content, Long amount,
                                                       Optional<User> user, Category category) {

        IncomeSpending incomeSpending =
                new IncomeSpending().builder()
                        .dataCode(dataCode)
                        .content(content)
                        .amount(amount)
                        .user(user)
                        .category(category)
                        .build();
        log.info("생성된 거래내역 데이터 : " + incomeSpending);
        return incomeSpending;
    }
}
