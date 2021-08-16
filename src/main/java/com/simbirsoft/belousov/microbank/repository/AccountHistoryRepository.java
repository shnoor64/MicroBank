package com.simbirsoft.belousov.microbank.repository;

import com.simbirsoft.belousov.microbank.entity.AccountHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHistoryRepository extends JpaRepository<AccountHistoryEntity, Long> {
}
