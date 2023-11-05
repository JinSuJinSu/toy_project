package com.poscodx.economy.dbinit;

import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.domain.User;
import com.poscodx.economy.dto.IncomeSpendingDto;
import com.poscodx.economy.enumration.DataCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@Transactional
@RequiredArgsConstructor
@Slf4j
public class IncomeSpendingTestUtils {

    public static void addIncomeSpending(TestEntityManager em, DataCode dataCode,
                                         String content, Long amount,  LocalDateTime transactionDate,
                                         User user, Category category) {
        IncomeSpending incomeSpending =
                createIncomeSpending(dataCode, content, amount, transactionDate, user, category);
        em.persist(incomeSpending);
    }

    public static IncomeSpending createIncomeSpending(DataCode dataCode, String content, Long amount,
                                                      LocalDateTime transactionDate, User user,
                                                      Category category) {

        IncomeSpending incomeSpending =
                new IncomeSpending().builder()
                        .dataCode(dataCode)
                        .content(content)
                        .amount(amount)
                        .transactionDate(transactionDate)
                        .user(user)
                        .category(category)
                        .build();
        log.info("생성된 거래내역 데이터 : " + incomeSpending);
        return incomeSpending;
    }

    public static IncomeSpendingDto createIncomeSpendingDto(String dataCode, String content, Long amount,
                                                      String transactionDate, String userId,
                                                      String categoryName) {

        IncomeSpendingDto incomeSpendingDto =
                new IncomeSpendingDto().builder()
                        .dataCode(dataCode)
                        .content(content)
                        .amount(amount)
                        .transactionDate(transactionDate)
                        .userId(userId)
                        .categoryName(categoryName)
                        .build();
        log.info("생성된 거래내역 데이터 : " + incomeSpendingDto);
        return incomeSpendingDto;
    }
}
