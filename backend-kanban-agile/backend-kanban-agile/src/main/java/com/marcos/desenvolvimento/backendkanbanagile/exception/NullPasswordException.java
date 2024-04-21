package com.marcos.desenvolvimento.backendkanbanagile.exception;

public class NullPasswordException extends RuntimeException{

    public NullPasswordException(){}

    public NullPasswordException(String message) {
        super(message);
    }

    public NullPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullPasswordException(Throwable cause) {
        super(cause);
    }

}
