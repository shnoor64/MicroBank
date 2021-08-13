package com.simbirsoft.belousov.microbank.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "personal_account")
public class PersonalAccount {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "balance")
    private float balance;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<AccountHistory> accountHistories;

    public PersonalAccount() {
    }

    public PersonalAccount(long id, String fullName, float balance, String login, String password) {
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
