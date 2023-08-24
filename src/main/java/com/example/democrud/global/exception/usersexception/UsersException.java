package com.example.democrud.global.exception.usersexception;


public class UsersException extends RuntimeException{

    private UsersErrorCode usersErrorCode;
    private String message;

    public UsersException(UsersErrorCode errorCode) {
        super(errorCode.getMessage());
        this.usersErrorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
