package com.example.demo.controller;



import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zxccong
 * @date 2022/3/18
 */
@RestController
@RequestMapping(value = "v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public Flux<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable("id") String id) {
        return this.productService.getProductById(id);
    }

    @PostMapping("")
    public Mono<Void> createProduct(@RequestBody Mono<Product> productMono) {
        return this.productService.createOrUpdateProduct(productMono);
    }

    @DeleteMapping("/{id}")
    public Mono<Product> delete(@PathVariable("id") String id) {
        return this.productService.deleteProduct(id);
    }

}
