package com.marcos.desenvolvimento.backendkanbanagile.exception;

public class InvalidUserFormatException extends RuntimeException {

    public InvalidUserFormatException(){}

    public InvalidUserFormatException(String message) {
        super(message);
    }

    public InvalidUserFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUserFormatException(Throwable cause) {
        super(cause);
    }
}
