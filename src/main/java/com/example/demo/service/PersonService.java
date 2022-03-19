package com.example.demo.service;

import com.example.demo.model.Person;
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
public class PersonService {

    private final Map<String, Person> productMap=new ConcurrentHashMap<>();

    public Flux<Person> getProducts() {
        return Flux.fromIterable(productMap.values());
    }

    public Flux<Person> getProductByIds(final Flux<String> ids) {
        return ids.flatMap(id-> Mono.justOrEmpty(this.productMap.get(id)));
    }

    public Mono<Person> getProductById(String id) {
        return Mono.justOrEmpty(productMap.get(id));
    }

    public Mono<Void> createOrUpdateProduct(Mono<Person> productMono){
        return productMono.doOnNext(product -> {
            productMap.put(product.getId(), product);
        }).thenEmpty(Mono.empty());

    }

    public Mono<Person> deleteProduct(String id){
        return Mono.justOrEmpty(productMap.remove(id));

    }
}
