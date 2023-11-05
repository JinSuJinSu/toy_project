package com.poscodx.economy.repository;

import com.poscodx.economy.config.QuerydslConfiguration;
import com.poscodx.economy.dbinit.CategoryTestUtils;
import com.poscodx.economy.dbinit.IncomeSpendingTestUtils;
import com.poscodx.economy.dbinit.UserTestUtils;
import com.poscodx.economy.domain.*;
import com.poscodx.economy.enumration.DataCode;
import com.poscodx.economy.repository.jpa.CategoryRepository;
import com.poscodx.economy.repository.jpa.IncomeSpendingRepository;
import com.poscodx.economy.repository.jpa.PaymentRepository;
import com.poscodx.economy.repository.jpa.UserRepository;
import com.poscodx.economy.repository.querydsl.CategoryRepositoryCustomImpl;
import com.poscodx.economy.repository.querydsl.IncomeSpendingRepositoryCustomImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@DataJpaTest
@ComponentScan(basePackages = "com.poscodx.economy.repository")
@Import({CategoryRepositoryCustomImpl.class, IncomeSpendingRepositoryCustomImpl.class, QuerydslConfiguration.class})
class IncomeSpendingRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private IncomeSpendingRepository incomeSpendingRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @BeforeEach
    public void init() {
        System.out.println("데이터 삽입 시작");
        UserTestUtils.addUser(em);

        // 거래내역 데이터 추가하기
        User user = userRepository.findByUserId("hjs429");
        CategoryTestUtils.addCategory(em, user);
        Category category1 = categoryRepository.findByName("식비");
        Category category2 = categoryRepository.findByName("자기개발");
        Category category3 = categoryRepository.findCategoryName("투자수익");

        LocalDateTime transactionDate = LocalDateTime.now();

        IncomeSpendingTestUtils.addIncomeSpending(em, DataCode.지출, "순대국밥",
                10000L, transactionDate, user, category1);
        IncomeSpendingTestUtils.addIncomeSpending(em, DataCode.지출, "권투수강",
                30000L, transactionDate, user, category2);
        IncomeSpendingTestUtils.addIncomeSpending(em, DataCode.수입, "국내주식매도",
                50000L, transactionDate, user, category3);
    }

    @Test
    @DisplayName("유저생성 테스트")
    void searchUser() {
        // given
        User user = userRepository.findByUserId("hjs429");

        // when
        String userId = user.getUserId();
        //then
        assertThat(userId).isEqualTo("hjs429");
    }

    @Test
    @DisplayName("카테고리 생성 테스트")
    void searchCategory() {
        // given
        Category category1 = categoryRepository.findByName("식비");
        Category category2 = categoryRepository.findByName("자기개발");
        Category category3 = categoryRepository.findCategoryName("투자수익");
        // when
        String categoryName1 = category1.getName();
        String categoryName2 = category2.getName();
        String categoryName3 = category3.getName();
        System.out.println("객체 : " + category1);
        //then
        assertThat(categoryName1).isEqualTo("식비");
        assertThat(categoryName2).isEqualTo("자기개발");
        assertThat(categoryName3).isEqualTo("투자수익");

    }

    @Test
    @DisplayName("거래내역 조회 테스트(날짜는 상황에 따라 다름)")
    void searchIncomeSpending() {
        // given
        LocalDateTime startDate = LocalDateTime.now().minusDays(0);
        LocalDateTime endDate = LocalDateTime.now().plusDays(3);
        User user = userRepository.findByUserId("hjs429");
        String userId = user.getUserId();
//        incomeSpendingListtt.forEach(data -> System.out.println("생성날짜 : " + data.getCreatedDate()));
        List<IncomeSpending> incomeSpendingList =
                incomeSpendingRepository.findDataByDateTime(userId, startDate, endDate);

        // when
        int size = incomeSpendingList.size();

        //then
        assertThat(size).isEqualTo(0);
    }

    @Test
    @DisplayName("거래내역 삽입 테스트")
    void insertIncomeSpending() {
        // given
        String userId = "hjs429";
//        String paymentData = "순대국밥";
        String paymentData = "사천짜장";
        LocalDateTime transactionDate = LocalDateTime.now();
        User user = userRepository.findByUserId(userId);
        Category category = categoryRepository.findCategoryByPayment(paymentData, userId);
        System.out.println("카테고리 데이터 : "+ category);
        IncomeSpending incomeSpending = IncomeSpendingTestUtils.createIncomeSpending
                (DataCode.지출, paymentData, 10000L, transactionDate, user, category);

        // when
        incomeSpendingRepository.save(incomeSpending);
        IncomeSpending insertedIncomeSpending = incomeSpendingRepository.findFirstByOrderByIdDesc();

        //then
//        assertThat(insertedIncomeSpending.getContent()).isEqualTo("순대국밥");
//        assertThat(insertedIncomeSpending.getCategory()).isNotNull();
        assertThat(insertedIncomeSpending.getContent()).isEqualTo("사천짜장");
        assertThat(insertedIncomeSpending.getCategory()).isNull();
    }

    @Test
    @DisplayName("거래내역 전체 목록 삽입 테스트")
    void insertIncomeSpendingList() {
//        // given
        String userId = "hjs429";
        User user = userRepository.findByUserId(userId);
        LocalDateTime transactionDate = LocalDateTime.now();
        ArrayList<String> paymentList =  new ArrayList<String>(Arrays.asList("순대국밥","인프런강의","해외주식매도"));
        ArrayList<DataCode> transactionList = new ArrayList<>();
        transactionList.add(DataCode.지출);
        transactionList.add(DataCode.지출);
        transactionList.add(DataCode.수입);
        // when
        IntStream.range(0, paymentList.size()).forEach(index-> {
            Optional<Payment> payment =  paymentRepository.findFirstByData(paymentList.get(index));
            Category category = null;
            if (payment.isPresent()) {
                category = categoryRepository.findCategoryByPayment(paymentList.get(index), userId);
            }
            IncomeSpending incomeSpending = IncomeSpendingTestUtils.createIncomeSpending
                (transactionList.get(index), paymentList.get(index), 10000L, transactionDate, user, category);
            incomeSpendingRepository.save(incomeSpending);
            }
        );
        List<IncomeSpending> incomeSpendingLis1 = incomeSpendingRepository.findAll();
        List<IncomeSpending> incomeSpendingLis2 = incomeSpendingRepository.findByContent("순대국밥");
        IncomeSpending latestIncomeSpending = incomeSpendingRepository.findFirstByOrderByIdDesc();


        //then
        assertThat(incomeSpendingLis1.size()).isEqualTo(6);
        assertThat(incomeSpendingLis2.size()).isEqualTo(2);
        assertThat(latestIncomeSpending.getContent()).isEqualTo("해외주식매도");

    }
}
