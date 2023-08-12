package com.example.democrud.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductErrorCode {
    NOT_FOUND_PRODUCT("찾으신 제품이 존재하지 않습니다."),
    ;
    private final String message;
}
