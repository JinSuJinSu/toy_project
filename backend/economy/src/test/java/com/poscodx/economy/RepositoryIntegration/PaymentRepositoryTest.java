package com.poscodx.economy.RepositoryIntegration;

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

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@DataJpaTest
@ComponentScan(basePackages = "com.poscodx.economy.repository")
@Import({CategoryRepositoryCustomImpl.class, QuerydslConfiguration.class})
public class PaymentRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @BeforeEach
    public void init() {

    }

    @Test
    @DisplayName("Payment 조회 테스트")
    void searchPayment(){
        // given
        User user = UserTestUtils.createUser("hjs429", "1234", "하진수",
                "010-2632-2615", "hjs928@naver.com", UserGrade.ADMIN);
        when(userRepository.findByUserId("hjs429")).thenReturn(user);

        // 카테고리 데이터 추가
        Category category = CategoryTestUtils.createCategory("식비", "식비 카테고리",
                "아직은 없어도 된다.", user);
        when(categoryRepository.findByName("식비")).thenReturn(category);

        DetailCategory detailCategory = CategoryTestUtils.createDetailCategory
                ("개인식비", "나중에", "아직은 없어도 된다.",category);


        // 세부카테고리에 대한 지불내역 데이터 집어넣기
        CategoryTestUtils.addPayment(em, "순대국밥",detailCategory);
        em.flush();
        String insertData = "순대국밥";

        // when
        Optional<Payment> payment =  paymentRepository.findFirstByData(insertData);

        //then
        assertNotNull(payment);
    }
    
}


