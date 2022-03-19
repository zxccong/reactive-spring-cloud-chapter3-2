package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zxccong
 * @date 2022/3/19
 */
@Service
public class ProductService {

    private final Map<String,Product> productMap=new ConcurrentHashMap<>();

    public Flux<Product> getProducts() {
        return Flux.fromIterable(productMap.values());
    }

    public Flux<Product> getProductByIds(final Flux<String> ids) {
        return ids.flatMap(id-> Mono.justOrEmpty(this.productMap.get(id)));
    }

    public Mono<Product> getProductById(String id) {
        return Mono.justOrEmpty(productMap.get(id));
    }

    public Mono<Void> createOrUpdateProduct(Mono<Product> productMono){
        return productMono.doOnNext(product -> {
            productMap.put(product.getId(), product);
        }).thenEmpty(Mono.empty());

    }

    public Mono<Product> deleteProduct(String id){
        return Mono.justOrEmpty(productMap.remove(id));

    }
}
