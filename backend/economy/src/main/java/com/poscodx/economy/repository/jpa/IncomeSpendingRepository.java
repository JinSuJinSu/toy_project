package com.poscodx.economy.repository.jpa;

import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.domain.Payment;
import com.poscodx.economy.domain.User;
import com.poscodx.economy.repository.IncomeSpendingRepositoryCustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IncomeSpendingRepository extends
        JpaRepository<IncomeSpending, Long>, IncomeSpendingRepositoryCustom {

    List<IncomeSpending> findAll();
}
