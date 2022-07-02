package com.company.exception;

public class UserExistException extends ExistException {

    private static final long serialVersionUID = 1L;

    public UserExistException(String message) {
        super(message);
    }
}
