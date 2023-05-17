package com.poscodx.economy.dbinit;

import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.CategoryCom;
import com.poscodx.economy.domain.User;
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

    public static void addCategory(TestEntityManager em){
        Category category1 = createCategory("식비", "식비 카테고리",
                "아직은 없어도 된다.");
        Category category2 = createCategory("자기개발", "자기개발 카테고리",
                "아직은 없어도 된다.");
        Category category3 = createCategory("투자수익", "투자수익 카테고리",
                "아직은 없어도 된다.");
        em.persist(category1);
        em.persist(category2);
        em.persist(category3);
    }

    private static Category createCategory(String name, String content, String categoryData) {

        Category category =
                new Category().builder()
                        .categoryCom(new CategoryCom().builder()
                                .name(name)
                                .content(content)
                                .categoryData(categoryData)
                                .build())
                        .build();
        return category;


    }
}
