package com.poscodx.economy.repository;

import com.poscodx.economy.config.QuerydslConfiguration;
import com.poscodx.economy.dbinit.CategoryTestUtils;
import com.poscodx.economy.dbinit.UserTestUtils;
import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.User;
import com.poscodx.economy.repository.jpa.CategoryRepository;
import com.poscodx.economy.repository.jpa.IncomeSpendingRepository;
import com.poscodx.economy.repository.jpa.UserRepository;
import com.poscodx.economy.repository.querydsl.CategoryRepositoryCustomImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ComponentScan(basePackages = "com.poscodx.economy.repository")
@Import({CategoryRepositoryCustomImpl.class, QuerydslConfiguration.class})
class IncomeSpendingRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private IncomeSpendingRepository incomeSpendingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void init() {
        System.out.println("데이터 삽입 시작");
        UserTestUtils.addUser(em);
        CategoryTestUtils.addCategory(em);
    }

    @Test
    @DisplayName("유저생성 테스트")
    void searchUser(){
        // given
        User user = userRepository.findByUserId("hjs429");
        // when
        String userId = user.getUserId();
        //then
        assertThat(userId).isEqualTo("hjs429");

    }

    @Test
    @DisplayName("카테고리 생성 테스트")
    void searchCategory(){
        // given
        Category category1 = categoryRepository.findByCategoryCom_Name("식비");
        Category category2 = categoryRepository.findByCategoryCom_Name("자기개발");
        Category category3 = categoryRepository.findCategoryName("가족서포트");
        // when
        String categoryName1 = category1.getCategoryCom().getName();
        String categoryName2 = category2.getCategoryCom().getName();
        String categoryName3 = category3.getCategoryCom().getName();
        //then
        assertThat(categoryName1).isEqualTo("식비");
        assertThat(categoryName2).isEqualTo("자기개발");
        assertThat(categoryName3).isEqualTo("가족서포트");

    }

    @Test
    @DisplayName("거래내역 조회 테스트")
    void searchIncomeSpending(){
        // given
        User user = userRepository.findByUserId("hjs429");
        // when
        //then
        assertThat(user.getUserId()).isEqualTo("hjs429");

    }



}