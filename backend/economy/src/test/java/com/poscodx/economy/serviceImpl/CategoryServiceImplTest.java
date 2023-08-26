package com.poscodx.economy.serviceImpl;

import com.poscodx.economy.dto.CategoryDto;
import com.poscodx.economy.repository.jpa.CategoryRepository;
import com.poscodx.economy.repository.jpa.UserRepository;
import com.querydsl.core.Tuple;
import org.javatuples.Triplet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl categoryService; // the service we're testing

    @Mock
    private CategoryRepository categoryRepository; // mock the dependency
    @Mock
    private UserRepository userRepository; // mock the dependency

    private CategoryDto createCategory(String detailCategoryName,
                                       String categoryName, String paymentData) {
        CategoryDto categoryDto =
                new CategoryDto().builder()
                        .categoryName(categoryName)
                        .detailCategoryName(detailCategoryName)
                        .paymentData(paymentData)
                        .build();
        return categoryDto;
    }

    @Test
    @DisplayName("유저별 카테고리 데이터 테스트")
    void categoryTest() {
        String userId = ("hjs429");

        // 테스트용 튜플 리스트
        List<Tuple> tupleList = new ArrayList<>();

//        StringPath categoryPath = Expressions.stringPath("categoryName");
//        StringPath detailCategoryPath = Expressions.stringPath("detailCategoryName");
//        StringPath paymentDataPath = Expressions.stringPath("paymentData");

        // create the expressions array
//        Expression[] expressions = new Expression[]{categoryPath, detailCategoryPath, paymentDataPath};

        List<Triplet> tuples = new ArrayList<>();

        Triplet<String, String, String> tuple1 = Triplet.with("식비", "개인식비", "선달국밥");
        Triplet<String, String, String> tuple2 = Triplet.with("자기개발", "운동", "퀸복싱클럽");
        Triplet<String, String, String> tuple3 = Triplet.with("투자수익", "회사월급", "포스코dx");

        tuples.add(tuple1);
        tuples.add(tuple2);
        tuples.add(tuple3);

//        tuples.forEach(data -> tupleList.add(data));

        // 카테고리 데이터 목록
        CategoryDto categoryDto1 =
                createCategory("식비", "개인식비", "선달국밥");
        CategoryDto categoryDto2 =
                createCategory("자기개발", "운동", "퀸복싱클럽");
        CategoryDto categoryDto3 =
                createCategory("투자수익", "회사월급", "포스코dx");
//
        // 카테고리 데이터 리스트
        List<CategoryDto> categoryDtoList = Arrays.asList(
                categoryDto1, categoryDto2, categoryDto3);

        // mocking
//        when(categoryRepository.findAllCategory(anyString())).thenReturn(tuples);

        List<CategoryDto> resultList = categoryService.getCategoryList(userId);
    }



}
