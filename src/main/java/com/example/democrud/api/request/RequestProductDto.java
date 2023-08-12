package com.example.democrud.api.request;


import com.example.democrud.domain.product.Product;

public record RequestProductDto(String name,
                                Integer amount,
                                Integer price) {

    public RequestProductDto(Product entity) {
        this(entity.getName(),
             entity.getAmount(),
             entity.getPrice());
    }
}

