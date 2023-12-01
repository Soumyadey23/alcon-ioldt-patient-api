package com.alcon.patient.aop;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.alcon.patient.exception.CardLabelException;

@ControllerAdvice
public class GlobalExceptionHandler {
   
    
    @ExceptionHandler(IOException.class)
    public ResponseEntity<?> ioException(IOException ex, WebRequest request) {
         return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
    @ExceptionHandler(CardLabelException.class)
    public ResponseEntity<?> cardLabelExcpetionHandler(CardLabelException ex, WebRequest request) {
        
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
}
