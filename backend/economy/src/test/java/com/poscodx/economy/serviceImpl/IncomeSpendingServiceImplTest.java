package com.poscodx.economy.serviceImpl;

import com.poscodx.economy.dbinit.CategoryTestUtils;
import com.poscodx.economy.dbinit.IncomeSpendingTestUtils;
import com.poscodx.economy.dbinit.UserTestUtils;
import com.poscodx.economy.domain.Category;
import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.domain.User;
import com.poscodx.economy.dto.IncomeSpendingDto;
import com.poscodx.economy.enumration.DataCode;
import com.poscodx.economy.enumration.UserGrade;
import com.poscodx.economy.mapper.IncomeSpendingMapper;
import com.poscodx.economy.repository.jpa.IncomeSpendingRepository;
import com.poscodx.economy.repository.jpa.UserRepository;
import com.poscodx.economy.service.IncomeSpendingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IncomeSpendingServiceImplTest {


    @InjectMocks
    private IncomeSpendingServiceImpl incomeSpendingService; // the service we're testing

    @Mock
    private IncomeSpendingRepository incomeSpendingRepository; // mock the dependency
    @Mock
    private UserRepository userRepository; // mock the dependency

    @Test
    @DisplayName("거래내역 조회 서비스 레이어 테스트")
    void searchIncomeSpending(){
        // given
        User user = UserTestUtils.createUser("hjs429", "1234", "하진수",
                "010-2632-2615", "hjs928@naver.com", UserGrade.ADMIN);

        // 카테고리 목록
        Category category1 = CategoryTestUtils.createCategory("식비", "식비 카테고리",
                "아직은 없어도 된다.", user);
        Category category2 = CategoryTestUtils.createCategory("자기개발", "자기개발 카테고리",
                "아직은 없어도 된다.", user);
        Category category3 = CategoryTestUtils.createCategory("투자수익", "투자수익 카테고리",
                "아직은 없어도 된다.", user);

        // 거래내역 데이터 목록
        IncomeSpending incomeSpending1 =
                IncomeSpendingTestUtils.createIncomeSpending
                        (DataCode.지출, "순대국밥", 10000L,user, category1);
        IncomeSpending incomeSpending2 =
                IncomeSpendingTestUtils.createIncomeSpending
                        (DataCode.지출, "권투수강", 30000L,user, category2);
        IncomeSpending incomeSpending3 = IncomeSpendingTestUtils.createIncomeSpending
                (DataCode.수입, "주식매도", 50000L,user, category3);

        // 초기 entity 객체 리스트
        List<IncomeSpending> IncomeSpendingList = Arrays.asList(
                incomeSpending1, incomeSpending2, incomeSpending3);

        // 초기 dto 객체 리스트
        List<IncomeSpendingDto> IncomeSpendingDtoList = IncomeSpendingList.stream()
                .map(m -> IncomeSpendingMapper.INSTANCE.toDto(m))
                .collect(Collectors.toList());

        // 서비스 메소드 실행 변수
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDate = LocalDateTime.now().format(formatter) + " 00:00:00";
        String endDate = LocalDateTime.now().format(formatter)+ " 23:59:59";
        String userId = "hjs429";

        // mocking
        when(incomeSpendingRepository.findDataByDateTime(anyString(), any(LocalDateTime.class),
                any(LocalDateTime.class))).thenReturn(IncomeSpendingList);
        when(userRepository.findByUserId(anyString())).thenReturn(user);

        // when
        List<IncomeSpendingDto> result = incomeSpendingService.getIncomeSpendingList(
                userId,startDate,endDate);
        List<String> contentList = IncomeSpendingDtoList.stream()
                .map(IncomeSpendingDto::getContent)
                .collect(Collectors.toList());
        ;
//        IncomeSpendingList.forEach(data -> System.out.println("entity 데이터: " + data));
//        IncomeSpendingList.forEach(data -> System.out.println("entity 데이터 생성날짜: " + data.getCreatedDate()));
//        IncomeSpendingDtoList.forEach(data -> System.out.println("초기 데이터 : " + data));
//        result.forEach(data -> System.out.println("결과 데이터 : " + data));

        //then
        assertThat(contentList).contains(
                result.get(0).getContent(),result.get(1).getContent(),result.get(2).getContent());
    }





}