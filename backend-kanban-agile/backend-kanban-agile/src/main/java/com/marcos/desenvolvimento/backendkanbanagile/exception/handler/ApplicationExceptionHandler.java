package com.marcos.desenvolvimento.backendkanbanagile.exception.handler;


import com.marcos.desenvolvimento.backendkanbanagile.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(InvalidUserFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<StandardError> handleNullUserException(InvalidUserFormatException ex) {
        StandardError error = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(ex.getMessage())
                .path("/users")
                .build();
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ExistingUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<StandardError> handleExistingUserException(ExistingUserException exception){
        StandardError existingUserError = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(exception.getMessage())
                .path("/users/salvar-novo-usuario")
                .build();
        return ResponseEntity.badRequest().body(existingUserError);
    }

    @ExceptionHandler(NonexistentUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<StandardError> handleNonexistentUserException(NonexistentUserException exception){
        StandardError existingUserError = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(exception.getMessage())
                .path("/users/salvar-novo-usuario")
                .build();
        return ResponseEntity.badRequest().body(existingUserError);
    }

    @ExceptionHandler(NullTaskException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<StandardError> handleNullTaskException(NullTaskException exception){
        StandardError existingUserError = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message(exception.getMessage())
                .path("/tasks/task?")
                .build();
        return ResponseEntity.badRequest().body(existingUserError);
    }

    @ExceptionHandler(NonexistentTaskException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<StandardError> handleNonexistentTask(NonexistentTaskException exception){
        StandardError nonExistingTask = StandardError
                .builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad request")
                .message("A task existe em nossa base de dados.")
                .path("/tasks/encontrar-por-id")
                .build();
        return ResponseEntity.badRequest().body(nonExistingTask);
    }

}
