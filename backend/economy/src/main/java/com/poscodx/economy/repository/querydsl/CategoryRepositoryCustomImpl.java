package com.poscodx.economy.repository.querydsl;

import com.poscodx.economy.domain.*;
import com.poscodx.economy.repository.CategoryRepositoryCustom;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

    // querydsl 생성자 만들기
//    private final EntityManager em;
    private final JPAQueryFactory query;

    @Override
    public Category findCategoryName(String categoryName) {
        QCategory category = QCategory.category;
        return query.selectFrom(category)
                .where(category.name.eq(categoryName))
                .fetchOne();
    }

    @Override
    public Category findCategoryByPayment(String paymentData, String userId) {
        QCategory category = QCategory.category;
        QDetailCategory detailCategory = QDetailCategory.detailCategory;
        QPayment payment = QPayment.payment;
        QUser user = QUser.user;
            return query
                    .select(category)
                    .from(payment)
                    .join(payment.detailCategory, detailCategory)
                    .join(detailCategory.category, category)
                    .join(category.user, user)
                    .where(payment.data.eq(paymentData)
                            .and(user.userId.eq(userId)))
                    .fetchOne();
        }

    @Override
    public List<DetailCategory> findDetailCategory(String categoryName) {
        QDetailCategory detailCategory = QDetailCategory.detailCategory;
        return query.selectFrom(detailCategory)
                .where(detailCategory.category.name.eq(categoryName))
                .fetch();
    }

    @Override
    public List<Payment> findPayment(String detailCategoryName) {
        QPayment payment = QPayment.payment;
        return query.selectFrom(payment)
                .where(payment.detailCategory.name.eq(detailCategoryName))
                .fetch();
    }

    @Override
    public List<Tuple> findAllCategory(String userId) {
        QCategory category = QCategory.category;
        QDetailCategory detailCategory = QDetailCategory.detailCategory;
        QPayment payment = QPayment.payment;
        List<Tuple> result = query.select(detailCategory.category.name,
                        detailCategory.name, payment.data)
                .from(payment)
                .join(payment.detailCategory, detailCategory)
                .join(detailCategory.category, category)
                .fetch();
        return result;
    }




}

