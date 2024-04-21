package com.marcos.desenvolvimento.backendkanbanagile.exception;

public class ExistingUserException extends RuntimeException {

    public ExistingUserException(){}

    public ExistingUserException(String message) {
        super(message);
    }

    public ExistingUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistingUserException(Throwable cause) {
        super(cause);
    }

}
