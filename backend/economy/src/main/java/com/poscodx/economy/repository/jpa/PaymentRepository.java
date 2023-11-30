package com.poscodx.economy.repository.jpa;

import com.poscodx.economy.domain.Payment;
import com.poscodx.economy.repository.PaymentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends
        JpaRepository<Payment, Long>, PaymentRepositoryCustom {
    Optional<Payment> findFirstByData(String data);

}