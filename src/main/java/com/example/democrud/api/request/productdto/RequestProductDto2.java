package com.example.democrud.api.request.productdto;


import com.example.democrud.domain.product.Product;

public record RequestProductDto2(String name,
                                 Integer amount,
                                 Integer price) {

    public RequestProductDto2(Product entity) {
        this(entity.getName(),
             entity.getAmount(),
             entity.getPrice());
    }
}

