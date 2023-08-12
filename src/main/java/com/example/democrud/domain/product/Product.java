package com.example.democrud.domain.product;

import com.example.democrud.api.request.RequestProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer amount;

    private Integer price;

    public Product(RequestProductDto requestProductDto) {
        this.name = requestProductDto.name();
        this.amount = requestProductDto.amount();
        this.price = requestProductDto.price();
    }
    public void modify(RequestProductDto requestProductDto) {
        this.name = requestProductDto.name();
        this.amount = requestProductDto.amount();
        this.price = requestProductDto.price();
    }
}
