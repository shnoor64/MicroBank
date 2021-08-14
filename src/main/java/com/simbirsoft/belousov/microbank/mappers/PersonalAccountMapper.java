package com.simbirsoft.belousov.microbank.mappers;
import com.simbirsoft.belousov.microbank.entity.PersonalAccountEntity;
import org.mapstruct.Mapper;

public interface PersonalAccountMapper {
    PersonalAccountEntity personalAccountRequestDtoToEntity ();
}
