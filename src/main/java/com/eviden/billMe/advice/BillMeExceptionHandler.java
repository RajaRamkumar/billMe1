package com.eviden.billMe.advice;

import com.eviden.billMe.common.BillMeErrorCode;
import com.eviden.billMe.common.BillMeErrorResponse;
import com.eviden.billMe.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BillMeExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity userNotFoundException(UserNotFoundException ex){
        BillMeErrorResponse billMeErrorResponse = BillMeErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .errorCode(BillMeErrorCode.INVALID_USER)
                .errorMessage(ex.getMessage())
                .build();
        return ResponseEntity.status(401).body(billMeErrorResponse);
    }
}
