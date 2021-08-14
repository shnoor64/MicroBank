package com.simbirsoft.belousov.microbank.rest.dto;

public class PersonalAccountResponseDto {
    private long id;

    private String fullName;

    private float balance;

    public PersonalAccountResponseDto() {
    }

    public PersonalAccountResponseDto(long id, String fullName, float balance) {
        this.id = id;
        this.fullName = fullName;
        this.balance = balance;
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
}
