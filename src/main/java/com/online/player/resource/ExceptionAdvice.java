package com.online.player.resource;

import com.online.player.dto.ErrorResponse;
import com.online.player.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by ikota on 9.6.17.
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> entityNotFoundExceptionHandler(EntityNotFoundException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), e.status), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> entityNullPointerException(NullPointerException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), 409), HttpStatus.CONFLICT);
    }

}
