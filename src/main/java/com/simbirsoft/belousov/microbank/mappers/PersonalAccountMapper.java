package com.simbirsoft.belousov.microbank.mappers;

import com.simbirsoft.belousov.microbank.entity.PersonalAccountEntity;
import com.simbirsoft.belousov.microbank.rest.dto.PersonalAccountRequestDto;
import com.simbirsoft.belousov.microbank.rest.dto.PersonalAccountResponseDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface PersonalAccountMapper {

    PersonalAccountEntity personalAccountRequestDtoToEntity(PersonalAccountRequestDto personalAccountRequestDto);

    PersonalAccountResponseDto PersonalAccountEntityToResponseDto(PersonalAccountEntity personalAccountEntity);

}
