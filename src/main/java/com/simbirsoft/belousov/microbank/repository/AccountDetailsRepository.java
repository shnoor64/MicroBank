package com.simbirsoft.belousov.microbank.repository;

import com.simbirsoft.belousov.microbank.entity.AccountDetailsEntity;
import com.simbirsoft.belousov.microbank.entity.PersonalAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetailsEntity, Long> {
}
