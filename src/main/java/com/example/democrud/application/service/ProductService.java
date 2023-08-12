package com.example.democrud.application.service;

import com.example.democrud.api.request.RequestProductDto;
import com.example.democrud.api.response.ResponseProductDto;
import com.example.democrud.domain.product.Product;
import com.example.democrud.domain.product.ProductRepository;
import com.example.democrud.global.exception.NotFoundProductException;
import com.example.democrud.global.exception.ProductErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ResponseProductDto> getProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> new ResponseProductDto(product))
                .collect(Collectors.toList());
    }

    public ResponseProductDto getProductById(Long id) {
        return productRepository.findById(id)
                .map(p -> new ResponseProductDto(p))
                .orElseThrow(() -> new NotFoundProductException(ProductErrorCode.NOT_FOUND_PRODUCT));
    }

    public ResponseProductDto getProductByName(String name) {
        return productRepository.findByName(name)
                .map(p -> new ResponseProductDto(p))
                .orElseThrow(() -> new NotFoundProductException(ProductErrorCode.NOT_FOUND_PRODUCT));
    }

    @Transactional
    public void registerProduct(RequestProductDto requestProductDto) {
        productRepository.save(new Product(requestProductDto));
    }

    @Transactional
    public void modifyProduct(Long id, RequestProductDto requestProductDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundProductException(ProductErrorCode.NOT_FOUND_PRODUCT));
        product.modify(requestProductDto);
    }

    @Transactional
    public void removeProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundProductException(ProductErrorCode.NOT_FOUND_PRODUCT));
        productRepository.delete(product);
    }
}
