package com.poscodx.economy.serviceImpl;

import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.domain.Payment;
import com.poscodx.economy.domain.User;
import com.poscodx.economy.dto.CategoryDto;
import com.poscodx.economy.dto.IncomeSpendingDto;
import com.poscodx.economy.mapper.IncomeSpendingMapper;
import com.poscodx.economy.repository.jpa.CategoryRepository;
import com.poscodx.economy.repository.jpa.IncomeSpendingRepository;
import com.poscodx.economy.repository.jpa.PaymentRepository;
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
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class IncomeSpendingServiceImpl implements IncomeSpendingService {

    private final IncomeSpendingRepository incomeSpendingRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public List<IncomeSpendingDto> getIncomeSpendingList(String userId, String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse(startDate + " 00:00:00", formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate + " 23:59:59", formatter);

        User user = userRepository.findByUserId(userId);

        List<IncomeSpending> IncomeSpendingList =
                incomeSpendingRepository.findDataByDateTime(userId, startDateTime, endDateTime);
        List<IncomeSpendingDto> IncomeSpendingDtoList = IncomeSpendingList.stream()
                        .map(m -> IncomeSpendingMapper.INSTANCE.toDto(m))
                        .collect(Collectors.toList());
        return IncomeSpendingDtoList;
    }
    @Override
    public void insertIncomeSpending(String userId, String paymentData) {
        Optional<Payment> payment =  paymentRepository.findFirstByData(paymentData);
        Category category = new Category();
        if (payment.isPresent()) {
            category = categoryRepository.findCategoryByPayment(paymentData, userId);
        }

        IncomeSpending incomeSpending = new IncomeSpending();
        incomeSpendingRepository.save(incomeSpending);
    }
    @Override
    public void insertIncomeSpendingList(String userId, List<IncomeSpendingDto> IncomeSpendingDtoList) {
        IncomeSpendingDtoList.forEach(data->{
            data.filterId();
        });
        List<IncomeSpending> IncomeSpendingList = IncomeSpendingDtoList.stream()
                .map(m -> IncomeSpendingMapper.INSTANCE.toEntity(m))
                .collect(Collectors.toList());

        IncomeSpendingList.forEach(data->{
            Category category = null;
            User user = userRepository.findByUserId(userId);
            Optional<Payment> payment =  paymentRepository.findFirstByData(data.getContent());
            if (payment.isPresent()) {
                category = categoryRepository.findCategoryByPayment(data.getContent(), userId);
            }
            data.setUserAndCategory(user,category);
        incomeSpendingRepository.save(data);
 });



    }
}
