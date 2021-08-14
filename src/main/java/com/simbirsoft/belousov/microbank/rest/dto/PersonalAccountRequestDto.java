package com.simbirsoft.belousov.microbank.rest.dto;

public class PersonalAccountRequestDto {
    private long id;

    private String login;

    private String password;

    public PersonalAccountRequestDto() {
    }

    public PersonalAccountRequestDto(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
