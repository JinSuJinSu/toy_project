package com.poscodx.economy.repository;

import com.poscodx.economy.dbinit.UserTestUtils;
import com.poscodx.economy.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan(basePackages = "com.poscodx.economy.repository")
class IncomeSpendingRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private IncomeSpendingRepository incomeSpendingRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        System.out.println("데이터 삽입 시작");
        UserTestUtils.addUser(em);
    }

    @Test
    @DisplayName("거래내역 조회 테스트")
    void searchStock(){
        // given
        User user = userRepository.findByUserId("hjs429");
        // when
        //then
        assertThat(user.getUserId()).isEqualTo("hjs429");

    }



}