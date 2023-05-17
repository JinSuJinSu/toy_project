package com.poscodx.economy.service;

import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.dto.IncomeSpendingDto;

import java.util.List;

public interface IncomeSpendingService{
    List<IncomeSpendingDto> getIncomeSpendingList(String startDate, String endDate);
}