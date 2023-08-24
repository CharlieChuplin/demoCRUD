package com.example.democrud.application.service;

import com.example.democrud.api.request.productdto.RequestProductDto;
import com.example.democrud.api.response.ResponseProductDto;
import com.example.democrud.domain.product.Product;
import com.example.democrud.domain.product.ProductRepository;
import com.example.democrud.domain.users.Users;
import com.example.democrud.domain.users.UsersRepository;
import com.example.democrud.global.exception.productexception.ProductException;
import com.example.democrud.global.exception.productexception.ProductErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UsersRepository usersRepository;

    public List<ResponseProductDto> getProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> new ResponseProductDto(product))
                .collect(Collectors.toList());
    }

    public ResponseProductDto getProductById(Long id) {
        return productRepository.findById(id)
                .map(p -> new ResponseProductDto(p))
                .orElseThrow(() -> new ProductException(ProductErrorCode.NOT_FOUND_PRODUCT));
    }

    public ResponseProductDto getProductByName(String name) {
        return productRepository.findByName(name)
                .map(p -> new ResponseProductDto(p))
                .orElseThrow(() -> new ProductException(ProductErrorCode.NOT_FOUND_PRODUCT));
    }

    @Transactional
    public void registerProduct(Long userId, RequestProductDto requestProductDto) {
        productRepository.findByName(requestProductDto.getName())
                .ifPresent(p -> {throw new ProductException(ProductErrorCode.EXIST_NAME_PRODUCT);});

        Product newProduct = new Product(requestProductDto);

        Users users = usersRepository.findById(userId).get();
        users.registerProduct(newProduct);

        productRepository.save(newProduct);
    }

    @Transactional
    public void modifyProduct(Long id, RequestProductDto requestProductDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductException(ProductErrorCode.NOT_FOUND_PRODUCT));
        if (product.getName().equals(requestProductDto.getName())) {
            throw new ProductException(ProductErrorCode.NOT_CHANGE_PRODUCT);
        }
        product.modify(requestProductDto);
    }

    @Transactional
    public void removeProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductException(ProductErrorCode.NOT_FOUND_PRODUCT));
        productRepository.delete(product);
    }
}
