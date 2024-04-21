package com.marcos.desenvolvimento.backendkanbanagile.exception;

public class NonexistentTaskException extends RuntimeException {

    public NonexistentTaskException(){}

    public NonexistentTaskException(String message) {
        super(message);
    }

    public NonexistentTaskException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonexistentTaskException(Throwable cause) {
        super(cause);
    }

}
