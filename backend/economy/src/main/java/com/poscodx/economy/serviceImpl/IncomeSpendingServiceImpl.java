package com.poscodx.economy.serviceImpl;

import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.domain.User;
import com.poscodx.economy.dto.IncomeSpendingDto;
import com.poscodx.economy.mapper.IncomeSpendingMapper;
import com.poscodx.economy.repository.jpa.IncomeSpendingRepository;
import com.poscodx.economy.repository.jpa.UserRepository;
import com.poscodx.economy.service.IncomeSpendingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class IncomeSpendingServiceImpl implements IncomeSpendingService {

    private final IncomeSpendingRepository incomeSpendingRepository;

    private final UserRepository userRepository;

    @Override
    public List<IncomeSpendingDto> getIncomeSpendingList(String userId, String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse(startDate + " 00:00:00", formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate + " 23:59:59", formatter);

        log.info("레파지토리 시작날짜 : " + startDateTime);
        log.info("레파지토리 종료날짜 : " + endDateTime);
        log.info("사용자 아이디 : " + userId);

        User user = userRepository.findByUserId(userId);

        List<IncomeSpending> IncomeSpendingList =
                incomeSpendingRepository.findDataByDateTime(userId, startDateTime, endDateTime);
        List<IncomeSpendingDto> IncomeSpendingDtoList = IncomeSpendingList.stream()
                        .map(m -> IncomeSpendingMapper.INSTANCE.toDto(m))
                        .collect(Collectors.toList());
        return IncomeSpendingDtoList;
    }
}
