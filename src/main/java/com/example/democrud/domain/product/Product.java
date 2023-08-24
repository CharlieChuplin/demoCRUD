package com.example.democrud.domain.product;

import com.example.democrud.api.request.productdto.RequestProductDto;
import com.example.democrud.domain.users.Users;
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

    @ManyToOne(fetch = FetchType.LAZY)
    public Users users;

    public Product(RequestProductDto requestProductDto) {
        this.name = requestProductDto.getName();
        this.amount = requestProductDto.getAmount();
        this.price = requestProductDto.getPrice();
    }
    public void modify(RequestProductDto requestProductDto) {
        this.name = requestProductDto.getName();
        this.amount = requestProductDto.getAmount();
        this.price = requestProductDto.getPrice();
    }

    public void registerByUsers(Users users) {
        this.users = users;
    }
}
