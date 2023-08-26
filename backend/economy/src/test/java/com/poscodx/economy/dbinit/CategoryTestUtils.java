package com.poscodx.economy.dbinit;

import com.poscodx.economy.domain.*;
import com.poscodx.economy.enumration.UserGrade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CategoryTestUtils {

    public static void addCategory(TestEntityManager em, User user){
        Category category1 = createCategory("식비", "식비 카테고리",
                "아직은 없어도 된다.", user);
        Category category2 = createCategory("자기개발", "자기개발 카테고리",
                "아직은 없어도 된다.", user);
        Category category3 = createCategory("투자수익", "투자수익 카테고리",
                "아직은 없어도 된다.", user);
        em.persist(category1);
        em.persist(category2);
        em.persist(category3);
    }

    public static void addDetailCategory(TestEntityManager em, String name, Category category){
        DetailCategory detailCategory = createDetailCategory(name, "나중에",
                "아직은 없어도 된다.",category);
        em.persist(detailCategory);
    }

    public static void addPayment(TestEntityManager em, String data, DetailCategory detailCategory){
        Payment payment = createPayment(data, detailCategory);
        em.persist(payment);
    }

    public static Category createCategory(String name, String content, String categoryData,
                                          User user) {

        Category category =
                new Category().builder()
                        .name(name)
                        .content(content)
                        .categoryData(categoryData)
                        .user(user)
                        .build();
        return category;
    }

    public static DetailCategory createDetailCategory(String name, String content,
                                                      String categoryData, Category category) {

        DetailCategory detailCategory =
                new DetailCategory().builder()
                        .name(name)
                        .content(content)
                        .categoryData(categoryData)
                        .category(category)
                        .build();
        return detailCategory;
    }


    public static Payment createPayment(String data, DetailCategory detailCategory) {

        Payment payment =
                new Payment().builder()
                        .data(data)
                        .detailCategory(detailCategory)
                        .build();
        return payment;
    }
}
