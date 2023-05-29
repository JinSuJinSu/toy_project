package com.poscodx.economy.dbinit;

import com.poscodx.economy.domain.User;
import com.poscodx.economy.enumration.UserGrade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserDbInit {

    private final EntityManager em;

    public void dbInit(){
        User user1 = createUser("hjs429", "1234", "하진수",
                "010-2632-2615", "hjs928@naver.com", UserGrade.ADMIN);
        em.persist(user1);
    }

    private User createUser(String userId, String password, String name,
                                  String phoneNumber, String email, UserGrade grade) {

        User user =
                new User().builder()
                        .userId(userId)
                        .password(password)
                        .name(name)
                        .phoneNumber(phoneNumber)
                        .email(email)
                        .grade(grade)
                        .build();
        log.info("생성된 유저 : " + user);
        return user;
    }
}
