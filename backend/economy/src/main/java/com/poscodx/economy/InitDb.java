package com.poscodx.economy;

import com.poscodx.economy.dbinit.CategoryDbInit;
import com.poscodx.economy.dbinit.IncomeSpendingDbInit;
import com.poscodx.economy.dbinit.UserDbInit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final UserDbInit userDbInit;
    private final CategoryDbInit categoryDbInit;
    private final IncomeSpendingDbInit inspendingDbInit;

    @PostConstruct
    public void init() {
        userDbInit.dbInit();
        categoryDbInit.dbInit();
        inspendingDbInit.dbInit();
    }

}