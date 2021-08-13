package com.simbirsoft.belousov.microbank.entity;

import com.simbirsoft.belousov.microbank.enums.TypeOperation;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

@Table(name = "account_history")
public class AccountHistory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account")
    private PersonalAccount account;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_operation")
    private TypeOperation typeOperation;

    @Column(name = "amount_money")
    private String amountMoney;

    @Column(name = "time_operation")
    private LocalDateTime timeOperation;

    @Column(name = "description ")
    private String description;

    public AccountHistory() {
    }

    public AccountHistory(long id, PersonalAccount account, TypeOperation typeOperation, String amountMoney, LocalDateTime timeOperation, String description) {
        this.id = id;
        this.account = account;
        this.typeOperation = typeOperation;
        this.amountMoney = amountMoney;
        this.timeOperation = timeOperation;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PersonalAccount getAccount() {
        return account;
    }

    public void setAccount(PersonalAccount account) {
        this.account = account;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public String getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(String amountMoney) {
        this.amountMoney = amountMoney;
    }

    public LocalDateTime getTimeOperation() {
        return timeOperation;
    }

    public void setTimeOperation(LocalDateTime timeOperation) {
        this.timeOperation = timeOperation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
