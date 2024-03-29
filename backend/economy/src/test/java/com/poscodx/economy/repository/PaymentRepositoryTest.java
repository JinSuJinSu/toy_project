package com.poscodx.economy.repository;

import com.poscodx.economy.config.QuerydslConfiguration;
import com.poscodx.economy.dbinit.CategoryTestUtils;
import com.poscodx.economy.dbinit.UserTestUtils;
import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.DetailCategory;
import com.poscodx.economy.domain.Payment;
import com.poscodx.economy.domain.User;
import com.poscodx.economy.enumration.UserGrade;
import com.poscodx.economy.repository.jpa.CategoryRepository;
import com.poscodx.economy.repository.jpa.PaymentRepository;
import com.poscodx.economy.repository.jpa.UserRepository;
import com.poscodx.economy.repository.querydsl.CategoryRepositoryCustomImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@DataJpaTest
@ComponentScan(basePackages = "com.poscodx.economy.repository")
@Import({CategoryRepositoryCustomImpl.class, QuerydslConfiguration.class})
public class PaymentRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @BeforeEach
    public void init() {
        UserTestUtils.addUser(em);
        User user = userRepository.findByUserId("hjs429");
        CategoryTestUtils.addCategory(em,user);

        // 카테고리 데이터 추가
        Category category1 = categoryRepository.findByName("식비");
        Category category2 = categoryRepository.findByName("자기개발");
        Category category3 = categoryRepository.findCategoryName("투자수익");

        // 세부카테고리에 데이터 집어넣기
        CategoryTestUtils.addDetailCategory(em, "개인식비",category1);
        CategoryTestUtils.addDetailCategory(em, "운동",category2);
        CategoryTestUtils.addDetailCategory(em, "회사월급",category3);

        // 세부카테고리에 대한 지불내역 데이터 집어넣기

    }

    @Test
    @DisplayName("Payment 조회 테스트")
    void searchPayment(){
        // given
        // 세부카테고리에 대한 지불내역 데이터 집어넣기
        Category category1 = categoryRepository.findByName("식비");
        List<DetailCategory> detailCategory1 = categoryRepository.findDetailCategory
                (category1.getName());
        CategoryTestUtils.addPayment(em, "순대국밥",detailCategory1.get(0));
        String insertData = "순대국밥";

        // when
        Optional<Payment> payment =  paymentRepository.findFirstByData(insertData);

        //then
        assertNotNull(payment);
    }
    
}


