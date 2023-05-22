package com.poscodx.economy.repository;

import com.poscodx.economy.domain.IncomeSpending;

import java.time.LocalDateTime;
import java.util.List;

public interface IncomeSpendingRepositoryCustom {

    List<IncomeSpending> findDataByDateTime(String userId,
                                            LocalDateTime startDateTime, LocalDateTime endDateTime);
}
