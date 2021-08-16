package com.simbirsoft.belousov.microbank.entity;

import javax.persistence.*;

@Entity
@Table(name = "personal_account")
public class AccountDetailsEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account")
    private PersonalAccountEntity account;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "balance")
    private float balance;

    public AccountDetailsEntity() {
    }

    public AccountDetailsEntity(long id, PersonalAccountEntity account, String fullName, float balance) {
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

    public PersonalAccountEntity getAccount() {
        return account;
    }

    public void setAccount(PersonalAccountEntity account) {
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
