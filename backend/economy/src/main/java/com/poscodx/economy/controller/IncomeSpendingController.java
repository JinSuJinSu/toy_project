package com.poscodx.economy.controller;

import com.poscodx.economy.dto.IncomeSpendingDto;
import com.poscodx.economy.serviceImpl.IncomeSpendingServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class IncomeSpendingController {

    private final IncomeSpendingServiceImpl incomeSpendingService;

    @GetMapping("/test/{userId}/{startDate}/{endDate}")
    public List<IncomeSpendingDto> getMoneyData(
            @PathVariable("userId") String userId,
            @PathVariable("startDate") String startDate,
            @PathVariable("endDate") String endDate) {
        List<IncomeSpendingDto> resultList =
                incomeSpendingService.getIncomeSpendingList(userId, startDate, endDate);
        log.info("최종 결과값 : " + resultList);
        return resultList;
    }
}
