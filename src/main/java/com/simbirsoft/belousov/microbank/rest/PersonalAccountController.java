package com.simbirsoft.belousov.microbank.rest;

import com.simbirsoft.belousov.microbank.rest.dto.AccountDetailsResponseDto;
import com.simbirsoft.belousov.microbank.rest.dto.AccountHistoryResponseDto;
import com.simbirsoft.belousov.microbank.services.PersonalAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/bank/accounts")
@RestController
public class PersonalAccountController {
    private final PersonalAccountService personalAccountService;

    public PersonalAccountController(PersonalAccountService personalAccountService) {
        this.personalAccountService = personalAccountService;
    }

    @PutMapping(value = "/{description}")
    //в description скорее всего буду передавать название проекта
    public ResponseEntity<AccountDetailsResponseDto> paymentProject(@PathVariable String description) {
        AccountDetailsResponseDto result = personalAccountService.payProject(description, description);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public ResponseEntity<List<AccountHistoryResponseDto>> getAllHistory() {
        List<AccountHistoryResponseDto> results = personalAccountService.getAllHistoryAccount("Oleg");
        return ResponseEntity.ok().body(results);
    }
}
