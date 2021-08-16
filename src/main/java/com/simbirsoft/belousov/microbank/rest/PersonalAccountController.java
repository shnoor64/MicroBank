package com.simbirsoft.belousov.microbank.rest;

import com.simbirsoft.belousov.microbank.rest.dto.AccountDetailsResponseDto;
import com.simbirsoft.belousov.microbank.rest.dto.AccountHistoryResponseDto;
import com.simbirsoft.belousov.microbank.services.PersonalAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RequestMapping("/api/bank/accounts")
@RestController
public class PersonalAccountController {
    private static final Logger LOG = Logger.getLogger(PersonalAccountController.class.getName());
    private final PersonalAccountService personalAccountService;

    public PersonalAccountController(PersonalAccountService personalAccountService) {
        this.personalAccountService = personalAccountService;
    }

    @PostMapping(value = "/{description}")
    //в description скорее всего буду передавать название проекта
    public ResponseEntity<AccountDetailsResponseDto> paymentProject(@PathVariable String description) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = null;
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            userDetails = (UserDetails) auth.getPrincipal();
        }
        LOG.log(Level.INFO, "Вызван метод: paymentProject "+"login:"+userDetails.getUsername());
        AccountDetailsResponseDto result = personalAccountService.payProject(userDetails.getUsername(), description);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public ResponseEntity<List<AccountHistoryResponseDto>> getAllHistory() {
        LOG.log(Level.INFO, "Запрос: \"Получить всю историю операций\" /api/bank/accounts");

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String userDetails = null;
//        if (!(auth instanceof AnonymousAuthenticationToken)) {
//            userDetails = (String) auth.getPrincipal();
//        }
        List<AccountHistoryResponseDto> results = personalAccountService.getAllHistoryAccount("oleg");
        return ResponseEntity.ok().body(results);
    }
}
