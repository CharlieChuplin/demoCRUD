package com.example.democrud.api.response;

import com.example.democrud.domain.product.Product;

public record ResponseProductDto(String name,
                                 Integer price,
                                 Integer amount) {

    public ResponseProductDto(Product entity) {
        this(entity.getName(), entity.getPrice(), entity.getAmount());
    }

}
