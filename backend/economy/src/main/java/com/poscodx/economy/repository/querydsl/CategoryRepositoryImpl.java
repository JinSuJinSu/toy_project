package com.poscodx.economy.repository.querydsl;

import com.poscodx.economy.domain.Category;
import com.poscodx.economy.repository.CustomCategoryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;

public class CategoryRepositoryImpl implements CustomCategoryRepository{

    // querydsl 생성자 만들기
    private final EntityManager em;
    private final JPAQueryFactory query;

    public CategoryRepositoryImpl(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public Category findByCategoryName(String categoryName) {
        QCategory category = QCategory.category;
        return query.selectFrom(category)
                .where(category.categoryCom.name.eq(categoryName))
                .fetchOne();
    }
}

