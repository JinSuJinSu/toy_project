package com.poscodx.economy.dbinit;

import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.domain.User;
import com.poscodx.economy.dto.IncomeSpendingDto;
import com.poscodx.economy.enumration.DataCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
@Transactional
@RequiredArgsConstructor
@Slf4j
public class IncomeSpendingDbInit {

    private final EntityManager em;

    public void dbInit() {
        User user = em.find(User.class, 1L);
        Category category1 = em.find(Category.class, 1L); // 식비
        Category category2 = em.find(Category.class, 2L); // 자기개발
        Category category3 = em.find(Category.class, 3L); // 투자수익

        // 식비 관련 수입, 지출 내역
        IncomeSpending incomeSpending1 =  
                createIncomeSpending(DataCode.지출, "순대국밥", 10000L,user,category1);
        IncomeSpending incomeSpending2 =
                createIncomeSpending(DataCode.지출, "치킨", 13000L,user,category1);
        IncomeSpending incomeSpending3 =
                createIncomeSpending(DataCode.지출, "아이스크림", 2000L,user,category1);

        // 자기개발 관련 수입, 지출 내역
        IncomeSpending incomeSpending4 =
                createIncomeSpending(DataCode.지출, "권투수강", 30000L,user,category2);
        IncomeSpending incomeSpending5 =
                createIncomeSpending(DataCode.지출, "영어학원등록", 100000L,user,category2);
        IncomeSpending incomeSpending6 =
                createIncomeSpending(DataCode.지출, "문제집구매", 20000L,user,category2);

        // 투자 관련 수입, 지출 내역
        IncomeSpending incomeSpending7 =
                createIncomeSpending(DataCode.수입, "주식매도", 50000L,user,category3);
        IncomeSpending incomeSpending8 =
                createIncomeSpending(DataCode.수입, "달러판매", 70000L,user,category3);
        IncomeSpending incomeSpending9 =
                createIncomeSpending(DataCode.수입, "비트코인판매", 200000L,user,category3);
        IncomeSpending incomeSpending10 =
                createIncomeSpending(DataCode.수입, "금판매", 70000L,user,category3);

        em.persist(incomeSpending1);
        em.persist(incomeSpending2);
        em.persist(incomeSpending3);
        em.persist(incomeSpending4);
        em.persist(incomeSpending5);
        em.persist(incomeSpending6);
        em.persist(incomeSpending7);
        em.persist(incomeSpending8);
        em.persist(incomeSpending9);
        em.persist(incomeSpending10);
    }

    private IncomeSpending createIncomeSpending(DataCode dataCode, String content, Long amount,
                                                      User user, Category category) {

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
