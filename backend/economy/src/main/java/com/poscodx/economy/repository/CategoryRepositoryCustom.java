package com.poscodx.economy.repository;

import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.DetailCategory;
import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.domain.Payment;
import com.querydsl.core.Tuple;

import java.time.LocalDateTime;
import java.util.List;

public interface CategoryRepositoryCustom {

    Category findCategoryName(String categoryName);

    Long findCategoryIdByPayment(String paymentData);

    List<DetailCategory> findDetailCategory(String categoryName);

    List<Payment> findPayment(String detailCategoryName);

    List<Tuple> findAllCategory(String userId);

}
