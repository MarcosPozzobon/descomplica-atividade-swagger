package com.marcos.desenvolvimento.backendkanbanagile.exception;

public class NonexistentUserException extends RuntimeException{

    public NonexistentUserException(){}

    public NonexistentUserException(String message) {
        super(message);
    }

    public NonexistentUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonexistentUserException(Throwable cause) {
        super(cause);
    }

}
