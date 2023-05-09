package com.poscodx.economy.controller;

import com.poscodx.economy.dto.IncomeSpendingDto;
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

    @GetMapping("/test/{startDate}/{endDate}")
    public List<IncomeSpendingDto> getMoneyData(
            @PathVariable("startDate") String startDate,
            @PathVariable("endDate") String endDate) {
        log.info("시작날짜 : " + startDate);
        log.info("끝날짜 : " + endDate);

        return null;
    }
}
