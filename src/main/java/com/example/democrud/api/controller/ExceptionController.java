package com.example.democrud.api.controller;

import com.example.democrud.api.response.ResponseError;
import com.example.democrud.global.exception.productexception.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseError validationException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ResponseError(message, "VALIDATION_ERROR");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductException.class)
    public ResponseError productError(ProductException e) {
        return new ResponseError(e.getMessage(), e.getProductErrorCode().toString());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseError handleException(Exception e) {
        return new ResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }

}
