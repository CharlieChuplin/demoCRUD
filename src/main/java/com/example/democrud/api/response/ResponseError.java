package com.example.democrud.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseError {
    String message;
    String errorCode;
}
