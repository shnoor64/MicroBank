package com.simbirsoft.belousov.microbank.rest.exeption_handing;

public class LowBalanceException extends RuntimeException{

    public LowBalanceException(String message) {
        super(message);
    }
}
