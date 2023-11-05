package com.poscodx.economy.repository;

import com.poscodx.economy.config.QuerydslConfiguration;
import com.poscodx.economy.dbinit.CategoryTestUtils;
import com.poscodx.economy.dbinit.UserTestUtils;
import com.poscodx.economy.domain.*;
import com.poscodx.economy.repository.jpa.CategoryRepository;
import com.poscodx.economy.repository.jpa.PaymentRepository;
import com.poscodx.economy.repository.jpa.UserRepository;
import com.poscodx.economy.repository.querydsl.CategoryRepositoryCustomImpl;
import com.querydsl.core.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@DataJpaTest
@ComponentScan(basePackages = "com.poscodx.economy.repository")
@Import({CategoryRepositoryCustomImpl.class, QuerydslConfiguration.class})
public class CategoryRepositoryTest {

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
        System.out.println("데이터 삽입 시작");
        UserTestUtils.addUser(em);

        // 유저 조회
        User user = userRepository.findByUserId("hjs429");
        System.out.println("유저 아이디 조회하기 : " + user);
        // 카테고리 데이터 추가
        CategoryTestUtils.addCategory(em, user);
        Category category1 = categoryRepository.findByName("식비");
        Category category2 = categoryRepository.findByName("자기개발");
        Category category3 = categoryRepository.findCategoryName("투자수익");

        CategoryTestUtils.addDetailCategory(em, "개인식비",category1);
        CategoryTestUtils.addDetailCategory(em, "운동",category2);
        CategoryTestUtils.addDetailCategory(em, "회사월급",category3);

        // 세부카테고리에 대한 지불내역 데이터 집어넣기
        List<DetailCategory> detailCategory1 = categoryRepository.findDetailCategory
                (category1.getName());
        List<DetailCategory> detailCategory2 = categoryRepository.findDetailCategory
                (category2.getName());
        List<DetailCategory> detailCategory3 = categoryRepository.findDetailCategory
                (category3.getName());

        CategoryTestUtils.addPayment(em, "선달국밥",detailCategory1.get(0));
        CategoryTestUtils.addPayment(em, "퀸복싱클럽",detailCategory2.get(0));
        CategoryTestUtils.addPayment(em, "포스코dx",detailCategory3.get(0));
    }

    @Test
    @DisplayName("카테고리 데이터 테스트")
    void IncomeSpendingData(){
        // given
        Category category1 = categoryRepository.findByName("식비");
        Category category2 = categoryRepository.findByName("자기개발");
        Category category3 = categoryRepository.findCategoryName("투자수익");

        List<DetailCategory> detailCategory1 = categoryRepository.findDetailCategory
                (category1.getName());
        List<DetailCategory> detailCategory2 = categoryRepository.findDetailCategory
                (category2.getName());
        List<DetailCategory> detailCategory3 = categoryRepository.findDetailCategory
                (category3.getName());

        List<Payment> payment1 = categoryRepository.findPayment
                (detailCategory1.get(0).getName());
        List<Payment> payment2 = categoryRepository.findPayment
                (detailCategory2.get(0).getName());
        List<Payment> payment3 = categoryRepository.findPayment
                (detailCategory3.get(0).getName());

        // when
        String detailCategoryName1 = detailCategory1.get(0).getName();
        String detailCategoryName2 = detailCategory2.get(0).getName();
        String detailCategoryName3 = detailCategory3.get(0).getName();

        String paymentName1 = payment1.get(0).getData();
        String paymentName2 = payment2.get(0).getData();
        String paymentName3 = payment3.get(0).getData();

        //then
        assertThat(detailCategoryName1).isEqualTo("개인식비");
        assertThat(detailCategoryName2).isEqualTo("운동");
        assertThat(detailCategoryName3).isEqualTo("회사월급");

        assertThat(paymentName1).isEqualTo("선달국밥");
        assertThat(paymentName2).isEqualTo("퀸복싱클럽");
        assertThat(paymentName3).isEqualTo("포스코dx");
    }

    @Test
    @DisplayName("카테고리 조회 테스트")
    void searchIncomeSpending(){
        // given
        String userId = ("hjs429");
        List<Tuple> categoryList = categoryRepository.findAllCategory(userId);

        // when
        int size = categoryList.size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @Test
    @DisplayName("Payment 데이터로 카테고리 조회하기")
    void searchCategoryByPayment(){
        // given
        String insertData = "선달국밥";
        Optional<Payment> payment =  paymentRepository.findFirstByData(insertData);
        Category category = null;

        // when
        if(payment.isPresent()){
            String userId = ("hjs429");
            category = categoryRepository.findCategoryByPayment(insertData, userId);
        }
        assertNotNull(category);
    }



    


}
