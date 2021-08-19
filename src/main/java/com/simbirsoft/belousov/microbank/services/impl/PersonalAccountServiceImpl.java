package com.simbirsoft.belousov.microbank.services.impl;

import com.simbirsoft.belousov.microbank.entity.AccountHistoryEntity;
import com.simbirsoft.belousov.microbank.entity.PersonalAccountEntity;
import com.simbirsoft.belousov.microbank.enums.TypeOperation;
import com.simbirsoft.belousov.microbank.mappers.AccountDetailsMapper;
import com.simbirsoft.belousov.microbank.mappers.AccountHistoryMapper;
import com.simbirsoft.belousov.microbank.repository.AccountDetailsRepository;
import com.simbirsoft.belousov.microbank.repository.AccountHistoryRepository;
import com.simbirsoft.belousov.microbank.repository.PersonalAccountRepository;
import com.simbirsoft.belousov.microbank.rest.dto.AccountDetailsResponseDto;
import com.simbirsoft.belousov.microbank.rest.dto.AccountHistoryResponseDto;
import com.simbirsoft.belousov.microbank.rest.exeption_handing.LowBalanceException;
import com.simbirsoft.belousov.microbank.services.PersonalAccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonalAccountServiceImpl implements PersonalAccountService {
    @Value("${price}")
    private Long pr;
    private final AccountDetailsRepository accountDetailsRepository;
    private final PersonalAccountRepository personalAccountRepository;
    private final AccountHistoryRepository accountHistoryRepository;
    private final AccountHistoryMapper accountHistoryMapper;
    private final AccountDetailsMapper accountDetailsMapper;

    public PersonalAccountServiceImpl(AccountDetailsRepository accountDetailsRepository, PersonalAccountRepository personalAccountRepository, AccountHistoryRepository accountHistoryRepository, AccountHistoryMapper accountHistoryMapper, AccountDetailsMapper accountDetailsMapper) {
        this.accountDetailsRepository = accountDetailsRepository;
        this.personalAccountRepository = personalAccountRepository;
        this.accountHistoryRepository = accountHistoryRepository;
        this.accountHistoryMapper = accountHistoryMapper;
        this.accountDetailsMapper = accountDetailsMapper;
    }
    @Transactional
    @Override
    public AccountDetailsResponseDto payProject(String login, String description) {
        PersonalAccountEntity personalAccountEntity = personalAccountRepository.findByLogin(login);
        if (personalAccountEntity.getAccountDetails().getBalance() < pr) {
            throw new LowBalanceException("Недостаточно средств");
        }
        personalAccountEntity.getAccountDetails().setBalance(personalAccountEntity.getAccountDetails().getBalance() - pr);
//        personalAccountRepository.save(personalAccountEntity);
        accountHistoryRepository.save(new AccountHistoryEntity(personalAccountEntity, TypeOperation.PAYMENT, pr, LocalDateTime.now(), description));
        return accountDetailsMapper.AccountDetailsEntityToResponseDto(personalAccountEntity.getAccountDetails());

    }
    @Transactional
    @Override
    public List<AccountHistoryResponseDto> getAllHistoryAccount(String login) {
        List<AccountHistoryResponseDto> accountHistoryResponseDtoList = new ArrayList<>();
        List<AccountHistoryEntity> accountHistoryEntityList = accountHistoryRepository.findByAccount_Id(personalAccountRepository.findByLogin(login).getId());
        return accountHistoryEntityList
                .stream()
                .map(accountHistoryEntity -> accountHistoryMapper.accountHistoryEntityToResponseDto(accountHistoryEntity))
                .collect(Collectors.toList());
    }
}
