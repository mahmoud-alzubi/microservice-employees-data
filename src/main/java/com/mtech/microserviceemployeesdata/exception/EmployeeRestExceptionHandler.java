package com.mtech.microserviceemployeesdata.exception;

import com.mtech.microserviceemployeesdata.rest.EmployeeErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.concurrent.ExecutionException;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());


    ////////////////////////////////////////////////////////////

    /**
     * @param e
     * @return
     */
    @ExceptionHandler
    ResponseEntity<?> handleException(EmployeeNotFoundException e) {
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        logger.error(errorResponse.toString());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    ////////////////////////////////////////////////////////////

    /**
     * @param e
     * @return
     */
    @ExceptionHandler
    ResponseEntity<?> handleException(Exception e) {
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        logger.warn(errorResponse.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
