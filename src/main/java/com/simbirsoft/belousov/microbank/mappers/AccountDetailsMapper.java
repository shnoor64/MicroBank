package com.simbirsoft.belousov.microbank.mappers;

import com.simbirsoft.belousov.microbank.entity.AccountDetailsEntity;
import com.simbirsoft.belousov.microbank.repository.PersonalAccountRepository;
import com.simbirsoft.belousov.microbank.rest.dto.AccountDetailsRequestDto;
import com.simbirsoft.belousov.microbank.rest.dto.AccountDetailsResponseDto;
import com.simbirsoft.belousov.microbank.rest.exceptions.NoSuchException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public abstract class AccountDetailsMapper {

    @Autowired
    protected PersonalAccountRepository personalAccountRepository;

    @Mappings({
            @Mapping(target = "account", expression = "java(personalAccountRepository.findById(accountDetailsRequestDto.getAccount()).orElseThrow(() -> new NoSuchException(\"Аккаунт не найден\")))")
    })
    public abstract AccountDetailsEntity accountDetailsRequestDtoToEntity(AccountDetailsRequestDto accountDetailsRequestDto) throws NoSuchException;

//    @Mappings({
//            @Mapping(target = "account", expression = "java(accountDetailsEntity.getAccount().getId())")
//    })
    public abstract AccountDetailsResponseDto AccountDetailsEntityToResponseDto(AccountDetailsEntity accountDetailsEntity) throws NoSuchException;

}
