package com.simbirsoft.belousov.microbank.repository;

import com.simbirsoft.belousov.microbank.entity.AccountHistory;
import com.simbirsoft.belousov.microbank.entity.PersonalAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalAccountRepository extends JpaRepository<PersonalAccount, Integer> {
}
