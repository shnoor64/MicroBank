package com.simbirsoft.belousov.microbank.rest.exceptions;

public class NoSuchException extends RuntimeException {
    public NoSuchException(String message) {
        super(message);
    }
}
