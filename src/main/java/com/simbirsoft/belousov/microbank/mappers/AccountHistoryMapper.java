package com.simbirsoft.belousov.microbank.mappers;

import com.simbirsoft.belousov.microbank.entity.AccountHistoryEntity;
import com.simbirsoft.belousov.microbank.repository.PersonalAccountRepository;
import com.simbirsoft.belousov.microbank.rest.dto.AccountHistoryRequestDto;
import com.simbirsoft.belousov.microbank.rest.dto.AccountHistoryResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public abstract class AccountHistoryMapper {

    @Autowired
    protected PersonalAccountRepository personalAccountRepository;

    @Mappings({
            @Mapping(target = "account", expression = "java(personalAccountRepository.findById(accountDetailsRequestDto.getAccount()).orElseThrow(() -> new NoSuchException(\"Аккаунт не найден\")))")
    })
    public abstract AccountHistoryEntity accountHistoryRequestDtoToEntity(AccountHistoryRequestDto accountHistoryRequestDto);

    @Mappings({
            @Mapping(target = "account", expression = "java(accountHistoryEntity.getAccount().getId())")
    })
    public abstract AccountHistoryResponseDto accountHistoryEntityToResponseDto(AccountHistoryEntity accountHistoryEntity);
}