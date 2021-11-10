package com.Safetynet.Exceptions;

import com.Safetynet.Exceptions.CustomExceptions.FirestationNotFoundExceptions;
import com.Safetynet.Exceptions.CustomExceptions.MedicalRecordsNotFoundException;
import com.Safetynet.Exceptions.CustomExceptions.PersonNotFoundException;
import com.Safetynet.Model.CustomErrorResponse;
import com.Safetynet.Model.MedicalRecords;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionsHandler {
    private static final Logger logger = LogManager.getLogger(ExceptionsHandler.class);

    @ExceptionHandler(FirestationNotFoundExceptions.class)
    public ResponseEntity<Object> handleFirestationNotFoundExceptions(FirestationNotFoundExceptions e){
        logger.error("Firestation Not Found");
        CustomErrorResponse res = new CustomErrorResponse(e.getMessage(),e, HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Object> handlePersonNotFoundExceptions(PersonNotFoundException e){
        logger.error("Person Not Found");
        CustomErrorResponse res = new CustomErrorResponse(e.getMessage(),e, HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MedicalRecordsNotFoundException.class)
    public ResponseEntity<Object> handleMedicalRecordsNotFoundExceptions(MedicalRecordsNotFoundException e){
        logger.error("MedicalRecord Not Found");
        CustomErrorResponse res = new CustomErrorResponse(e.getMessage(),e, HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
    }
}
