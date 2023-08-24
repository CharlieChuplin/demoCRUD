package com.example.democrud.api.request.userdto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestFindUserDto {

    @NotNull(message = "찾으실 이름을 입력해주세요.")
    private String userName;
}
