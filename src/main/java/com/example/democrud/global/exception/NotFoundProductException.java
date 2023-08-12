package com.example.democrud.global.exception;

import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class NotFoundProductException extends RuntimeException{
    private ProductErrorCode productErrorCode;
    private String message;

    public NotFoundProductException(ProductErrorCode errorCode) {
        super(errorCode.getMessage());
        this.productErrorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
