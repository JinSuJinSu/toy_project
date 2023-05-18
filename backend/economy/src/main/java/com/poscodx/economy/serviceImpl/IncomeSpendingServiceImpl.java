package com.poscodx.economy.serviceImpl;

import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.dto.IncomeSpendingDto;
import com.poscodx.economy.mapper.IncomeSpendingMapper;
import com.poscodx.economy.repository.jpa.IncomeSpendingRepository;
import com.poscodx.economy.service.IncomeSpendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeSpendingServiceImpl implements IncomeSpendingService {

    private final IncomeSpendingRepository incomeSpendingRepository;

    @Override
    public List<IncomeSpendingDto> getIncomeSpendingList(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDateTime startDateTime = LocalDateTime.parse(startDate, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, formatter);
        List<IncomeSpending> IncomeSpendingList =
                incomeSpendingRepository.findByCreatedDateBetween(startDateTime, endDateTime);
        List<IncomeSpendingDto> IncomeSpendingDtoList = IncomeSpendingList.stream()
                        .map(m -> IncomeSpendingMapper.INSTANCE.toDto(m))
                        .collect(Collectors.toList());
        return IncomeSpendingDtoList;
    }
}
