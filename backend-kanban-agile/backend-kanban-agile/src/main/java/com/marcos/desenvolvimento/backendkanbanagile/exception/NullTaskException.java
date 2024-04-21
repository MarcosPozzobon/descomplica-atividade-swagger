package com.marcos.desenvolvimento.backendkanbanagile.exception;

public class NullTaskException extends RuntimeException{

    public NullTaskException(){}

    public NullTaskException(String message) {
        super(message);
    }

    public NullTaskException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullTaskException(Throwable cause) {
        super(cause);
    }

}
