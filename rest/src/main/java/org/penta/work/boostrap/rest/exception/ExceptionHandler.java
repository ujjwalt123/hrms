package org.penta.work.boostrap.rest.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
@Slf4j
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value
      = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.CONFLICT, request);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(value
            = {SQLIntegrityConstraintViolationException.class })
    protected ResponseEntity<Object> handleJdbcSQLConflict(RuntimeException ex, WebRequest request) {
        log.info(ex.getMessage());
        String bodyOfResponse = "SQL EXCEPTION!";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(value
            = {InvalidUserException.class })
    protected ResponseEntity<Object> handleInvalidLogin(RuntimeException ex, WebRequest request) {
        log.info(ex.getMessage());
         return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}