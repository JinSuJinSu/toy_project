package com.poscodx.economy.dbinit;

import com.poscodx.economy.domain.User;
import com.poscodx.economy.enumration.UserGrade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserTestUtils {

    public static void addUser(TestEntityManager em){
        LocalDateTime joinDate = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        User user1 = createUser("hjs429", "1234", "하진수",
                "010-2632-2615", "hjs928@naver.com", UserGrade.ADMIN, joinDate);
        em.persist(user1);
    }

    private static User createUser(String userId, String password, String name,
                                   String phoneNumber, String email, UserGrade grade,
                                   LocalDateTime joinDate) {

        User user =
                new User().builder()
                        .userId(userId)
                        .password(password)
                        .name(name)
                        .phoneNumber(phoneNumber)
                        .email(email)
                        .grade(grade)
                        .joinDate(joinDate)
                        .build();
        log.info("생성된 유저 : " + user);
        return user;
    }
}
