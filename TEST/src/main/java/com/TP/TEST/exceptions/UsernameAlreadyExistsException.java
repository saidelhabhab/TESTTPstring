package com.TP.TEST.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{

    public UsernameAlreadyExistsException() {
        super("Username already exists");
    }
}
