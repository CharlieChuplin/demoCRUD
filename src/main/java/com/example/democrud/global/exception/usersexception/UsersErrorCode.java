package com.example.democrud.global.exception.usersexception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UsersErrorCode {
    NOT_FOUND_USER("존재하지 않는 회원 존재하지 않습니다."),
    EXIST_NAME_USER("이미 등록된 회원 입니다."),
    ;
    private final String message;
}
