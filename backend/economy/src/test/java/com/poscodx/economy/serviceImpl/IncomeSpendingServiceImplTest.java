package com.poscodx.economy.serviceImpl;

import com.poscodx.economy.repository.jpa.IncomeSpendingRepository;
import com.poscodx.economy.service.IncomeSpendingService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IncomeSpendingServiceImplTest {


    @InjectMocks
    private IncomeSpendingServiceImpl incomeSpendingService; // the service we're testing

    @Mock
    private IncomeSpendingRepository incomeSpendingRepository; // mock the dependency



}