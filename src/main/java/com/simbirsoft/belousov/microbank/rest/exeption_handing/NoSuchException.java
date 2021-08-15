package com.simbirsoft.belousov.microbank.rest.exeption_handing;

public class NoSuchException extends RuntimeException {
    public NoSuchException(String message) {
        super(message);
    }
}
