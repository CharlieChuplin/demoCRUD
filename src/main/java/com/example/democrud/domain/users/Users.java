package com.example.democrud.domain.users;

import com.example.democrud.domain.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String pwd;

    @Column(nullable = false)
    private String userName;

    @Column
    @OneToMany(mappedBy = "users")
    private List<Product> products = new ArrayList<>();

    public void registerProduct(Product product) {
        this.products.add(product);
        product.registerByUsers(this);
    }

    @Builder
    public Users(String email, String pwd, String userName) {
        this.email = email;
        this.pwd = pwd;
        this.userName = userName;
    }



}
