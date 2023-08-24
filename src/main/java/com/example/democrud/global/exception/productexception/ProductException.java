package com.example.democrud.global.exception.productexception;

import lombok.Getter;

@Getter
public class ProductException extends RuntimeException {
    private ProductErrorCode productErrorCode;
    private String message;

    public ProductException(ProductErrorCode errorCode) {
        super(errorCode.getMessage());
        this.productErrorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
