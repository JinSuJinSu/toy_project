package com.poscodx.economy.dbinit;

import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.DetailCategory;
import com.poscodx.economy.domain.Payment;
import com.poscodx.economy.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CategoryDbInit {

    private final EntityManager em;

    public void dbInit(){
        User user = em.find(User.class, 1L);
        Category category1 = createCategory("식비", "식비 카테고리",
                "아직은 없어도 된다.", user);
        Category category2 = createCategory("자기개발", "자기개발 카테고리",
                "아직은 없어도 된다.", user);
        Category category3 = createCategory("투자수익", "투자수익 카테고리",
                "아직은 없어도 된다.", user);

        em.persist(category1);
        em.persist(category2);
        em.persist(category3);

        DetailCategory detailCategory1 = createDetailCategory("개인식비", "나중에",
                "아직은 없어도 된다.",category1);
        DetailCategory detailCategory2 = createDetailCategory("회사식비", "나중에",
                "아직은 없어도 된다.",category1);
        DetailCategory detailCategory3 = createDetailCategory("운동", "나중에",
                "아직은 없어도 된다.",category2);
        DetailCategory detailCategory4 = createDetailCategory("인터넷강의", "나중에",
                "아직은 없어도 된다.",category2);
        DetailCategory detailCategory5 = createDetailCategory("회사월급", "나중에",
                "아직은 없어도 된다.",category3);
        DetailCategory detailCategory6 = createDetailCategory("토토", "나중에",
                "아직은 없어도 된다.",category3);

        em.persist(detailCategory1);
        em.persist(detailCategory2);
        em.persist(detailCategory3);
        em.persist(detailCategory4);
        em.persist(detailCategory5);
        em.persist(detailCategory6);

        Payment payment1 = createPayment("선달국밥", detailCategory1);
        Payment payment2 = createPayment("버거킹", detailCategory1);
        Payment payment3 = createPayment("포항제철소 식당", detailCategory2);
        Payment payment4 = createPayment("퀸복싱클럽", detailCategory3);
        Payment payment5 = createPayment("김영한의 스프링", detailCategory4);
        Payment payment6 = createPayment("쉽게 배우는 MSA", detailCategory4);
        Payment payment7 = createPayment("포스코 DX", detailCategory5);
        Payment payment8 = createPayment("특별 격려금", detailCategory5);
        Payment payment9 = createPayment("경영 성과금", detailCategory5);

        em.persist(payment1);
        em.persist(payment2);
        em.persist(payment3);
        em.persist(payment4);
        em.persist(payment5);
        em.persist(payment6);
        em.persist(payment7);
        em.persist(payment8);
        em.persist(payment9);
    }

    private Category createCategory(String name, String content, String categoryData,
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
