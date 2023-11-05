package com.poscodx.economy.mapper;

import com.poscodx.economy.domain.IncomeSpending;
import com.poscodx.economy.dto.IncomeSpendingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Mapper
public interface IncomeSpendingMapper {

    IncomeSpendingMapper INSTANCE = Mappers.getMapper(IncomeSpendingMapper.class);
//    @Mapping(source = "name", target = "item.name")
//    @Mapping(source = "count", target = "item.count")
//    @Mapping(source = "userId", target = "user.userId")
//    Order toEntity(OrderDto dto);

    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "transactionDate", target = "transactionDate", qualifiedByName = "formatDateToString")
    @Mapping(source = "user.userId", target = "userId")
    IncomeSpendingDto toDto(IncomeSpending entity);


    @Mapping(source = "categoryName", target = "category.name")
    @Mapping(source = "transactionDate", target = "transactionDate", qualifiedByName = "formatStringToDate")
    @Mapping(source = "userId", target = "user.userId")
    IncomeSpending toEntity(IncomeSpendingDto dto);

    @Named("formatDateToString")
    default String formatDateToString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime != null ? localDateTime.format(formatter) : null;
    }

    @Named("formatStringToDate")
    default LocalDateTime formatStringToDate(String stringData) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return stringData != null ? LocalDateTime.parse(stringData, formatter) : null;
    }

}
