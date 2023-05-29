package com.poscodx.economy.mapper;

import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.dto.IncomeSpendingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper
public interface IncomeSpendingMapper {

    IncomeSpendingMapper INSTANCE = Mappers.getMapper(IncomeSpendingMapper.class);
//    @Mapping(source = "name", target = "item.name")
//    @Mapping(source = "count", target = "item.count")
//    @Mapping(source = "userId", target = "user.userId")
//    Order toEntity(OrderDto dto);

    @Mapping(source = "category.categoryCom.name", target = "categoryName")
    @Mapping(source = "category.createdDate", target = "createdDate", qualifiedByName = "formatDateToString")
    IncomeSpendingDto toDto(IncomeSpending entity);

    @Named("formatDateToString")
    default String formatDateToString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return localDateTime != null ? localDateTime.format(formatter) : null;
    }

}
