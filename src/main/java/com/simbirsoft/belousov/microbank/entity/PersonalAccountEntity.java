package com.simbirsoft.belousov.microbank.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "personal_account")
public class PersonalAccountEntity {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<AccountHistoryEntity> accountHistories;

    @OneToOne(mappedBy = "account")
    private AccountDetailsEntity accountDetails;

    public PersonalAccountEntity() {
    }

    public PersonalAccountEntity(long id, String login, String password, List<AccountHistoryEntity> accountHistories, AccountDetailsEntity accountDetails) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.accountHistories = accountHistories;
        this.accountDetails = accountDetails;
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

    public List<AccountHistoryEntity> getAccountHistories() {
        return accountHistories;
    }

    public void setAccountHistories(List<AccountHistoryEntity> accountHistories) {
        this.accountHistories = accountHistories;
    }

    public AccountDetailsEntity getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(AccountDetailsEntity accountDetails) {
        this.accountDetails = accountDetails;
    }
}
