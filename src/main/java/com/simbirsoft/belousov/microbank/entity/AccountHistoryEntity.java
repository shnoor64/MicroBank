package com.simbirsoft.belousov.microbank.entity;

import com.simbirsoft.belousov.microbank.enums.TypeOperation;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_history")
public class AccountHistoryEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account")
    private PersonalAccountEntity account;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_operation")
    private TypeOperation typeOperation;

    @Column(name = "amount_money")
    private float amountMoney;

    @Column(name = "time_operation")
    private LocalDateTime timeOperation;

    @Column(name = "description ")
    private String description;

    public AccountHistoryEntity() {
    }

    public AccountHistoryEntity(long id, PersonalAccountEntity account, TypeOperation typeOperation, float amountMoney, LocalDateTime timeOperation, String description) {
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

    public PersonalAccountEntity getAccount() {
        return account;
    }

    public void setAccount(PersonalAccountEntity account) {
        this.account = account;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public float getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(float amountMoney) {
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
