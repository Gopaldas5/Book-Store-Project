package com.bridgelabz.bookstoreproject.exception;

import com.bridgelabz.bookstoreproject.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResponseDTO> handlerNonExistingId(CustomException customException){
        ResponseDTO responseDTO = new ResponseDTO("Exception while parsing Rest Request", customException.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
