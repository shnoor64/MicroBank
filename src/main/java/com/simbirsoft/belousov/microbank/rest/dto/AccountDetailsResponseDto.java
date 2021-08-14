package com.simbirsoft.belousov.microbank.rest.dto;

public class AccountDetailsResponseDto {

    private long id;

    private long account;

    private String fullName;

    private float balance;

    public AccountDetailsResponseDto() {
    }

    public AccountDetailsResponseDto(long id, long account, String fullName, float balance) {
        this.id = id;
        this.account = account;
        this.fullName = fullName;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
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
}
