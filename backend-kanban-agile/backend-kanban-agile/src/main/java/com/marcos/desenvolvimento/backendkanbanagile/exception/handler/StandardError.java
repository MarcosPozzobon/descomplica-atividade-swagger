package com.marcos.desenvolvimento.backendkanbanagile.exception.handler;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StandardError {

    private LocalDateTime timestamp;

    private int status;

    private String error;

    private String message;

    private String path;

}
