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
        LocalDateTime creationDate = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        LocalDateTime updateDate = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        Category category1 = createCategory("식비", creationDate, updateDate,
                "식비 카테고리", "아직은 없어도 된다.");
        Category category2 = createCategory("자기개발", creationDate, updateDate,
                "자기개발 카테고리", "아직은 없어도 된다.");
        Category category3 = createCategory("가족서포트", creationDate, updateDate,
                "가족서포트 카테고리", "아직은 없어도 된다.");
        em.persist(category1);
        em.persist(category2);
        em.persist(category3);
    }

    private static Category createCategory(String name, LocalDateTime creationDate, LocalDateTime updateDate,
                                   String content, String categoryData) {

        Category category =
                new Category().builder()
                        .categoryCom(new CategoryCom().builder()
                                .name(name)
                                .creationDate(creationDate)
                                .updateDate(updateDate)
                                .content(content)
                                .categoryData(categoryData)
                                .build())
                        .build();
        return category;


    }
}
