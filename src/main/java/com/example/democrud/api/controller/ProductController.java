package com.example.democrud.api.controller;

import com.example.democrud.api.request.RequestProductDto;
import com.example.democrud.api.response.ResponseProductDto;
import com.example.democrud.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ResponseProductDto>> getProducts() {
        log.info("GET / getProducts ");
        List<ResponseProductDto> products = productService.getProducts();
        return new ResponseEntity<>(products, OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ResponseProductDto> getProductById(@PathVariable Long id) {
        log.info("GET / getProductOne");
        ResponseProductDto product = productService.getProductById(id);
        return new ResponseEntity<>(product, OK);
    }

    @GetMapping("/products/search/{name}")
    public ResponseEntity<ResponseProductDto> getProductByName(@PathVariable String name) {
        log.info("GET / getProductOne");
        ResponseProductDto product = productService.getProductByName(name);
        return new ResponseEntity<>(product, OK);
    }

    @PostMapping("/products")
    public ResponseEntity<?> registerProduct(@RequestBody RequestProductDto requestProductDto) {
        log.info("POST / registerProduct : {}", requestProductDto);
        productService.registerProduct(requestProductDto);
        return new ResponseEntity<>(CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> modifyProduct(@PathVariable Long id, @RequestBody RequestProductDto requestProductDto) {
        log.info("PUT / modifyProduct : id -> {}");
        log.info("PUT / modifyProduct : requestProductDto -> ", requestProductDto);
        productService.modifyProduct(id, requestProductDto);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> removeProduct(@PathVariable Long id) {
        log.info("PUT / removeProduct : id -> {}");
        productService.removeProduct(id);
        return new ResponseEntity<>(OK);
    }
}
