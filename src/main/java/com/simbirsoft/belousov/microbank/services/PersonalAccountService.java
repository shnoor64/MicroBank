package com.simbirsoft.belousov.microbank.services;

import com.simbirsoft.belousov.microbank.enums.TypeOperation;
import com.simbirsoft.belousov.microbank.rest.dto.AccountDetailsResponseDto;
import com.simbirsoft.belousov.microbank.rest.dto.AccountHistoryRequestDto;
import com.simbirsoft.belousov.microbank.rest.dto.AccountHistoryResponseDto;
import com.simbirsoft.belousov.microbank.rest.dto.PaymentDetailsRequestDto;

import java.util.List;

public interface PersonalAccountService {
    //    void payProject(PaymentDetailsRequestDto paymentDetailsRequestDto);
    AccountDetailsResponseDto payProject(String login, String description);

    List<AccountHistoryResponseDto> getAllHistoryAccount(String login);
}
