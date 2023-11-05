package com.poscodx.economy.controller;

import com.poscodx.economy.dto.IncomeSpendingDto;
import com.poscodx.economy.serviceImpl.IncomeSpendingServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class IncomeSpendingController {

    private final IncomeSpendingServiceImpl incomeSpendingService;

    @GetMapping("/incomeSpending/{userId}/{startDate}/{endDate}")
    public List<IncomeSpendingDto> getMoneyData(
            @PathVariable("userId") String userId,
            @PathVariable("startDate") String startDate,
            @PathVariable("endDate") String endDate) {
        List<IncomeSpendingDto> resultList =
                incomeSpendingService.getIncomeSpendingList(userId, startDate, endDate);
        return resultList;
    }

    @PostMapping("/incomeSpending/{userId}")
    public List<IncomeSpendingDto> insertData(
            @RequestBody List<IncomeSpendingDto> IncomeSpendingDtoList,
            @PathVariable("userId") String userId) {
        log.info("최종 결과값 : " + IncomeSpendingDtoList);
        incomeSpendingService.insertIncomeSpendingList(userId, IncomeSpendingDtoList);
        return IncomeSpendingDtoList;
    }
}
