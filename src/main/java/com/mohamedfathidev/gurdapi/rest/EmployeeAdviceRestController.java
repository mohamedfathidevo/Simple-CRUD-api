package com.mohamedfathidev.gurdapi.rest;

import com.mohamedfathidev.gurdapi.util.EmployeeErrorResponse;
import com.mohamedfathidev.gurdapi.util.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeAdviceRestController {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc){
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

}
