package com.simbirsoft.belousov.microbank.rest.exceptions;

public class LowBalanceException extends RuntimeException{

    public LowBalanceException(String message) {
        super(message);
    }
}
