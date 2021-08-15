package com.simbirsoft.belousov.microbank.rest.dto;

import com.simbirsoft.belousov.microbank.enums.TypeOperation;

public class PaymentDetailsRequestDto {
    private float money;

    private String projectName;

    private TypeOperation typeOperation;

    public PaymentDetailsRequestDto() {
    }

    public PaymentDetailsRequestDto(float money, String projectName, TypeOperation typeOperation) {
        this.money = money;
        this.projectName = projectName;
        this.typeOperation = typeOperation;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }
}
