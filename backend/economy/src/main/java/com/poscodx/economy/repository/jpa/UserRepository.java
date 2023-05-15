package com.poscodx.economy.repository.jpa;

import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
}
