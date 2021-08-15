package com.simbirsoft.belousov.microbank.services;

import com.simbirsoft.belousov.microbank.entity.PersonalAccountEntity;
import com.simbirsoft.belousov.microbank.repository.PersonalAccountRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class PersonalAccountDetailsService implements UserDetailsService {

    private PersonalAccountRepository personalAccountRepository;

    public PersonalAccountDetailsService(PersonalAccountRepository personalAccountRepository) {
        this.personalAccountRepository = personalAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        PersonalAccountEntity personalAccountEntity = personalAccountRepository.findByLogin(login);
        if (login == null) {
            throw new UsernameNotFoundException("Логин не найден");
        }
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
        return new User(personalAccountEntity.getLogin(),personalAccountEntity.getPassword(),authorities);
    }
}
