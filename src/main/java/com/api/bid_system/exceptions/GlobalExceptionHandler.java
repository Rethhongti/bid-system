package com.api.bid_system.exceptions;

import com.api.bid_system.common.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> apiExceptionResponse(RuntimeException e) {
        HttpStatus status;
        if (e instanceof NotFoundException){
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        ExceptionResponse response = new ExceptionResponse(status, e.getMessage());
        return ResponseEntity.status(status).body(response);
    }
}
