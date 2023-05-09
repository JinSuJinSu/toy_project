//package com.poscodx.economy.dbinit;
//
//import com.poscodx.economy.domain.Category;
//import com.poscodx.economy.domain.IncomeSpending;
//import com.poscodx.economy.domain.User;
//import com.poscodx.economy.enumration.DataCode;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import java.time.LocalDateTime;
//
//@Component
//@Transactional
//@RequiredArgsConstructor
//public class IncomeSpendingTestUtils {
//
//    private final EntityManager em;
//
//    public void dbInit() {
//        Asset asset1 =
//                createAsset("주식", 10000L);
//        em.persist(asset1);
//
//        Asset asset2 =
//                createAsset("원자재", 9000L);
//        em.persist(asset2);
//
//        Asset asset3 =
//                createAsset("외화", 8000L);
//        em.persist(asset3);
//
//        Asset asset4 =
//                createAsset("코인", 7000L);
//        em.persist(asset4);
//
//        Asset asset5 =
//                createAsset("현금", 10000L);
//        em.persist(asset5);
//
//        Asset asset6 =
//                createAsset("펀드", 10000L);
//        em.persist(asset6);
//
//        Asset asset7 =
//                createAsset("연금", 12000L);
//        em.persist(asset7);
//    }
//    private IncomeSpending createData(LocalDateTime creationDate, DataCode dataCode, User user,
//                                      String content, Long amount, Category category) {
//
//        IncomeSpending incomeSpending =
//                new IncomeSpending().builder()
//                        .creationDate(creationDate)
//                        .dataCode(dataCode)
//                        .user(user)
//                        .content(content)
//                        .amount(amount)
//                        .category(category)
//                        .build();
//        return incomeSpending;
//    }
//}
