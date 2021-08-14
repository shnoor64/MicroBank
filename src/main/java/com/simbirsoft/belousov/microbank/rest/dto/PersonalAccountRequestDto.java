package com.simbirsoft.belousov.microbank.rest.dto;

import com.simbirsoft.belousov.microbank.entity.AccountHistory;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class PersonalAccountRequestDto {
    private long id;

    private String fullName;

    private float balance;

    private String login;

    private String password;

    public PersonalAccountRequestDto() {
    }

    public PersonalAccountRequestDto(long id, String fullName, float balance, String login, String password) {
        this.id = id;
        this.fullName = fullName;
        this.balance = balance;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
