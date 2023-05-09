package com.poscodx.economy.repository;

import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IncomeSpendingRepository extends JpaRepository<IncomeSpending, Long>{
    List<IncomeSpending> findByCreationDateBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
