package com.example.democrud.global.exception.productexception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductErrorCode {
    NOT_FOUND_PRODUCT("찾으신 제품이 존재하지 않습니다."),
    EXIST_NAME_PRODUCT("이미 등록된 제품입니다."),
    NOT_CHANGE_PRODUCT("기존과 동일한 이름입니다.")
    ;
    private final String message;
}
