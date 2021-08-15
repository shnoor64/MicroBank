package com.simbirsoft.belousov.microbank.rest.exeption_handing;

public class LowBalance extends RuntimeException{

    public LowBalance(String message) {
        super(message);
    }
}
