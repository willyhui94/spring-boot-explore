package com.willyhui.dataJPA.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RecordExceptionController {

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity exception(RecordNotFoundException exception) {
        Map<String, String> error = new HashMap<>();
        error.put("message", "Record not found");

        return new ResponseEntity<>(
                error,
                HttpStatus.BAD_REQUEST
        );
    }
}
