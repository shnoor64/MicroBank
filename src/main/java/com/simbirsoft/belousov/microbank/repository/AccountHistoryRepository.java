package com.simbirsoft.belousov.microbank.repository;

import com.simbirsoft.belousov.microbank.entity.AccountHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHistoryRepository extends JpaRepository<AccountHistory, Integer> {
}
