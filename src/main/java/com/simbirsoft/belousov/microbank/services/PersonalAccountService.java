package com.simbirsoft.belousov.microbank.services;

import com.simbirsoft.belousov.microbank.rest.dto.AccountHistoryRequestDto;
import com.simbirsoft.belousov.microbank.rest.dto.AccountHistoryResponseDto;
import com.simbirsoft.belousov.microbank.rest.dto.PaymentDetailsRequestDto;

public interface PersonalAccountService {
    void payProject(PaymentDetailsRequestDto paymentDetailsRequestDto);

    AccountHistoryResponseDto getAllHistoryAccount(AccountHistoryRequestDto accountHistoryRequestDto);
}
