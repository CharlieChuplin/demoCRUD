package com.example.democrud.api.request.productdto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
public class RequestProductDto {

    @NotNull(message = "입력된 값이 없습니다.")
    @Size(min = 2, max = 20, message = "최소 2자, 최대 20자로 입력해주세요.")
    private String name;

    @NotNull(message = "입력된 값이 없습니다.")
    @PositiveOrZero(message = "음수는 등록 되지 않습니다.")
    private Integer amount;

    @NotNull(message = "입력된 값이 없습니다.")
    @Min(value = 1000, message = "상품가격이 1000원 이상이어야 합니다.")
    private Integer price;
}
