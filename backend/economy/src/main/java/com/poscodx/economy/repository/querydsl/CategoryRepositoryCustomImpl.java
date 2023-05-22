package com.poscodx.economy.repository.querydsl;

import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.domain.QCategory;
import com.poscodx.economy.domain.QIncomeSpending;
import com.poscodx.economy.repository.CategoryRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

    // querydsl 생성자 만들기
//    private final EntityManager em;
    private final JPAQueryFactory query;

    @Override
    public Category findCategoryName(String categoryName) {
        QCategory category = QCategory.category;
        return query.selectFrom(category)
                .where(category.categoryCom.name.eq(categoryName))
                .fetchOne();
    }
}

